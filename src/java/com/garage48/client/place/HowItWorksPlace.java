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
public class HowItWorksPlace extends Place {

    private String howitworksPlace;


    public String getHowItWorksplaceToken() {
        return howitworksPlace;
    }

    public HowItWorksPlace(String token) {
        this.howitworksPlace = token;
    }


    public static class HowItWorksPlaceTokenizer implements PlaceTokenizer<HowItWorksPlace> {

        @Override
        public HowItWorksPlace getPlace(String place) {
            return new HowItWorksPlace(place);
        }

        @Override
        public String getToken(HowItWorksPlace p) {
            return p.getHowItWorksplaceToken();
        }

    }

}
