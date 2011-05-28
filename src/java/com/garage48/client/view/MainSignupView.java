/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.garage48.client.view;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

/**
 *
 * @author Administrator
 */
public interface MainSignupView extends IsWidget {

    void setToken(String homeToken);

    HasClickHandlers signup();
    HasClickHandlers signupRequest();
        //UserEntityDTO setData(UserEntityDTO userEntitydto);
    //UserEntityDTO setData();

    public interface Presenter {
        void goTo(Place place);
    }

    void setPresenter(Presenter p);
    
}
