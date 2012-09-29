package com.web.controller;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.web.enums.IdiomaEnum;
import com.web.util.Utilitarios;
import com.web.util.WebUtil;

@Scope("session")
@Controller("usuarioController")
public class UsuarioController {

    public UsuarioController() {
        Utilitarios.setIdioma(IdiomaEnum.ESPANOL.getValor());     
    }

    public String ingresarSistema() {
    	return "principal";
    }
    
    public String cerrarSesion(){
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		session.invalidate();
		WebUtil.sendRedirect("/login/login.jsf");
		return "RELOGEA";
	}
	
	public String irPrincipal(){
		WebUtil.sendRedirect("/paginas/inicio.jsf");
		return "";
	}
    
}


