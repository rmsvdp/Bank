import java.time.LocalDateTime;

public class Cajero {

	public String[] opeLit = {"INGRESO","RETIRADA","TRANSFERENCIA","SALDO","ULTIMOS_MOV"};
	// La longitud máxima de las operaciones es de 14 caracteres
	// Métodos
	private String idCajero;
	private Movimiento mov[] = new Movimiento[100];
	private int ultMov;
	public enum tipoOperacion {
		
		INGRESO,RETIRADA,TRANSFERENCIA,SALDO,ULTIMOS_MOV
	}
	
	public Cajero(String idCajero) {
		super();
		this.idCajero = idCajero;
		this.ultMov = 0;
	}

	
	public boolean realizaOperacion(tipoOperacion tipo,CuentaBancaria ccOrg,CuentaBancaria ccDest,double importe) {
		boolean result = false;
		switch (tipo) {
		
		case INGRESO:
			result = ccOrg.ingresaEnCuenta((float) importe);
			if (result== true) {
				LocalDateTime t = LocalDateTime.now();
				Movimiento m = new Movimiento(ccOrg,null,importe,
						t,"INGRESO");
				this.registraMov(m);
			}
			break;
		case RETIRADA:
			break;
				
		}
		return result;
	}
	
	
	
	public boolean registraMov(Movimiento _movimiento) {
	boolean result = false;
		
	this.mov[this.ultMov] = _movimiento;
	this.ultMov = this.ultMov +1 ;
	if (this.ultMov == this.mov.length) {
		this.ultMov = 0;
	}
	
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
	
	
	
	
	
	/*
	
	
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
	
*/
	
	
}
