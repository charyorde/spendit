/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.garage48.client.activity;

import com.garage48.client.ClientFactory;
import com.garage48.client.MainWidget;
import com.garage48.client.place.HomePlace;
import com.garage48.client.view.HomeView.Presenter;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

/**
 *
 * @author Administrator
 */
public class HomeActivity extends AbstractActivity implements Presenter {

    private ClientFactory clientFactory;
    private EventBus eventBus;
    
    private String homePlaceToken;

    public HomeActivity(HomePlace homePlace, ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
        this.homePlaceToken = homePlace.getHomeplaceToken();
    }

    public void start(AcceptsOneWidget panel, EventBus eventBus) {
        this.eventBus = eventBus;
        MainWidget mainWidget = clientFactory.getApp();
        //set mainWidget token
        //mainWidget.setToken(homePlaceToken);
        panel.setWidget(mainWidget);
    }

    public void goTo(Place place) {
        clientFactory.getPlaceController().goTo(place);
    }

}
