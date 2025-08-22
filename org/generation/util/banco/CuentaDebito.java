package org.generation.util.banco;

import java.util.Date;

public class CuentaDebito extends Cuenta {

	private double montoMinimo;
	
	public CuentaDebito(double saldo, String numeroCliente, Date fechaApertura, String nombreCliente, double montoMinimo) {
		super(saldo, numeroCliente, fechaApertura, nombreCliente);
		this.montoMinimo = montoMinimo;
	}//constructor
	
	public double getMontoMinimo() {
		return montoMinimo;
	}//getMontoMinimo

	public void setMontoMinimo(double montoMinimo) {
		this.montoMinimo = montoMinimo;
	}//setMontoMinimo

	@Override
	public double retiro(double cantidad) {
		if (this.saldo >= cantidad) {
			this.saldo -= cantidad;
		}
		return this.saldo;
	}//retiro

	@Override
	public double deposito(double cantidad) {
		this.setSaldo((this.getSaldo() + cantidad));
		return this.getSaldo();
	}//depósito

	@Override
	public double getSaldo() {
		return this.saldo;
	}//getSaldo

	@Override
	public String toString() {
		return "Cuenta Débito [" + super.toString() + 
				", Monto mínimo=" + montoMinimo + "]";
	}//toString

}
