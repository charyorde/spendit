/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.garage48.client.view;

import com.google.gwt.place.shared.Place;

/**
 *
 * @author Administrator
 */
public interface HowItWorksView {

    public interface Presenter {
        void goTo(Place place);
    }

    void setPresenter(Presenter p);
}
