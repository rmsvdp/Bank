import java.time.LocalDateTime;



public class Movimiento {

	private CuentaBancaria corigen;
	private CuentaBancaria cdestino;
	private double importe;
	private LocalDateTime fechamov;
	private String operacion;
	
	
	public CuentaBancaria getCorigen() {
		return corigen;
	}
	public void setCorigen(CuentaBancaria corigen) {
		this.corigen = corigen;
	}
	public CuentaBancaria getCdestino() {
		return cdestino;
	}
	public void setCdestino(CuentaBancaria cdestino) {
		this.cdestino = cdestino;
	}
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	public LocalDateTime getFechamov() {
		return fechamov;
	}
	public void setFechamov(LocalDateTime fechamov) {
		this.fechamov = fechamov;
	}
	public String getOperacion() {
		return operacion;
	}
	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}
	public Movimiento(CuentaBancaria corigen, CuentaBancaria cdestino, double importe, LocalDateTime fechamov,
			String operacion) {
		super();
		this.corigen = corigen;
		this.cdestino = cdestino;
		this.importe = importe;
		this.fechamov = fechamov;
		this.operacion = operacion;
	}
	
public String toString() {
	
	String result = "";
	  
	result = result + this.fechamov + "  ";
	// TODO que la longitud de la descripción de la operación
	// sea siempre igual
	result = result + this.operacion + "  "; 
	result = result + this.corigen.getCCC() + "  ";
	if (this.cdestino == null) {
		// TODO rellenar con espacios (longitud igual 
		// a lo que ocupa la cuenta bancaria
		result = result + "   ";
	}
	else {
			result = result + this.cdestino.getCCC() + "  "; 
		}
	
	if (importe >0) {
		result = result + this.importe;
	}
	else {
		
		
	}
	return result;
}

}
