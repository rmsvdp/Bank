import java.time.LocalDateTime;

public class Cajero {

	public String[] opeLit = {"INGRESO","RETIRADA","TRANSFERENCIA","SALDO","ULTIMOS_MOV"};
	// La longitud máxima de las operaciones es de 14 caracteres
	// Métodos
	private final int  MEM_SIZE = 100;
	private final int  LIST_SIZE = 10;
	private String idCajero;
	private Movimiento mov[] = new Movimiento[MEM_SIZE];
	private int ultMov;
	public enum tipoOperacion {
		
		INGRESO,RETIRADA,TRANSFERENCIA,SALDO,ULTIMOS_MOV
	}
	
	String getEnum(tipoOperacion op) {
		
		int i = op.ordinal();
		return opeLit[i];
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
				Movimiento m = new Movimiento(ccOrg,null,importe,t,getEnum(tipo));
				this.registraMov(m);
			}
			break;
		case RETIRADA:
			result = ccOrg.retiraDeCuenta((float) importe);
			if (result== true) {
				LocalDateTime t = LocalDateTime.now();
				Movimiento m = new Movimiento(ccOrg,null,importe,t,getEnum(tipo));
				this.registraMov(m);
			}
			break;
		
		case TRANSFERENCIA:
			result = ccOrg.enviaTransferencia(ccDest,(float) importe);
			if (result== true) {
				LocalDateTime t = LocalDateTime.now();
				Movimiento m = new Movimiento(ccOrg,ccDest,importe,t,getEnum(tipo));
				this.registraMov(m);
			}
		break;
		
		case SALDO:
				LocalDateTime t = LocalDateTime.now();
				Movimiento m = new Movimiento(ccOrg,null,ccOrg.getSaldo(),t,getEnum(tipo));
				this.registraMov(m);
			break;
		
		case ULTIMOS_MOV:
			
			
		break;		
				
		
		
		} // switch
		return result;
	}
	
	
	
	public boolean registraMov(Movimiento _movimiento) {
	boolean result = false;
		
	this.mov[this.ultMov] = _movimiento;
	this.ultMov = this.ultMov +1 ;
	//this.ultMov = this.ultMov%MEM_SIZE;
	if (this.ultMov == this.mov.length) {
		this.ultMov = 0;
	}
	
		return result;
		
	}
	public boolean ListaMov(CuentaBancaria ccOrg) {
		boolean result = false;
		int cur_ini;
		cur_ini = this.ultMov - LIST_SIZE;
		if (cur_ini<0) cur_ini = cur_ini + MEM_SIZE;
		for (int i = cur_ini;i<= this.ultMov;i++) {
			
			System.out.println(this.mov[i]);
		}
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
