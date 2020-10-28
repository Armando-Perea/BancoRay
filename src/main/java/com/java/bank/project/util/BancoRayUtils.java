package com.java.bank.project.util;


/*
 * Class: NearSoftUtils
 * Description: This class contains useful operations to create, get and delete information from the Nearsoft Service.
 */
public class BancoRayUtils {

	public static boolean validarFondos(Double saldoCliente, Double pago) {
		return saldoCliente >= pago;
	}

	public static Double sumarACuenta(Double saldoCLiente, double deposito) {
		return saldoCLiente+deposito;
	}
	
	public static Double restarACuenta(Double saldoCLiente, double pago) {
		return saldoCLiente-pago;
	}
	
	

}
