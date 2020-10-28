package com.java.bank.project.model;


public class Cliente {

	Integer idCliente;
	Integer nip;
	Integer noCuenta;
	String nombre;
	Double saldo;
	String foto;
	boolean cuentaActiva;
	
	public Cliente() {};
	
	public Cliente(Integer idCliente, Integer nip, Integer noCuenta, String nombre, Double saldo,
			String foto, boolean cuentaActiva) {
		super();
		this.idCliente = idCliente;
		this.nip = nip;
		this.noCuenta = noCuenta;
		this.nombre = nombre;
		this.saldo = saldo;
		this.foto = foto;
		this.cuentaActiva = cuentaActiva;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public Integer getNip() {
		return nip;
	}

	public void setNip(Integer nip) {
		this.nip = nip;
	}

	public Integer getNoCuenta() {
		return noCuenta;
	}

	public void setNoCuenta(Integer noCuenta) {
		this.noCuenta = noCuenta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public boolean isCuentaActiva() {
		return cuentaActiva;
	}

	public void setCuentaActiva(boolean cuentaActiva) {
		this.cuentaActiva = cuentaActiva;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCliente == null) ? 0 : idCliente.hashCode());
		result = prime * result + ((noCuenta == null) ? 0 : noCuenta.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (idCliente == null) {
			if (other.idCliente != null)
				return false;
		} else if (!idCliente.equals(other.idCliente))
			return false;
		if (noCuenta == null) {
			if (other.noCuenta != null)
				return false;
		} else if (!noCuenta.equals(other.noCuenta))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nip=" + nip + ", noCuenta=" + noCuenta + ", nombre=" + nombre
				+ ", saldo=" + saldo + ", foto=" + foto + ", cuentaActiva=" + cuentaActiva + "]";
	}


	
	
	
	
	
}
