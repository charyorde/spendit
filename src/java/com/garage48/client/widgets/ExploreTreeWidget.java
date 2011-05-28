/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.garage48.client.widgets;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Hyperlink;

/**
 *
 * @author Kayode Odeyemi
 */
public class ExploreTreeWidget extends Composite {

    private FlowPanel exploreVP = new FlowPanel();

    public ExploreTreeWidget() {
        exploreVP.setStyleName("gwt-ExploreTree");
        exploreVP.add(new HTML("<h2 class='title'>Explore</h2>"));
        exploreVP.add(new Hyperlink("Get Started", " "));
        exploreVP.add(new Hyperlink("Track your expense", " "));
        exploreVP.add(new Hyperlink("Share your expense", " "));
        //exploreHP.add(exploreMenu);
        initWidget(exploreVP);
    }


}
