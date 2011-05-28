/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.garage48.client.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.TextResource;

/**
 *
 * @author Administrator
 */
public interface ListingsResources extends ClientBundle {

    public static final ListingsResources INSTANCE =  GWT.create(ListingsResources.class);

    @Source("gwt.css")
    public CssResource css();

    @Source("add.xhtml")
    public TextResource getUploadFeatureContent();

    @Source("find.xhtml")
    public TextResource getFindFeatureContent();

    @Source("share.xhtml")
    public TextResource getBuyFeatureContent();

    @Source("socialize.xhtml")
    public TextResource getSocializeFeatureContent();

    @Source("featureSlider.xhtml")
    public TextResource getFeatureSliderContent();

    @Source("welcome.xhtml")
    public TextResource getWelcomeContent();

    @Source("logo.png")
    public ImageResource getLogo();

    @Source("sign-with-google.png")
    public ImageResource getOpenIdLogo();

    @Source("report-a-bug.png")
    public ImageResource getBugIcon();

    @Source("help-faq.png")
    public ImageResource getFaqIcon();

    @Source("person1.png")
    public ImageResource getPerson1Image();

    @Source("person2.png")
    public ImageResource getPerson2Image();
    
    @Source("person3.png")
    public ImageResource getPerson3Image();

    @Source("person4.png")
    public ImageResource getPerson4Image();

    @Source("person5.png")
    public ImageResource getPerson5Image();

    @Source("person6.png")
    public ImageResource getPerson6Image();

    @Source("person7.png")
    public ImageResource getPerson7Image();

    @Source("person8.png")
    public ImageResource getPerson8Image();

    @Source("FACEBOOK-ICON-48x48.png")
    public ImageResource getFBImage();

    @Source("TwitterIcon-48x48.png")
    public ImageResource getTwitterImage();

    @Source("mint.png")
    public ImageResource getMobileImage();
}
