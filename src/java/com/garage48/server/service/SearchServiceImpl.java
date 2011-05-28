/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.garage48.server.service;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.garage48.client.service.SearchService;
import com.garage48.shared.exceptions.RESTfulWebServiceException;

/**
 *
 * @author Administrator
 */
public class SearchServiceImpl extends RemoteServiceServlet implements SearchService {

    final Logger logger = Logger.getLogger(SearchServiceImpl.class.getName());

    private HttpServletRequest request;
    private HttpServletResponse response;
    String serviceDomain, apiKey, serviceURL;

    HttpSession session;

    public SearchServiceImpl() {
        //logger.info(request.toString());
    }

    public String myMethod(String s) {
        // Do something interesting with 's' here on the server.
        return "Server says: " + s;
    }

    //place searchListingService here
    @Override
    public ArrayList<Object> searchListingsService() {
        logger.info("called searchListingsService");
        return this.searchListingsService();
    }

    public Boolean login(String username, String password) {
        return false;
    }

    @Override
    public String serviceLogin(String username, String password) throws RESTfulWebServiceException {
        try {
            URL u = new URL("http://pekuliarproperties/services/rest/user/1");
            HttpURLConnection uc = (HttpURLConnection) u.openConnection();
            uc.setRequestProperty("Content-Type", "application/json");
            uc.setRequestMethod("POST");
            uc.setDoOutput(false);

            Integer status = uc.getResponseCode();
            if (status != 200) {
                    throw (new RESTfulWebServiceException(
                                    "Invalid HTTP response status code " + status + " from web service server."));
            } else {
                logger.info(status.toString());
            }
            logger.info(uc.getResponseMessage());
            return uc.getResponseMessage();
    } catch (MalformedURLException e) {
			throw new RESTfulWebServiceException(e.getMessage(), e);
		}catch (IOException e) {
			throw new RESTfulWebServiceException(e.getMessage(), e);
		}
}
}
