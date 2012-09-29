/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.web.util;

import java.net.InetAddress;

/**
 * 
 * @author ALDO
 */
public class Utilitarios {
	private static int idioma;
	private static String terminal = obtenerDireccionIp();
	private static int indicadorLogin;

	public static String getTerminal() {
		return terminal;
	}

	public static void setTerminal(String terminal) {
		Utilitarios.terminal = terminal;
	}

	public static int getIdioma() {
		return idioma;
	}

	public static void setIdioma(int idioma) {
		Utilitarios.idioma = idioma;
	}

	private static String obtenerDireccionIp() {
		try {
			return InetAddress.getLocalHost().getHostAddress();
		} catch (Exception ex) {
			ex.printStackTrace();
			return "";
		}
	}

	public static int getIndicadorLogin() {
		return indicadorLogin;
	}

	public static void setIndicadorLogin(int indicadorLogin) {
		Utilitarios.indicadorLogin = indicadorLogin;
	}
	
	

}
