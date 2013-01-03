package com.stocking6.util;

import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class JSFHelper {

	public static ExternalContext getExternalContext(){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		return facesContext.getExternalContext();
	}
	
	public static String getRequestParameter(String parameterName){
		Map<String, String> paramMap = getExternalContext().getRequestParameterMap();
		return paramMap.get(parameterName);
	}
	
	public static Object getRequestAttribute(String attributeName){
		Map<String, Object> attributeMap = getExternalContext().getRequestMap();
		return attributeMap.get(attributeName);
	}
	
	public static Object getSessionAttribute(String attributeName){
		Map<String, Object> attributeMap = getExternalContext().getSessionMap();
		return attributeMap.get(attributeName);
	}
	
	public static Object getApplicationAttribute(String attributeName){
		Map<String, Object> attributeMap = getExternalContext().getApplicationMap();
		return attributeMap.get(attributeName);
	}
}
