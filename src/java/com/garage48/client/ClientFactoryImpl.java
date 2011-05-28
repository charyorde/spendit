package com.garage48.client;

import com.garage48.client.place.AppPlaceHistoryMapper;
import com.garage48.client.view.AddExpenseView;
import com.garage48.client.view.FeedbackView;
import com.garage48.client.view.FeedbackViewImpl;
import com.garage48.client.view.HowItWorksView;
import com.garage48.client.view.HowItWorksViewImpl;
import com.garage48.client.view.SearchResultView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.garage48.client.service.SearchService;
import com.garage48.client.service.SearchServiceAsync;
import com.garage48.client.view.AddExpenseViewImpl;
import com.garage48.client.view.SearchResultViewImpl;
import com.garage48.client.view.ViewExpenseView;
import com.garage48.client.view.ViewExpenseViewImpl;

public class ClientFactoryImpl implements ClientFactory
{
    private static final EventBus eventBus = new SimpleEventBus();
    private static final PlaceController placeController = new PlaceController(eventBus);
    private final PlaceHistoryMapper historyMapper = GWT.create(AppPlaceHistoryMapper.class);
    private static final HowItWorksView howitworksView = new HowItWorksViewImpl();
    private static final FeedbackView feedbackView = new FeedbackViewImpl();
    private static final SearchResultView searchResultView = new SearchResultViewImpl();
    private static final MainWidget mainwidget = new MainWidget();
    private static final AddExpenseView addExpenseView = new AddExpenseViewImpl();
    private static final ViewExpenseView viewExpenseView = new ViewExpenseViewImpl();

    public static final SearchServiceAsync searchService = GWT.create(SearchService.class);

    public ClientFactoryImpl()
    {
    }
    
    @Override
    public EventBus getEventBus()
    {
            return eventBus;
    }


    @Override
    public PlaceController getPlaceController()
    {
            return placeController;
    }

    @Override
    public MainWidget getApp() {
        return mainwidget;
    }

    @Override
    public PlaceHistoryMapper getHistoryMapper() {
        return historyMapper;
    }

    @Override
    public SearchServiceAsync getSearchService() {
        return searchService;
    }

    @Override
    public SearchResultView getSearchResultView() {
        return searchResultView;
    }

    public HowItWorksView getHowItWorksView() {
        return howitworksView;
    }

    public FeedbackView getFeedbackView() {
        return feedbackView;
    }

    public AddExpenseView getAddExpenseView() {
        return addExpenseView;
    }

    public ViewExpenseView getViewExpenseView() {
        return viewExpenseView;
    }
}
