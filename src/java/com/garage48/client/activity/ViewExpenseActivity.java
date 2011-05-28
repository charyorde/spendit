/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.garage48.client.activity;

import com.garage48.client.ClientFactory;
import com.garage48.client.place.ViewExpensePlace;
import com.garage48.client.view.ViewExpenseView;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

/**
 *
 * @author Administrator
 */
public class ViewExpenseActivity extends AbstractActivity implements ViewExpenseView.Presenter {

    private ClientFactory clientFactory;
    private EventBus eventBus;

    private String viewExpensePlaceToken;

    public ViewExpenseActivity(ViewExpensePlace addExpensePlace, ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
        this.viewExpensePlaceToken = addExpensePlace.getViewExpensePlaceToken();
    }


    public void start(AcceptsOneWidget panel, EventBus eventBus) {
        this.eventBus = eventBus;
        ViewExpenseView viewExpenseView = clientFactory.getViewExpenseView();
        viewExpenseView.setToken(viewExpensePlaceToken);
        panel.setWidget(viewExpenseView);
    }

    public void goTo(Place place) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
