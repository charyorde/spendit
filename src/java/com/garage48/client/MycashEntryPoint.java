/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.garage48.client;

import com.garage48.client.activity.AppActivityMapper;
import com.garage48.client.place.AppPlaceHistoryMapper;
import com.garage48.client.place.HomePlace;
import com.garage48.client.resources.ListingsResources;
import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;

/**
 * Main entry point.
 *
 * @author Administrator
 */
public class MycashEntryPoint implements EntryPoint {
    /** 
     * Creates a new instance of MycashEntryPoint
     */

    private Place home = new HomePlace("home");
    private SimplePanel appWidget = new SimplePanel();
    ClientFactory clientFactory = GWT.create(ClientFactory.class);

    private Label historylbl = new Label();

    Boolean gwtcss = ListingsResources.INSTANCE.css().ensureInjected();

    public MycashEntryPoint() {
    }

    /** 
     * The entry point method, called automatically by loading a module
     * that declares an implementing class as an entry-point
     */
    public void onModuleLoad() {

        gwtcss = true;
        
        EventBus eventBus = clientFactory.getEventBus();
	final PlaceController placeController = clientFactory.getPlaceController();
        //MainWidget mainwidget = clientFactory.getApp();

        ActivityMapper activityMapper = new AppActivityMapper(clientFactory);
        ActivityManager activityManager = new ActivityManager(activityMapper, eventBus);
        activityManager.setDisplay(appWidget);

        AppPlaceHistoryMapper apphistoryMapper= GWT.create(AppPlaceHistoryMapper.class);
        PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(apphistoryMapper);
        historyHandler.register(placeController, eventBus, home);

        appWidget.add(historylbl);
        appWidget.setStyleName("main-wrapper");
        RootPanel.get("rootNode").add(appWidget);
        //RootLayoutPanel.get().add(appWidget);
	// Goes to place represented on URL or default place
        historyHandler.handleCurrentHistory();
    }
}
