/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.garage48.server.service;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import com.garage48.client.service.ProductReleaseAlertService;
import com.garage48.server.domain.PMF;
import com.garage48.server.domain.UserEntity;
import com.garage48.shared.UserEntityDTO;
import javax.jdo.PersistenceManager;

/**
 *
 * @author Administrator
 */
public class ProductReleaseAlertServiceImpl extends RemoteServiceServlet implements ProductReleaseAlertService {
    public String myMethod(String s) {
        // Do something interesting with 's' here on the server.
        return "Server says: " + s;
    }

    public Boolean saveReleaseSubscription(UserEntityDTO userEntityDto) {
        UserEntity userentity = new UserEntity();
        userentity.setEmail(userEntityDto.getEmail());
        userentity.setPass(userEntityDto.getPass());
        userentity.setType(userEntityDto.getType());
        boolean added = false;
        PersistenceManager pm = PMF.get().getPersistenceManager();
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
