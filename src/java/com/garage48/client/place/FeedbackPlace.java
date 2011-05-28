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
public class FeedbackPlace extends Place {


    private String feedbackPlace;


    public String getFeedbackPlaceToken() {
        return feedbackPlace;
    }

    public FeedbackPlace(String token) {
        this.feedbackPlace = token;
    }

    public static class FeedbackPlaceTokenizer implements PlaceTokenizer<FeedbackPlace> {

        @Override
        public FeedbackPlace getPlace(String place) {
            return new FeedbackPlace(place);
        }

        @Override
        public String getToken(FeedbackPlace p) {
            return p.getFeedbackPlaceToken();
        }

    }


}
