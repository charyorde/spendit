/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.garage48.client.service;

import com.garage48.shared.UserEntityDTO;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 *
 * @author Administrator
 */
@RemoteServiceRelativePath("service/productreleasealertservice")
public interface ProductReleaseAlertService extends RemoteService {
    public String myMethod(String s);

    public Boolean saveReleaseSubscription(UserEntityDTO userEntityDto);
}
