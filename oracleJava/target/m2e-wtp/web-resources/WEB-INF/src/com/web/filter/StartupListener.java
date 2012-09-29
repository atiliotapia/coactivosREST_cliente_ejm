package com.web.filter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;

public class StartupListener implements ServletContextListener{
	
	public void contextDestroyed(ServletContextEvent arg0){
		
    }
 
    public void contextInitialized(ServletContextEvent sce){
    	try {
			String log4jLocation = sce.getServletContext().getInitParameter("log4j-properties-location");
			String messageLocation = sce.getServletContext().getInitParameter("log4j-messages_es-location");
			ServletContext sc = sce.getServletContext();
			Properties props;
			
			if (log4jLocation == null) {
				System.err.println("NO SE ENCONTRO log4j-properties-location");
				BasicConfigurator.configure();
			}else if(messageLocation == null){
				System.err.println("NO SE ENCONTRO log4j-messages_es-location");
				BasicConfigurator.configure();
			}else{
				//String webAppPath = sc.getRealPath("/");
				String webAppPath = sc.getRealPath(File.separator);
	
				//Obtener parametro de mensaje
				String mensaje = webAppPath + File.separator + messageLocation;
				props = new Properties();
				props.load(new  FileReader(mensaje));
				System.setProperty("rootLogFile",props.getProperty("log4j.file.path") + props.getProperty("log4j.file.name"));
	
				//Asignar valores de configuracion de log
				String log4jProp = webAppPath + File.separator + log4jLocation;
				PropertyConfigurator.configure(log4jProp);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}