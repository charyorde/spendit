/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.garage48.client.widgets;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;

/**
 *
 * @author Administrator
 */
public class IntroVideoWidget extends Composite {

    private Label lbl = new Label("IntroVideoWidget");
    private FlowPanel hp = new FlowPanel();
    private HTML caption = new HTML("<h1 class='title caption'>Track Your Expense</h1>");
    private HTML captiondesc = new HTML("<div class='captiondesc'>Social retailing. Track your expense. "
            + "Share your expense. Explore MyCash.</div>");
    private HTML appdesc = new HTML("<div class='node desc'>MyCash is an avenue for you to keep track of how "
            + "much is going out of your pocket at a granular level. Lets you find informaton "
            + "concerning purchases of goods that you already made. It enables you to get direct and "
            + "factual information without too much speculation concerning a purchase you "
            + "intend making.</div>");
    private HTML getstartedLink = new HTML("<div class='title-desc'><a href='/signup' class='text-button'>Get Started for FREE</a></div>");


    public IntroVideoWidget() {
        //hp.add(lbl);
        hp.setStylePrimaryName("gwt-IntroVideoWrapper");
        initWidget(hp);
        hp.add(caption);
        hp.add(captiondesc);
        hp.add(appdesc);
        hp.add(getstartedLink);
    }
}
