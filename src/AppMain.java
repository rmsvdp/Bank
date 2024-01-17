import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;



//https://mvnrepository.com/artifact/org.junit.platform/junit-platform-console-standalone/1.10.1

public class AppMain {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

		boolean resultado=true;
		
		
		//1.- Crear objetos
		CuentaBancaria c1 = new CuentaBancaria();
		CuentaBancaria c2 = new CuentaBancaria();
		
		// 2.- Darles valores
			// c1 800 €
			// c2 100 €
		c1.setSaldo(800);
		c2.setSaldo(100);
		
		// 3. Hacer la transferencia desde c1 a c2
			// transferir 300 €
		c1.enviaTransferencia(c2, 300);
		
		// 4.- Pintar los saldos de c1 y c2
		
		System.out.println("Saldo de la cuenta 1: " +c1.getSaldo());
		System.out.println("Saldo de la cuenta 2: " +c2.getSaldo());
		
		
		
		
		resultado=c1.ingresaEnCuenta(500);
		resultado=c1.retiraDeCuenta(500);
		if (resultado) {
			System.out.println(c1.getSaldo());
		}
		else {
			System.out.println("Operacion cancelada");
			}
		
		
		// -------------------- main app
		String[] opciones = {"1.INGRESO EN CUENTA","2.RETIRADA EFECTIVO",
				"3.TRANSFERENCIA","4.CONSULTA SALDO","5.ULT. MOVIMIENTOS","6.BUSCAR MOVIMIENTO"};
		Menu menuCajero = new Menu(opciones);
		boolean salir = false;
		int opcion;
		Cajero miCajero = new Cajero("PALOMA");
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		while (!salir) {
			
			menuCajero.mostrarMenu();
			opcion = menuCajero.eligeOpcion();
			
			switch (opcion) {
			
			case 1:
				// Ingreso en cuenta
				miCajero.realizaOperacion(Cajero.tipoOperacion.INGRESO, c1, null, 100, null);
				break;
			case 2:
				miCajero.realizaOperacion(Cajero.tipoOperacion.RETIRADA, c1, null, 100, null);
				break;
			case 3:
				miCajero.realizaOperacion(Cajero.tipoOperacion.TRANSFERENCIA, c1, c2, 100, null);
				break;
			case 4:
				miCajero.realizaOperacion(Cajero.tipoOperacion.SALDO, c1, null, 100, null);
				break;
			case 5:
				miCajero.realizaOperacion(Cajero.tipoOperacion.ULTIMOS_MOV, c1, null, 100, null);
				break;
			case 6:
				miCajero.realizaOperacion(Cajero.tipoOperacion.BUSCA_MOV, c1, null, -1, LocalDateTime.parse("2024-01-01", fmt));
				break;
			case 0:
				salir = true;
				break;
			
			}
			
			
		} // bucle de ejecución
		
		
		/*
		
			
		//0 - Fecha/Hora Actual
		LocalDateTime today = LocalDateTime.now();
		
		//1 - default time pattern
		String time = "2024-01-11T12:05:30";
		LocalDateTime localTimeObj = LocalDateTime.parse(time);
		

		//2 - specific date time pattern
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a");
		String time1 = "2019-03-27 10:15:30 AM";
		LocalDateTime localTimeObj1 = LocalDateTime.parse(time1, formatter);
	
		
		Cajero Paloma1 = new Cajero("PALOMA01");
		CuentaBancaria Marcos = new CuentaBancaria();
		CuentaBancaria Rosa = new CuentaBancaria();
		Paloma1.operacion(Cajero.tipoOperacion.INGRESO, Marcos, 100);
		Paloma1.operacion(Cajero.tipoOperacion.TRANSFERENCIA, Marcos, Rosa, 50);
		Paloma1.operacion(Cajero.tipoOperacion.SALDO, Marcos);
		
		*/
	}

}
