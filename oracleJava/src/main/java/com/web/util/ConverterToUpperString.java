/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.web.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

public class ConverterToUpperString implements Converter{


    public static String CONVERTER_ID = "gmd.converter";

    public Object getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException {
        return value.toString().toUpperCase();
    }

    public String getAsString(FacesContext context, UIComponent component, Object value) throws ConverterException {
        return value.toString().toUpperCase();
    }
}


