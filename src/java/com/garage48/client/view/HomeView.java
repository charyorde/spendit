/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.garage48.client.view;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

/**
 *
 * @author Administrator
 */
public interface HomeView extends IsWidget {

    void setToken(String homeToken);
    
    public interface Presenter {
        void goTo(Place place);
    }

    void setPresenter(Presenter p);
}
