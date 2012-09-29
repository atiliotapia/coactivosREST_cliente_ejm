package com.web.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.xml.bind.Element;
import javax.xml.bind.annotation.XmlAnyElement;

import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.jaxrs.provider.JSONProvider;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.web.bean.Cliente;
import com.web.collection.ClienteCollection;
import com.web.enums.IdiomaEnum;
import com.web.util.Utilitarios;

@Scope("session")
@Controller("usuarioController")
public class CoactivosController {
	String strTest = null;
	
	@XmlAnyElement(lax = true)
	public static List<Element> listaClientes;
	
	static ClienteCollection clienteCollection;
	
	private Collection<Cliente> clientes;

    public CoactivosController() {
    	WebClient webClient = WebClient.create("http://rest-coactivos.aesoluciones.cloudbees.net/rs/cliente-service/clientes");
	    webClient.accept("application/xml");
	    ClienteCollection array = webClient.get(ClienteCollection.class);
	    System.out.println(""+array.getClientes());
	    System.out.println("Sí se pudo.");
    }
	
	private String invokeService(String targetURL) {
        WebClient webClient = WebClient.create(targetURL);
        webClient.accept("application/json");
        return webClient.get(String.class);
    }
	
	private List<Cliente> getListaClientes(String targetURL) {
        WebClient webClient = WebClient.create(targetURL);
        webClient.accept("application/json");
        return new ArrayList<Cliente>(webClient.getCollection(Cliente.class));
    }
	
	public static void main(String[] args) throws Exception {
	    WebClient webClient = WebClient.create("http://rest-coactivos.aesoluciones.cloudbees.net/rs/cliente-service/clientes");
	    webClient.accept("application/xml");
	    ClienteCollection array = webClient.get(ClienteCollection.class);
	    System.out.println(""+array.getClientes());
	    System.out.println("Sí se pudo.");
	}

	// Getters && Setters
	public String getStrTest() {
		return strTest;
	}
	public void setStrTest(String strTest) {
		this.strTest = strTest;
	}

	public Collection<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(Collection<Cliente> clientes) {
		this.clientes = clientes;
	}
}


