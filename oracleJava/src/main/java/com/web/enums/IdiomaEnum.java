/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.web.enums;

/**
 *
 * @author ALDO
 */
public enum IdiomaEnum {

    ESPANOL(1),
    INGLES(2);

    private int valor;

    IdiomaEnum(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
