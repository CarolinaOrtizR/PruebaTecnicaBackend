import java.util.Calendar;
import java.util.HashMap;

import org.generation.util.ReciboSaldo;
import org.generation.util.banco.Cuenta;
import org.generation.util.banco.CuentaCredito;
import org.generation.util.banco.CuentaDebito;

public class SimulaBanco {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2025, Calendar.MAY, 1);
		Calendar calendarCorte = Calendar.getInstance();
		calendarCorte.set(2025, Calendar.MAY, 31);
		Calendar calendarLimitePago = Calendar.getInstance();
		calendarLimitePago.set(2025, Calendar.JUNE, 20);
		
		HashMap<Integer, Cuenta> cuentas = new HashMap<>();
		cuentas.put(1001, new CuentaDebito(2000, "D8001", calendar.getTime(), "Juan Pérez", 1000));
		cuentas.put(1002, new CuentaCredito(0, "C7001", calendar.getTime(),  "María Díaz", 3000.00, 0.35f, calendarCorte.getTime(), calendarLimitePago.getTime()));
		cuentas.put(1003, new CuentaDebito(1500, "D8002", calendar.getTime(), "Jorge Martínez", 1000));
		cuentas.put(1004, new CuentaCredito(0, "C7002", calendar.getTime(), "Mónica Hernández",4500.00, 0.35f, calendarCorte.getTime(), calendarLimitePago.getTime()));
		
		System.out.println(cuentas.get(1001));
		System.out.println(cuentas.get(1002));
		System.out.println(cuentas.get(1003));
		System.out.println(cuentas.get(1004));
		
		//Prueba depósito a Débito
		ReciboSaldo.Imprimir(cuentas.get(1001));
		cuentas.get(1001).deposito(100);
		ReciboSaldo.Imprimir(cuentas.get(1001));
		
		//Prueba retiro a Débito
		ReciboSaldo.Imprimir(cuentas.get(1003));
		cuentas.get(1003).retiro(499.90);
		ReciboSaldo.Imprimir(cuentas.get(1003));
		
		//Prueba depósito a Crédito
		ReciboSaldo.Imprimir(cuentas.get(1002));
		cuentas.get(1002).deposito(1000);
		ReciboSaldo.Imprimir(cuentas.get(1002));
		
		//Prueba retiro a Crédito
		ReciboSaldo.Imprimir(cuentas.get(1004));
		cuentas.get(1004).retiro(380.90);
		ReciboSaldo.Imprimir(cuentas.get(1004));
		
	}//main
}//class Banco
