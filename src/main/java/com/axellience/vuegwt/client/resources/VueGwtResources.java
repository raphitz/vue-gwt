package com.axellience.vuegwt.client.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

/**
 * Resources used by Vue GWT
 * @author Adrien Baron
 */
public interface VueGwtResources extends ClientBundle
{
    VueGwtResources JS_RESOURCES = GWT.create(VueGwtResources.class);

    @Source("script.min.js")
    TextResource script();
}
