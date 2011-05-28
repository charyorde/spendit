/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.garage48.mycash.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import com.mvp4g.client.Mvp4gModule;

/**
 *
 * @author Administrator
 */
public class Dashboard implements EntryPoint {

    public void onModuleLoad() {
        Mvp4gModule module = (Mvp4gModule)GWT.create( Mvp4gModule.class );
		module.createAndStartModule();
		RootLayoutPanel.get().add( (Widget)module.getStartView() );
    }

}
