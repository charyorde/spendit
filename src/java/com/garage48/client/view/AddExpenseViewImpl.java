/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.garage48.client.view;

import com.garage48.client.ClientFactory;
import com.garage48.client.ClientFactoryImpl;
import com.garage48.client.service.AddExpenseService;
import com.garage48.client.service.AddExpenseServiceAsync;
import com.garage48.client.widgets.FooterWidget;
import com.garage48.client.widgets.HeaderWidget;
import com.garage48.client.widgets.UtilHTML;
import com.garage48.shared.ExpensesDTO;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;
import com.google.gwt.user.client.ui.FormPanel.SubmitEvent;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.threerings.gwt.ui.NumberTextBox;

/**
 *
 * @author Administrator
 */
public class AddExpenseViewImpl extends Composite implements AddExpenseView {

    private FlowPanel uploadPanelWrapper = new FlowPanel();
    //Create form panel
    private FormPanel uploadListingFormPanel = new FormPanel();

    // Create a panel to hold all of the form widgets.
    private FlowPanel uploadListingPanelInner = new FlowPanel();

    private FlowPanel listingInfoPanel = new FlowPanel();
    private FlowPanel listingLocationPanel = new FlowPanel();

    private VerticalPanel listingInfoTableFormatter = new VerticalPanel();
    private VerticalPanel listingLocationTableFormatter = new VerticalPanel();

    private Label statusUpdatelbl = new Label();
    private Label historylbl = new Label();

    private TextBox item = new TextBox();
    private TextArea description = new TextArea();
    private NumberTextBox price = new NumberTextBox(true, 9, 9);
    private TextBox address = new TextBox();

    private Presenter presenter;
    private String addExpensePlaceToken;
    public static AddExpenseServiceAsync addExpenseService = GWT.create(AddExpenseService.class);
    private ExpensesDTO expensesdto;
    private ClientFactory clientFactory = new ClientFactoryImpl();

    /*private ViewExpensePlace viewexpenseplace = new ViewExpensePlace("view");

    private String viewExpensehistoryToken = clientFactory.getHistoryMapper().getToken(viewexpenseplace);

    private Hyperlink viewexpenselink = new Hyperlink("View", viewExpensehistoryToken);*/
    
    public AddExpenseViewImpl() {
        initWidget(uploadPanelWrapper);

        uploadPanelWrapper.add(new HeaderWidget());
        uploadPanelWrapper.add(uploadListingFormPanel);
        //uploadPanelWrapper.add(new FileUploaderWidget());
        uploadPanelWrapper.setStyleName("gwt-uploadPanelWrapper");

        uploadListingFormPanel.setAction("/uploadListing");

        // Because we're going to add a FileUpload widget, we'll need to set the
        // form to use the POST method, and multipart MIME encoding.
        uploadListingFormPanel.setEncoding(FormPanel.ENCODING_MULTIPART);
        uploadListingFormPanel.setMethod(FormPanel.METHOD_POST);

        uploadListingFormPanel.setWidget(uploadListingPanelInner);
        uploadListingFormPanel.setStyleName("gwt-uploadListingFormPanel");

        uploadListingPanelInner.add(new HTML("<h2 class='title'>Create Your Expense</h2>"));
        uploadListingPanelInner.add(statusUpdatelbl);
        statusUpdatelbl.setVisible(false);
        statusUpdatelbl.setStyleName("uploadstatuslbl statuslbl");
        uploadListingPanelInner.setStyleName("gwt-uploadListingPanelInner");

        uploadListingPanelInner.add(listingInfoPanel);
        uploadListingPanelInner.add(listingLocationPanel);

        listingInfoPanel.add(listingInfoTableFormatter);

        listingInfoTableFormatter.add(new Label("Title"));
        listingInfoTableFormatter.add(item);
        listingInfoTableFormatter.add(new Label("Description"));
        listingInfoTableFormatter.add(description);
        listingInfoTableFormatter.add(new Label("Price"));
        listingInfoTableFormatter.add(price);

        listingInfoTableFormatter.add(new Label("Address"));
        listingInfoTableFormatter.add(address);

        listingInfoPanel.setStyleName("gwt-listingInfoPanel");

        //listingLocationPanel.add(listingLocationTableFormatter);

        //listingLocationTableFormatter.add(new Label("Address"));
        //listingLocationTableFormatter.add(address);

        listingLocationPanel.setStyleName("gwt-listingLocationPanel");

        uploadListingPanelInner.add(new HTML(new UtilHTML().setDivFloatFix()));

        // Add a 'submit' button.
        uploadListingPanelInner.add(new Button("Submit", new ClickHandler() {
            @Override
          public void onClick(ClickEvent event) {
            uploadListingFormPanel.submit();
          }
        }));

        final AsyncCallback<Boolean> callback = new AsyncCallback<Boolean>() {
            public void onSuccess(Boolean result) {
                //Window.alert("onSuccess succeeds");
                statusUpdatelbl.setVisible(true);
                //statusUpdatelbl.setText("New Expense created successfully. " + viewexpenselink);
                statusUpdatelbl.setText("New Expense created successfully. ");
            }

            public void onFailure(Throwable caught) {
                //Window.alert("onFailure fails");
                statusUpdatelbl.setVisible(true);
                statusUpdatelbl.setText("Communication failed");
            }

        };

        // Add an event handler to the form.
        uploadListingFormPanel.addSubmitHandler(new FormPanel.SubmitHandler() {
          public void onSubmit(SubmitEvent event) {
            // This event is fired just before the form is submitted. We can take
            // this opportunity to perform validation.
              statusUpdatelbl.setVisible(true);
              statusUpdatelbl.setText("Uploading...");
              //uploadListingService.myMethod("I got it", callback);
              addExpenseService.createNewExpense(setNewExpenseData(), callback);
              //presenter.fireCreateNewListing(setNewListingsProxyData());

          }
        });
        uploadListingFormPanel.addSubmitCompleteHandler(new FormPanel.SubmitCompleteHandler() {
          public void onSubmitComplete(SubmitCompleteEvent event) {
            // When the form submission is successfully completed, this event is
            // fired. Assuming the service returned a response of type text/html,
            // we can get the result text here (see the FormPanel documentation for
            // further explanation).
            //Window.alert(event.getResults());
          }
        });


        uploadPanelWrapper.add(new HTML("<div class='clear'></div>"));
        uploadPanelWrapper.add(new FooterWidget());
    }

    public void setToken(String addExpensePlaceToken) {
        this.addExpensePlaceToken = addExpensePlaceToken;
    }

    public void setPresenter(Presenter p) {
        this.presenter = p;
    }

    public ExpensesDTO setNewExpenseData() {
        expensesdto = new ExpensesDTO();
        expensesdto.setItem(item.getValue());
        expensesdto.setDescription(description.getValue());
        expensesdto.setPrice((Double) price.getNumber());
        expensesdto.setAddress(address.getValue());
        return expensesdto;
    }

}
