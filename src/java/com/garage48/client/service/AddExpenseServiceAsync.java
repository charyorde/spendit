/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.garage48.client.service;

import com.garage48.shared.ExpensesDTO;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 *
 * @author Administrator
 */
public interface AddExpenseServiceAsync {
    public void myMethod(String s, AsyncCallback<String> callback);

    public void createNewExpense(ExpensesDTO expensesdto, AsyncCallback<Boolean> callback);
}
