package org.generation.util.extras;

import org.generation.util.Imprimible;

public class TarjetaRegalo implements Imprimible{
	
	private int accountNumber;
	private double balance;
	private String name;
	
	public TarjetaRegalo(int accountNumber, double balance, String name) {
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.name = name;
	}
	
	@Override
	public int getNumeroCuenta() {
		return this.accountNumber;
	}
	@Override
	public double getSaldo() {
		return this.balance;
	}
	
	
}
