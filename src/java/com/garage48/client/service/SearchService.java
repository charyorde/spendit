/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.garage48.client.service;

import com.garage48.shared.exceptions.RESTfulWebServiceException;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
@RemoteServiceRelativePath("searchservice")
public interface SearchService extends RemoteService {
    public String myMethod(String s);

    public ArrayList<Object> searchListingsService();

    public Boolean login(String username, String password);

    public String serviceLogin(String username, String password) throws RESTfulWebServiceException;
}
