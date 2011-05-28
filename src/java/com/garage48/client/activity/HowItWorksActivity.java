/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.garage48.client.activity;

import com.garage48.client.ClientFactory;
import com.garage48.client.place.HowItWorksPlace;
import com.garage48.client.view.HowItWorksView;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

/**
 *
 * @author Administrator
 */
public class HowItWorksActivity extends AbstractActivity implements HowItWorksView.Presenter {

    private ClientFactory clientFactory;
    private EventBus eventBus;
    //Place place = GWT.create(Place.class);

    private String howitworksPlaceToken;

    public HowItWorksActivity(HowItWorksPlace howitworksPlace, ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
        this.howitworksPlaceToken = howitworksPlace.getHowItWorksplaceToken();
    }

    public void start(AcceptsOneWidget panel, EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void goTo(Place place) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
