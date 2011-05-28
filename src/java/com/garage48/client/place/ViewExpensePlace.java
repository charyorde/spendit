/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.garage48.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

/**
 *
 * @author Administrator
 */
public class ViewExpensePlace extends Place {


    private String viewExpensePlace;


    public String getViewExpensePlaceToken() {
        return viewExpensePlace;
    }

    public ViewExpensePlace(String token) {
        this.viewExpensePlace = token;
    }

    public static class ViewExpensePlaceTokenizer implements PlaceTokenizer<ViewExpensePlace> {

        @Override
        public ViewExpensePlace getPlace(String place) {
            return new ViewExpensePlace(place);
        }

        @Override
        public String getToken(ViewExpensePlace p) {
            return p.getViewExpensePlaceToken();
        }

    }
}
