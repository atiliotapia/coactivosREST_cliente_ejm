package com.web.bean;

import javax.ws.rs.Path;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "cliente")
public class Cliente {

	private Integer id;
	private String idExterno;
	private String  descripcion1;
	private String  descripcion2;
	private String  nroIdentificacion;
	private Integer idDistrito;
	private String  direccion;
	private Integer idEstadoDeuda;
	private String  complemento;
	private Integer saldo;
	private Integer complementoIdMoneda;
	private String  fechaSaldo;
    
    
    public Cliente() {}
    

    public Cliente(Integer id,
					String idExterno,
					String descripcion1,
					String descripcion2,
					String nroIdentificacion,
					Integer idDistrito,
					String direccion,
					Integer idEstadoDeuda,
					String complemento,
					Integer saldo,
					Integer complementoIdMoneda,
					String fechaSaldo) {
    	super();
		this.id = id;
		this.idExterno = idExterno;
		this.descripcion1 = descripcion1;
		this.descripcion2 = descripcion2;
		this.nroIdentificacion = nroIdentificacion;
		this.idDistrito = idDistrito;
		this.direccion = direccion;
		this.idEstadoDeuda = idEstadoDeuda;
		this.complemento = complemento;
		this.saldo = saldo;
		this.complementoIdMoneda = complementoIdMoneda;
		this.fechaSaldo = fechaSaldo;
	}
    
    @Path("id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	@Path("idExterno")
	public String getIdExterno() {
		return idExterno;
	}
	public void setIdExterno(String idExterno) {
		this.idExterno = idExterno;
	}

	@Path("descripcion1")
	public String getDescripcion1() {
		return descripcion1;
	}
	public void setDescripcion1(String descripcion1) {
		this.descripcion1 = descripcion1;
	}

	@Path("descripcion2")
	public String getDescripcion2() {
		return descripcion2;
	}
	public void setDescripcion2(String descripcion2) {
		this.descripcion2 = descripcion2;
	}

	@Path("nroIdentificacion")
	public String getNroIdentificacion() {
		return nroIdentificacion;
	}
	public void setNroIdentificacion(String nroIdentificacion) {
		this.nroIdentificacion = nroIdentificacion;
	}

	@Path("idDistrito")
	public Integer getIdDistrito() {
		return idDistrito;
	}
	public void setIdDistrito(Integer idDistrito) {
		this.idDistrito = idDistrito;
	}

	@Path("direccion")
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Path("idEstadoDeuda")
	public Integer getIdEstadoDeuda() {
		return idEstadoDeuda;
	}
	public void setIdEstadoDeuda(Integer idEstadoDeuda) {
		this.idEstadoDeuda = idEstadoDeuda;
	}

	@Path("complemento")
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	@Path("saldo")
	public Integer getSaldo() {
		return saldo;
	}
	public void setSaldo(Integer saldo) {
		this.saldo = saldo;
	}

	@Path("complementoIdMoneda")
	public Integer getComplementoIdMoneda() {
		return complementoIdMoneda;
	}
	public void setComplementoIdMoneda(Integer complementoIdMoneda) {
		this.complementoIdMoneda = complementoIdMoneda;
	}

	@Path("fechaSaldo")
	public String getFechaSaldo() {
		return fechaSaldo;
	}
	public void setFechaSaldo(String fechaSaldo) {
		this.fechaSaldo = fechaSaldo;
	}


	@Override
    public String toString() {
        return String.format(descripcion1);
    }

}
