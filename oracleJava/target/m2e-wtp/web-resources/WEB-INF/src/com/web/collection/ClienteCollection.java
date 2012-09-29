package com.web.collection;

import java.util.Collection;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.web.bean.Cliente;


@XmlRootElement(name = "response")
public class ClienteCollection {

    private Collection<Cliente> clientes;
    
    public ClienteCollection() {
    }

    public ClienteCollection(Collection<Cliente> clientes) {
        this.clientes = clientes;
    }

    @XmlAnyElement
    public Collection<Cliente> getClientes() {
        return clientes;
    }

}
