/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.garage48.client.place;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

/**
 *
 * @author Administrator
 */
@WithTokenizers({HomePlace.HomePlaceTokenizer.class, FeedbackPlace.FeedbackPlaceTokenizer.class, HowItWorksPlace.HowItWorksPlaceTokenizer.class, AddExpensePlace.AddExpensePlaceTokenizer.class})
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {

}
