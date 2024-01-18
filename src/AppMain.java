import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

//https://mvnrepository.com/artifact/org.junit.platform/junit-platform-console-standalone/1.10.1

public class AppMain {

	// Cuentas ejemplo
	public static CuentaBancaria cejemplo[] = {
			new CuentaBancaria("ES9820346248012554266201",2501),
			new CuentaBancaria("ES9880941735016678433239",2502),
			new CuentaBancaria("ES9820346248012889674522",6003),
			new CuentaBancaria("ES9880941735016678436763",804)};
	private double importe;							// Objeto para el importe
	private  LocalDateTime lfecha;					// Objeto para la fecha
	private CuentaBancaria corigen;						//Cuentas de trabajo
	private CuentaBancaria cdestino;	
	
	public static void main(String[] args) throws ParseException {
		AppMain doBank = new AppMain();
		doBank.runApp();
		System.out.println("Aplicación terminada.");
	} // main
	
	public void runApp() {

		String[] opciones = {"INGRESO EN CUENTA","RETIRADA EFECTIVO","TRANSFERENCIA",
							 "CONSULTA SALDO","ULT. MOVIMIENTOS","BUSCAR MOVIMIENTO"};
		Menu menuCajero = new Menu(opciones);
		boolean resultado=true;		
		boolean salir = false;
		int opcion;
		Cajero miCajero = new Cajero("PALOMA");
		
		while (!salir) {			
			menuCajero.mostrarMenu();
			opcion = menuCajero.eligeOpcion();
			switch (opcion) {		
				case 1:
					pideDatos(Cajero.tipoOperacion.INGRESO);
					resultado=miCajero.realizaOperacion(Cajero.tipoOperacion.INGRESO, corigen, null, importe, null);
					break;
				case 2:
					pideDatos(Cajero.tipoOperacion.RETIRADA);
					resultado=miCajero.realizaOperacion(Cajero.tipoOperacion.RETIRADA, corigen, null, importe, null);
					break;
				case 3:
					pideDatos(Cajero.tipoOperacion.TRANSFERENCIA);
					resultado=miCajero.realizaOperacion(Cajero.tipoOperacion.TRANSFERENCIA, corigen, cdestino, importe, null);
					break;
				case 4:
					pideDatos(Cajero.tipoOperacion.SALDO);
					resultado=miCajero.realizaOperacion(Cajero.tipoOperacion.SALDO, corigen, null, importe, null);
					break;
				case 5:
					pideDatos(Cajero.tipoOperacion.ULTIMOS_MOV);
					resultado=miCajero.realizaOperacion(Cajero.tipoOperacion.ULTIMOS_MOV, corigen, null, importe, null);
					break;
				case 6:
					pideDatos(Cajero.tipoOperacion.BUSCA_MOV);
					resultado=miCajero.realizaOperacion(Cajero.tipoOperacion.BUSCA_MOV, corigen, null, -1, lfecha);
					break;
				case 0:
					salir = true;
					resultado = true;
					break;
			} // switch elección
			if (!resultado) System.out.println("Error al realizar la operación");
		} // bucle de ejecución	
		
	}
	
	private CuentaBancaria eligeCuenta(String cual) {
			
			Scanner sc = new Scanner(System.in);
			System.out.print("Elige cuenta de "+ cual +"(1,2,3,4)?");
			int opc = sc.nextInt();
			return this.cejemplo[opc-1];
		};
	public void pideDatos(Cajero.tipoOperacion tipo) {
			
			Scanner sc = new Scanner(System.in);
			int nc=0;
			String sfecha= "";
			if (tipo== Cajero.tipoOperacion.BUSCA_MOV) {
				DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				System.out.print("Elije fecha ?");
				sfecha = sc.nextLine();
				lfecha = LocalDateTime.parse(sfecha, fmt);
				this.corigen= this.eligeCuenta("Búsqueda");
			}
			else {
				if  ((tipo== Cajero.tipoOperacion.INGRESO) || (tipo == Cajero.tipoOperacion.RETIRADA)
						|| (tipo == Cajero.tipoOperacion.TRANSFERENCIA)) {
					System.out.print("Que importe deseas?");
					importe = sc.nextInt();
				}
				if  ((tipo== Cajero.tipoOperacion.INGRESO) || (tipo == Cajero.tipoOperacion.RETIRADA)) {
					this.corigen= this.eligeCuenta("Origen");
				}
				if  (tipo == Cajero.tipoOperacion.TRANSFERENCIA) {
					this.corigen= this.eligeCuenta("Origen");
					this.cdestino= this.eligeCuenta("Destino");
				}
				if  (tipo == Cajero.tipoOperacion.SALDO) {
					this.corigen= this.eligeCuenta("Origen");			}
			}
		} // pideDatos
		
	
		
		
		
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

} // Class
