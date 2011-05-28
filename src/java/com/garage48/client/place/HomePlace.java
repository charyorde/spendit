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
public class HomePlace extends Place {

    private String homeplaceToken;

    public HomePlace(String token) {
        this.homeplaceToken = token;
    }

    public String getHomeplaceToken() {
        return homeplaceToken;
    }

    public static class HomePlaceTokenizer implements PlaceTokenizer<HomePlace> {

        @Override
        public HomePlace getPlace(String place) {
            return new HomePlace(place);
        }

        @Override
        public String getToken(HomePlace p) {
            return p.getHomeplaceToken();
        }

    }
}
