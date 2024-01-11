import java.time.LocalDateTime;

public class Cajero {

	private String idCajero;
	private Movimiento mov[] = new Movimiento[100];
	private int ultMov;
	public enum tipoOperacion {
		
		INGRESO,RETIRADA,TRANSFERENCIA,SALDO,ULTIMOS_MOV
	}
	
	// Métodos
	
	public Cajero(String idCajero) {
		super();
		this.idCajero = idCajero;
		this.ultMov = 0;
	}

	public boolean operacion(tipoOperacion tipo,CuentaBancaria ccOrg,CuentaBancaria ccDest,double importe) {
		boolean result = false;
		
		return result;
	}
	
	public boolean operacion(tipoOperacion tipo,CuentaBancaria ccOrg,double importe) {
		boolean result = false;
		
		return result;
	}
	
	public boolean operacion(tipoOperacion tipo,CuentaBancaria ccOrg) {
		boolean result = false;
		
		return result;
	}
	
	public boolean operacion(tipoOperacion tipo,CuentaBancaria ccOrg,LocalDateTime fecha) {
		boolean result = false;
		
		return result;
	}
	
	public boolean registraMov(Movimiento mov) {
	boolean result = false;
		
		return result;
		
	}
	public boolean ListaMov(CuentaBancaria ccOrg) {
		boolean result = false;
		
		return result;
	}
	
	public boolean BuscaMov(CuentaBancaria ccOrg,LocalDateTime fini,LocalDateTime ffin) {
		boolean result = false;
		
		return result;
	}
	
	
}
