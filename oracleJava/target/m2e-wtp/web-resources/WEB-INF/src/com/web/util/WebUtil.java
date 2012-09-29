package com.web.util;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebUtil {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private static SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
	private static SimpleDateFormat formatoHistorial = new SimpleDateFormat("EEE, yyyy HH:mm:ss ");
	

	public static Object getObjectFromContext(String objectName) {
		HttpServletRequest request = (HttpServletRequest) getFacesContextCurrentInstance().getExternalContext().getRequest();
		return request.getSession(false).getAttribute(objectName);
	}

	public static Object getParameterFromRequest(String parameter) {
		HttpServletRequest request = (HttpServletRequest) getFacesContextCurrentInstance().getExternalContext().getRequest();
		return request.getParameter(parameter);
	}

	public static void setObjectInSession(String objectName, Object object) {
		System.out.println("SE PUSO EN SESION EL OBJETO " + objectName
				+ " DEL TIPO " + object.getClass());
		HttpServletRequest request = (HttpServletRequest) getFacesContextCurrentInstance().getExternalContext().getRequest();
		request.getSession(false).setAttribute(objectName, object);
	}

	public static void removeObjectInSession(String objectName) {
		System.out.println("SE REMOVIO DE SESION EL OBJETO " + objectName);
		HttpServletRequest request = (HttpServletRequest) getFacesContextCurrentInstance().getExternalContext().getRequest();
		request.getSession(false).removeAttribute(objectName);
	}

	private static FacesContext getFacesContextCurrentInstance() {
		return FacesContext.getCurrentInstance();
	}

	public static void sendRedirect(String ruta) {

		FacesContext currentInstance = FacesContext.getCurrentInstance();

		HttpServletResponse response = (HttpServletResponse) currentInstance.getExternalContext().getResponse();
		try {
			currentInstance.responseComplete();

			response.sendRedirect(currentInstance.getExternalContext().getRequestContextPath() + ruta);
		} catch (IOException ioe) {
			
		}
	}
	
	public static Object obtenerControlador(String nombre){
		FacesContext currentInstance = FacesContext.getCurrentInstance();
		return currentInstance.getApplication().getELResolver().getValue(currentInstance.getELContext(), null, nombre);
	}
	
	public static String obtenerParametro(String parametro){
		FacesContext context = FacesContext.getCurrentInstance();
		Map<String, String> requestParameterMap = (Map<String, String>) context.getExternalContext().getRequestParameterMap();
		return requestParameterMap.get(parametro).toString();
	}
	
	public static Map<String, String> obtenerMap(){
		FacesContext context = FacesContext.getCurrentInstance();
		return (Map<String, String>) context.getExternalContext().getRequestParameterMap();		
	}	
	
	public static String convertirCadena(Date fecha){
		return sdf.format(fecha);
	}
	
	public static String convertirCadenaSinHora(Date fecha){
		return sdf1.format(fecha);
	}
	
	public static Date convertirFecha(String fecha) throws ParseException{
		return formato.parse(fecha);
	}
	
	public static String convertirHistorial(Date fecha) throws ParseException{
		return formatoHistorial.format(fecha);
	}

}
