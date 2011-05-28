/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.garage48.client.view;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import com.garage48.client.widgets.HeaderWidget;

/**
 *
 * @author Administrator
 */
public class ViewExpenseViewImpl extends Composite implements ViewExpenseView {

    private FlowPanel viewExpensePanelWrapper = new FlowPanel();

    private String viewExpensePlaceToken;

    private Presenter presenter;

    public ViewExpenseViewImpl() {
        initWidget(viewExpensePanelWrapper);
        //viewExpensePanelWrapper.add(new HeaderWidget());
    }



    public Widget asWidget() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setToken(String viewExpenseToken) {
        this.viewExpensePlaceToken = viewExpenseToken;
    }

    public void setPresenter(Presenter p) {
        this.presenter = p;
    }

}
