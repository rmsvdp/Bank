import java.time.LocalDateTime;

/*
 * Formateo de cadenas y manejo de LocalDateTime
 * 
 * añade espacios a la derecha
 * cadena = String.format("%-" + Longitud_Total_Cadena_Final + "s",cadena);
 * 
 * Definir formato de fecha:
 * DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
 * -- Obtener fecha actual
 * LocalDateTime ahora = LocalDateTime.now();
 * System.out.println(ahora.format(fmt));
 * -- Especifiar una fecha hora determinada
 * String miFechaHora ="2024-01-01 00:00:00";
 * LocalDateTime fechaFija = LocalDateTime.parse(miFechaHora,fmt);
 * System.out.println(ahora.format(fechaFija));
 */

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
	String tmp ="";
	result = result + this.fechamov + "  ";
	// TODO que la longitud de la descripción de la operación
	// sea siempre igual
	tmp = String.format("%-14s", this.operacion);
	result = result + tmp+ "  "; 
	result = result + this.corigen.getCCC() + "  ";
	if (this.cdestino == null) {
		tmp = String.format("%-24s", " ");
		result = result + tmp;
	}
	else {
			result = result + this.cdestino.getCCC() + "  "; 
		}
	if (importe >0) {
		result = result + this.importe;
	}
	return result;
}

}
