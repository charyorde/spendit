/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.garage48.web;

import com.garage48.server.dao.UserEntityDAOImpl;
import com.garage48.server.domain.PMF;
import java.util.HashMap;
import java.util.Map;
//import org.apache.log4j.Logger;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import com.garage48.server.domain.UserEntity;
import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.SessionScope;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Administrator
 */
@Controller
//@RequestMapping("/signup")
//public class SignupController extends SimpleFormController {
public class SignupController {

    private static final Logger log = Logger.getLogger(SignupController.class.getName());

    private UserEntity userentity;
    private SessionScope appSess;
    private HttpSession session;

    private UserEntityDAOImpl userentitydao ;

    public SignupController() {
       this.userentitydao = new UserEntityDAOImpl();
    }

    /*@Autowired
    public SignupController(UserEntity userentity) {
        this.userentity = userentity;
    }*/

    /**
     * @return the userentity
     */
    public UserEntity getUserentity() {
        return userentity;
    }
    public void setUserentity(UserEntity userentity) {
        this.userentity = userentity;
    }
    
    /**
     * @param session the session to set
     
    public void setSession(HttpSession session) {
        this.session = session;
    }*/

    /**
     * @param appSess the appSess to set
     */
    public void setAppSess(SessionScope appSess) {
        this.appSess = appSess;
    }

    @RequestMapping("/signup")
	public ModelAndView signupHandler() {
		//ModelAndView mav = new ModelAndView("signup");
		Map dataMap = new HashMap();
                userentity = new UserEntity();
                dataMap.put("userentity", userentity);
                //model.addAttribute("userentity", userentity);
                return new ModelAndView("signup", dataMap);
	}

    @RequestMapping("success")
    public String getSuccess(HttpServletRequest request, ModelMap model) {
        Map userData = new HashMap();
        userentity = new UserEntity();
        userData.put("userentity", userentity);
        model.addAttribute("agententity", userentity);
        createUser(request);
        return "success";
    }
    /*@RequestMapping(method=RequestMethod.POST)
    public String processSubmit(@ModelAttribute UserEntity userentity) {
        //validate form, store data in the database and pass parameters to the url
        UserEntityDAOImpl.createNewUser(userentity);
        return "redirect:/"; //Redirects to an existing url. Redirects to homepage
    }*/

    private static Boolean createUser(HttpServletRequest request) {
        log.info("calling createUser in SignupController");

        PersistenceManager pm = PMF.get().getPersistenceManager();
        boolean added = false;

        UserEntity userentity = new UserEntity();
        userentity.setEmail(request.getParameter("email"));
        userentity.setPass(request.getParameter("pass"));
        try {
            pm.makePersistent(userentity);
            added = true;
        }
        finally {
            pm.close();
        }
        return added;
    }
}
   