/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.garage48.mycash.client.presenter;

import com.garage48.mycash.client.DashboardEventBus;
import com.garage48.mycash.client.presenter.DashboardViewPresenter.DashboardView;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

/**
 *
 * @author Administrator
 */
@Presenter(view = DashboardView.class)
public class DashboardViewPresenter extends BasePresenter<DashboardViewPresenter.DashboardView, DashboardEventBus> {

    public interface DashboardView {
        
    }
}
