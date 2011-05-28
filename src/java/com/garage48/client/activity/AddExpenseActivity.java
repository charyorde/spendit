/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.garage48.client.activity;

import com.garage48.client.ClientFactory;
import com.garage48.client.place.AddExpensePlace;
import com.garage48.client.view.AddExpenseView;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

/**
 *
 * @author Administrator
 */
public class AddExpenseActivity extends AbstractActivity implements AddExpenseView.Presenter{

    private ClientFactory clientFactory;
    private EventBus eventBus;

    private String addExpensePlaceToken;

    public AddExpenseActivity(AddExpensePlace addExpensePlace, ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
        this.addExpensePlaceToken = addExpensePlace.getAddExpensePlaceToken();
    }


    public void start(AcceptsOneWidget panel, EventBus eventBus) {
        this.eventBus = eventBus;
        AddExpenseView addExpenseView = clientFactory.getAddExpenseView();
        addExpenseView.setToken(addExpensePlaceToken);
        panel.setWidget(addExpenseView);
    }

    public void goTo(Place place) {
        clientFactory.getPlaceController().goTo(place);
    }

}
