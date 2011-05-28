/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.garage48.client;

import com.garage48.client.place.AddExpensePlace;
import com.garage48.client.resources.ListingsResources;
import com.garage48.client.service.ProductReleaseAlertService;
import com.garage48.client.service.ProductReleaseAlertServiceAsync;
import com.garage48.client.view.HomeView;
import com.garage48.client.view.MainSignup;
import com.garage48.client.widgets.ExploreTreeWidget;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import java.util.logging.Logger;
import com.garage48.client.widgets.HeaderWidget;
import com.garage48.client.widgets.IntroVideoWidget;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.garage48.client.widgets.FooterWidget;
import com.garage48.shared.ExpensesDTO;
import com.garage48.shared.UserEntityDTO;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;

/**
 *
 * @author Kayode Odeyemi
 */
public class MainWidget extends Composite implements HomeView {

    private Logger logger = Logger.getLogger(MainWidget.class.getName());

    private final FlowPanel panel = new FlowPanel();
    private HeaderWidget headerWidget = new HeaderWidget();
    private final DockLayoutPanel frontdlptop = new DockLayoutPanel(Unit.EM);

    private ClientFactory clientFactory = new ClientFactoryImpl();
    //private HomePlace homeplace = new HomePlace("home");
    //private String historyToken = clientFactory.getHistoryMapper().getToken(homeplace);

    private IntroVideoWidget introwidget = new IntroVideoWidget();
    private MainSignup frontsignupWidget = new MainSignup();
    private ExploreTreeWidget exploreTreeWidget = new ExploreTreeWidget();

    private Presenter presenter;

    ListingsResources resources = GWT.create(ListingsResources.class);
    public static ProductReleaseAlertServiceAsync productReleaseService = GWT.create(ProductReleaseAlertService.class);

    UserEntityDTO userentitydto;

    public MainWidget() {
        
        initWidget(panel);
        panel.setStyleName("gwt-innerContainer");
        panel.add(headerWidget);

        frontdlptop.setStyleName("gwt-frontdlptop");
        frontdlptop.addWest(introwidget, 74);
        frontdlptop.addEast(frontsignupWidget, 25);
        /*frontdlptop.setWidth("947px");*/
        frontdlptop.setHeight("300px");
        panel.add(frontdlptop);
        //panel.add(introwidget);
        //panel.add(frontsignupWidget);
        panel.add(exploreTreeWidget);
        panel.add(new FrontContentPanel());
        panel.add(new HTML("<div class='clear'></div>"));
        panel.add(new ImageCarousel());
        panel.add(new HTML("<div class='clear'></div>"));
        panel.add(new ServicesContentArea());
        panel.add(new HTML("<div class='clear'></div>"));
        panel.add(new FooterWidget());

    }

    public void setPresenter(Presenter p) {
        this.presenter = p;
    }

    public void setToken(String homePlaceToken) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    class FrontContentPanel extends Composite implements DoFrontContentAction {

        FlowPanel frontcontentpanel = new FlowPanel();
        //FlowPanel contentWrapper = new FlowPanel();
        FlexTable featureGrid = new FlexTable();
        //HTML slider = new HTML();

        String featureSliderfile = ListingsResources.INSTANCE.getFeatureSliderContent().getText();
        String uploadhtmlfile = ListingsResources.INSTANCE.getUploadFeatureContent().getText();
        String findhtmlfile = ListingsResources.INSTANCE.getFindFeatureContent().getText();
        String buyhtmlfile = ListingsResources.INSTANCE.getBuyFeatureContent().getText();
        String socializehtmlfile = ListingsResources.INSTANCE.getSocializeFeatureContent().getText();

        Button upload = new Button("Add");

        //final UploadListingPlace uploadListingPlace = new UploadListingPlace("uploadlisting");
        final AddExpensePlace addExpensePlace = new AddExpensePlace("add");

        //String uploadListingToken = clientFactory.getHistoryMapper().getToken(uploadListingPlace);
        private String addExpenseToken = clientFactory.getHistoryMapper().getToken(addExpensePlace);

        public FrontContentPanel() {

            frontcontentpanel.setStyleName("gwt-FrontContentArea");
            frontcontentpanel.add(upload);

            frontcontentpanel.add(new HTML(featureSliderfile));
            featureGrid.setBorderWidth(1);
            featureGrid.setCellPadding(3);
            featureGrid.setCellSpacing(3);
            featureGrid.addStyleName("gwt-featureGrid");
            frontcontentpanel.add(featureGrid);

            //featureGrid.rem
            featureGrid.setHTML(0, 0, uploadhtmlfile);
            featureGrid.setHTML(0, 1, findhtmlfile);
             featureGrid.setWidget(1, 0, upload);
            featureGrid.setHTML(2, 0, buyhtmlfile);
            featureGrid.setHTML(2, 1, socializehtmlfile);


            int rowAtZero = featureGrid.getCellCount(0);
            //Window.alert(java.lang.Integer.toString(rowAtZero));
            //store rowAtZero into an int array
            //featureGrid.insertCells(0, 0, 0) ;
            //rowAtZero[0] = the cell I want. get the first cell in the row
            //if rowAtZero[0].length < -1
            /*if() {(String)
                featureGrid.insertCells(0, 0, 0)
                featureGrid.add(upload);
            }*/

            FlexTable.FlexCellFormatter cf = featureGrid.getFlexCellFormatter();
            //cf.setRowSpan(0, 0, 1);
            //cf.addStyleName(0, 0, "sometablestylesheet");
            //featureGrid.insertCells(1, 1, 4);

            callUploadView().addClickHandler(new ClickHandler() {

                @Override
                public void onClick(ClickEvent ce) {
                    logger.info("add button called");
                    //Window.alert("add button called");
                    clientFactory.getPlaceController().goTo(new AddExpensePlace(addExpenseToken));


                }
            });

            initWidget(frontcontentpanel);
        }

        @Override
        public HasClickHandlers callUploadView() {
            return upload;
        }
    }

    class ImageCarousel extends Composite {

        private FlowPanel imageWrapper = new FlowPanel();
      
        Image person1 = new Image(resources.getPerson1Image());
        Image person2 = new Image(resources.getPerson2Image());
        Image person3 = new Image(resources.getPerson3Image());
        Image person4 = new Image(resources.getPerson4Image());
        Image person5 = new Image(resources.getPerson5Image());
        Image person6 = new Image(resources.getPerson6Image());
        Image person7 = new Image(resources.getPerson7Image());
        Image person8 = new Image(resources.getPerson8Image());

        public ImageCarousel() {
            initWidget(imageWrapper);
            imageWrapper.add(new HTML("<h3> See Who's on MyCash"));
            imageWrapper.add(person1);
            imageWrapper.add(person2);
            imageWrapper.add(person3);
            imageWrapper.add(person4);
            imageWrapper.add(person5);
            imageWrapper.add(person6);
            imageWrapper.add(person7);
            imageWrapper.add(person8);
            imageWrapper.setStyleName("imageCarouselWrapper");
        }

    }
    class ServicesContentArea extends Composite {

        FlowPanel servicePanelWrapper = new FlowPanel();

        FlexTable serviceGrid = new FlexTable();

        //Coupon grid
        FlowPanel couponGrid = new FlowPanel();
        HTML couponGridTitle = new HTML("<div>Get notified when we launch and get a FREE coupon</div>");
        Label couponGridlbl = new Label("Email");
        Button couponbtn = new Button("GO");
        TextBox couponGridEmailTextBox = new TextBox();


        //MyCash on mobile
        FlowPanel mobilePanel = new FlowPanel();
        Image mobileimg = new Image(resources.getMobileImage());
        HTML mobiledesc = new HTML("<div>Get MyCash on Android and Feature Phones</div>");
        
        //MyCash on Facebook and Twitter
        FlowPanel socialPanel = new FlowPanel();
        HTML socialdesc = new HTML("<div>Follow Us</div>");
        Image fbImg = new Image(resources.getFBImage());
        Image twImg = new Image(resources.getTwitterImage());


        public ServicesContentArea() {
            initWidget(servicePanelWrapper);
            servicePanelWrapper.add(serviceGrid);
            servicePanelWrapper.setStyleName("gwt-ServiceContentArea");

            //coupinGrid
            couponGrid.add(couponGridTitle);
            couponGrid.add(couponGridlbl);
            couponGrid.add(couponGridEmailTextBox);
            couponGrid.add(couponbtn);
            couponGrid.setStyleName("couponGrid");

            //mobilePanel
            mobilePanel.add(mobileimg);
            mobilePanel.add(mobiledesc);
            mobilePanel.setStyleName("mobilePanel");

            //socialPanel
            socialPanel.add(socialdesc);
            socialPanel.add(fbImg);
            socialPanel.add(twImg);
            socialPanel.setStyleName("socialPanel");
            //serviceGrid
            serviceGrid.setBorderWidth(1);
            serviceGrid.setCellPadding(3);
            serviceGrid.setCellSpacing(3);
            serviceGrid.addStyleName("gwt-serviceGrid");
            serviceGrid.setWidget(0, 0, couponGrid);
            serviceGrid.setWidget(0, 1, mobilePanel);
             serviceGrid.setWidget(0, 2, socialPanel);


        final AsyncCallback<Boolean> callback = new AsyncCallback<Boolean>() {
            public void onSuccess(Boolean result) {
                Window.alert("Thank you. You will be the first to be notified");
            }

            public void onFailure(Throwable caught) {
                Window.alert("Oops! Something went wrong.");
            }

        };

             doReleaseAlert().addClickHandler(new ClickHandler() {

                public void onClick(ClickEvent event) {
                    productReleaseService.saveReleaseSubscription(setUserEntityDataForProductAlert(), callback);
                }

             });

             fbImg.addClickHandler(new ClickHandler() {

                public void onClick(ClickEvent event) {
                    Window.Location.assign("http://www.facebook.com/pages/MyCash/186016464779118");
                }

             });

             twImg.addClickHandler(new ClickHandler() {

                public void onClick(ClickEvent event) {
                    Window.Location.assign("http://twitter.com/mycashg48");
                }


             });
        }

        public HasClickHandlers doReleaseAlert() {
            return couponbtn;
        }


    public UserEntityDTO setUserEntityDataForProductAlert() {
        userentitydto = new UserEntityDTO();
        userentitydto.setEmail(couponGridEmailTextBox.getValue());
        return userentitydto;
    }

    }
}
