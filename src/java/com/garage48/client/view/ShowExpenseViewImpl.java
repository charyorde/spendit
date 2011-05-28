/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.garage48.client.view;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;

/**
 *
 * @author Administrator
 */
public class ShowExpenseViewImpl extends Composite implements ShowExpense {

    private FlowPanel panel = new FlowPanel();

    public ShowExpenseViewImpl() {
        initWidget(panel);
    }

    public void setToken(String homeToken) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setPresenter(Presenter p) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
