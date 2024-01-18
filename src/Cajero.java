import java.time.LocalDateTime;

public class Cajero {

	public String[] opeLit = {"INGRESO","RETIRADA","TRANSFERENCIA","SALDO","ULTIMOS_MOV"};
	private final int  MEM_SIZE = 100;
	private final int  LIST_SIZE = 10;
	private String idCajero;
	private Movimiento mov[] = new Movimiento[MEM_SIZE];
	private int ultMov;
	public enum tipoOperacion {	INGRESO,RETIRADA,TRANSFERENCIA,SALDO,ULTIMOS_MOV,BUSCA_MOV	}
	

	public Cajero(String idCajero) {
		super();
		this.idCajero = idCajero;
		this.ultMov = 0;
	} // Cajero
	public boolean realizaOperacion(tipoOperacion tipo,CuentaBancaria ccOrg,CuentaBancaria ccDest,double importe,LocalDateTime fecha) {
		boolean result = true;
		LocalDateTime t ; 
		Movimiento m;
		switch (tipo) {		
			case INGRESO:
				result = ccOrg.ingresaEnCuenta((float) importe);
				if (result== true) {
					 t = LocalDateTime.now();
					m = new Movimiento(ccOrg,null,importe,t,getLiteral(tipo));
					result = this.registraMov(m);
				}
				break;
			case RETIRADA:
				result = ccOrg.retiraDeCuenta((float) importe);
				if (result== true) {
					t = LocalDateTime.now();
					m = new Movimiento(ccOrg,null,importe,t,getLiteral(tipo));
					result = this.registraMov(m);
				}
				break;
			case TRANSFERENCIA:
				result = ccOrg.enviaTransferencia(ccDest,(float) importe);
				if (result== true) {
					 t = LocalDateTime.now();
					m = new Movimiento(ccOrg,ccDest,importe,t,getLiteral(tipo));
					result = this.registraMov(m);
				}
				break;
			case SALDO:  // OK
					System.out.println("Saldo en cuenta : " + ccOrg.getCCC()+ " -> " + ccOrg.getSaldo());
					t = LocalDateTime.now();
					m = new Movimiento(ccOrg,null,ccOrg.getSaldo(),t,getLiteral(tipo));
					result = this.registraMov(m);
				break;
			case ULTIMOS_MOV:
				this.ListaMov(ccOrg);
				t = LocalDateTime.now();
				m = new Movimiento(ccOrg,null,-1,t,getLiteral(tipo));
				result = this.registraMov(m);
				break;		
			case BUSCA_MOV:				//TODO Immplentar buscarMovimiento
				result = this.BuscaMov(ccOrg, fecha);
				break;		
		} // switch
		return result;
	} // realizaOperacion
		
	private boolean registraMov(Movimiento _movimiento) {
		boolean result = true;
		this.mov[this.ultMov] = _movimiento;
		this.ultMov = this.ultMov +1 ;
		//this.ultMov = this.ultMov%MEM_SIZE;
		if (this.ultMov == this.mov.length) {
			this.ultMov = 0;
		}
		return result;
	} // registraMov
	private boolean ListaMov(CuentaBancaria ccOrg) {
		boolean result = true;
		int cur_ini;
		cur_ini = this.ultMov - LIST_SIZE;
		if (cur_ini<0) cur_ini = cur_ini + MEM_SIZE;
		System.out.println(buildHeader());
		System.out.println();
		for (int i = cur_ini;i<= this.ultMov;i++) {		
			System.out.println(this.mov[i]);
		}
		return result;
	} // ListaMov
	private boolean BuscaMov(CuentaBancaria ccOrg,LocalDateTime fbusq) {
		boolean result = false;	
		return result;
	}
	private String getLiteral(tipoOperacion op) {
		int i = op.ordinal();
		return opeLit[i];
	}
	private String buildHeader() {
		return String.format("%-32s", "FECHA")+ String.format("%-14s", "OPERACIÓN")+ String.format("%-14s", "ORIGEN")+
				   String.format("%-14s", "DESTINO")+ String.format("%-6s", "IMPORTE") + "\n"+
				   String.format("%-80s", " ").replace(' ','-');
	} // buildHeader

} // Cajero Class
