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
public class AddExpensePlace extends Place {


    private String addExpensePlace;


    public String getAddExpensePlaceToken() {
        return addExpensePlace;
    }

    public AddExpensePlace(String token) {
        this.addExpensePlace = token;
    }

    public static class AddExpensePlaceTokenizer implements PlaceTokenizer<AddExpensePlace> {

        @Override
        public AddExpensePlace getPlace(String place) {
            return new AddExpensePlace(place);
        }

        @Override
        public String getToken(AddExpensePlace p) {
            return p.getAddExpensePlaceToken();
        }

    }

}
