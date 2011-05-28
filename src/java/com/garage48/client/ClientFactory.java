package com.garage48.client;

import com.garage48.client.view.FeedbackView;
import com.garage48.client.view.HowItWorksView;
import com.garage48.client.view.SearchResultView;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.garage48.client.service.SearchServiceAsync;
import com.garage48.client.view.AddExpenseView;
import com.garage48.client.view.ViewExpenseView;

public interface ClientFactory
{
	EventBus getEventBus();
	PlaceController getPlaceController();
        PlaceHistoryMapper getHistoryMapper();
        
        HowItWorksView getHowItWorksView();
        FeedbackView getFeedbackView();

        MainWidget getApp();
        
        SearchServiceAsync getSearchService();

        SearchResultView getSearchResultView();

        AddExpenseView getAddExpenseView();

        ViewExpenseView getViewExpenseView();
}
