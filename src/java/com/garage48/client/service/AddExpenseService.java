/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.garage48.client.service;

import com.garage48.shared.ExpensesDTO;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 *
 * @author Administrator
 */
@RemoteServiceRelativePath("service/addexpenseservice")
public interface AddExpenseService extends RemoteService {
    public String myMethod(String s);

    public Boolean createNewExpense(ExpensesDTO expensesdto);
}
