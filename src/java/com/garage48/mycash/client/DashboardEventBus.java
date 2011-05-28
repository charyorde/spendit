/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.garage48.mycash.client;

import com.garage48.mycash.client.view.DashboardViewImpl;
import com.mvp4g.client.annotation.Events;
import com.mvp4g.client.annotation.Start;
import com.mvp4g.client.event.EventBus;

/**
 *
 * @author Administrator
 */
@Events(startView = DashboardViewImpl.class)
public interface DashboardEventBus extends EventBus {

    @Start
    public void start();
}
