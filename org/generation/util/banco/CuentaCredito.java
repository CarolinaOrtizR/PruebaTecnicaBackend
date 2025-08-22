package org.generation.util.banco;

import java.util.Date;

public class CuentaCredito extends Cuenta {

	private double limite;
	private float tasa;
	private Date fechaCorte;
	private Date fechaLimiteDePago;

	public CuentaCredito(double saldo, String numeroCliente, Date fechaApertura, String nombreCliente, double limite,
			float tasa, Date fechaCorte, Date fechaLimiteDePago) {
		super(saldo, numeroCliente, fechaApertura, nombreCliente);
		this.limite = limite;
		this.tasa = tasa;
		this.fechaCorte = fechaCorte;
		this.fechaLimiteDePago = fechaLimiteDePago;
	}//constructor
	
	public double getLimite() {
		return limite;
	}//getLimite

	public void setLimite(double limite) {
		this.limite = limite;
	}//setLimite

	public float getTasa() {
		return tasa;
	}//getTasa

	public void setTasa(float tasa) {
		this.tasa = tasa;
	}//setTasa

	public Date getFechaCorte() {
		return fechaCorte;
	}//getFechaCorte

	public void setFechaCorte(Date fechaCorte) {
		this.fechaCorte = fechaCorte;
	}//setFechaCorte


	public Date getFechaLimiteDePago() {
		return fechaLimiteDePago;
	}//getFechaLimiteDePago


	public void setFechaLimiteDePago(Date fechaLimiteDePago) {
		this.fechaLimiteDePago = fechaLimiteDePago;
	}//setFechaLimiteDePago


	@Override
	public double retiro(double cantidad) {
		if ((this.limite - this.saldo) >= cantidad) {
			//Aumento de saldo por el retiro:
			this.saldo += cantidad;
			
			//Cobro de comisión del 5% del retiro:
			this.saldo += (cantidad * 0.05);
			
		}else {
			//Cobrar $5 de comisión:
			this.saldo += 5;
		}
		return this.saldo;
	}

	@Override
	public double deposito(double cantidad) {
		this.saldo -= cantidad;
		return this.saldo;
	}

	@Override
	public double getSaldo() {
		//Regresa el saldo de la cuenta y cobra una comisión de $3 pesos por cada solicitud de saldo
		//Como es crédito, la comisión se suma
		this.saldo += 3.00f;
		return this.saldo;
	}
	
	@Override
	public String toString() {
		return "Cuenta Crédito [" + super.toString() +
				" Tasa=" + getTasa() + "%, Límite="
				+ getLimite() + "]";
	}//toString

}
