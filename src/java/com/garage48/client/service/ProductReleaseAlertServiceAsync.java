/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.garage48.client.service;

import com.garage48.shared.UserEntityDTO;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 *
 * @author Administrator
 */
public interface ProductReleaseAlertServiceAsync {
    public void myMethod(String s, AsyncCallback<String> callback);

    public void saveReleaseSubscription(UserEntityDTO userEntityDto, AsyncCallback<Boolean> callback);
}
