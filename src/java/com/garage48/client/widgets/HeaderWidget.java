/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.garage48.client.widgets;

import com.garage48.client.ClientFactory;
import com.garage48.client.ClientFactoryImpl;
import com.garage48.client.place.AddExpensePlace;
import com.garage48.client.resources.ListingsResources;
import com.garage48.client.view.HeaderView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Image;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class HeaderWidget extends Composite implements HeaderView {

    private Logger logger = Logger.getLogger(HeaderWidget.class.getName());

    //private DecoratorPanel menuRoundedPanel = new DecoratorPanel();
    private FlowPanel headerWrapper = new FlowPanel();
    private HorizontalPanel headerLinksPanel = new HorizontalPanel();
    private FlowPanel menuPanel = new FlowPanel();
    private FlowPanel mainNavigation = new FlowPanel();
    private HTML logo;

    private static final String REMOTE_HOST = "http://mycashg48.appspot.com";

    private ClientFactory clientFactory = new ClientFactoryImpl();

    private AddExpensePlace addexpenseplace = new AddExpensePlace("add");

    private String historyToken = clientFactory.getHistoryMapper().getToken(addexpenseplace);

    private HTML homelink = new HTML("<a href=" + REMOTE_HOST + ">Home" + "</a>");
    
    private Hyperlink addexpenselink = new Hyperlink("Create an Expense", historyToken);

    ListingsResources resources = GWT.create(ListingsResources.class);
    Image img = new Image(resources.getLogo());
    Image bugimg = new Image(resources.getBugIcon());
    Image faqicon = new Image(resources.getFaqIcon());

    //String logoimg = ListingsResources.INSTANCE.getLogo().getURL();

    public HeaderWidget() {
        initWidget(headerWrapper);
        headerWrapper.setStyleName("header-group-wrapper");
        headerWrapper.add(new HTML("<div id='logo'>" + img + "</div>"));
        headerWrapper.add(headerLinksPanel);

        headerLinksPanel.add(bugimg);
        headerLinksPanel.add(new Hyperlink("Report a bug", " "));
        headerLinksPanel.add(faqicon);
        headerLinksPanel.add(new Hyperlink("FAQs", " "));
        headerLinksPanel.setStylePrimaryName("gwt-headerLinksWrapper");
        //headerWrapper.add(menuRoundedPanel);
        //headerWrapper.add(new HTML("<div class='clear-block'></div>"));
        headerWrapper.add(new HTML("<div class='clearfix'></div>"));
        headerWrapper.add(menuPanel);

        menuPanel.setStylePrimaryName("gwt-menuPanel");
        menuPanel.add(mainNavigation);

        mainNavigation.setStyleName("primary-menu");
        mainNavigation.add(homelink);
        homelink.addStyleName("menu-item");
        //mainNavigation.add(new HTML("<a href=" + REMOTE_HOST + ">Create an Expense" + "</a>"));
        addexpenselink.addStyleName("menu-item");
        mainNavigation.add(addexpenselink);

        createExpense().addClickHandler(new ClickHandler() {

                @Override
                public void onClick(ClickEvent ce) {
                    //logger.info("upload button called");
                    //Window.alert("upload button called");
                    clientFactory.getPlaceController().goTo(new AddExpensePlace(historyToken));


                }
        });

    }


    public HasClickHandlers createExpense() {
        return addexpenselink;
    }
}
