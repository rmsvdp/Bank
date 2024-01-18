

import java.util.Date;

public class CuentaBancaria {

	/**
	 * Código IBAN de la cuenta 
	 */
	private String CCC;
	/**
	 * Saldo
	 */
	private float Saldo;
	
	/**
	 * Constructor cuenta bancaria con parámetros
	 * Si se ingresa un saldo negativo, se instnaciará
	 * el objeto con saldo = 0
	 * @param cCC	Código de la cuenta corriente
	 * @param saldo Saldo de la cuenta
	 */
	
	public CuentaBancaria(String cCC, float saldo) {
		super();
		this.CCC = cCC;
		if (saldo<0) saldo = 0;
		this.Saldo = saldo;
	}
	
	public CuentaBancaria() {
		this.CCC="ES98bbbbssssdd0000000000";
		this.Saldo = (float) 0.0;
		// TODO Auto-generated constructor stub
	}
	/**
	 * Devuelve el número de cuenta del objeto
	 * @return valor de CCC
	 */	public String getCCC() {
		return CCC;
	}
	/**
	 * Establece el número de cuenta del objeto
	 * @return valor de CCC
	 */
	public void setCCC(String cCC) {
		CCC = cCC;
	}
	public float getSaldo() {
		return Saldo;
	}
	public void setSaldo(float saldo) {
		Saldo = saldo;
	}
/**
 * Efectua un ingreso en cuenta
 * @param cantidad Importe a ingresar ( no puede ser negativo)
 * @return True operación completada
 *         False error en la operación
 */
	public boolean ingresaEnCuenta(float cantidad) {
		boolean result;
		if (cantidad<0) {result = false;}
		else {
			Saldo += cantidad;
			result = true;
		}
		return result;
	}

	/**
	 * Efectua una retirada en cuenta
	 * @param cantidad Importe a ingresar ( no puede ser negativo)
	 * @return True operación completada
	 *         False error en la operación
	 */
		public boolean retiraDeCuenta(float cantidad) {
			boolean result;
			if (cantidad<0) {result = false;}
			else {
				if (this.Saldo >= cantidad) {
					this.Saldo -= cantidad;
					result = true;
				}
				else {
					result = false;
					}
			}
			return result;
		}
/**
 * Efectúa una transferencia de dinero		
 * @param _ccc cuenta de destino
 * @param cantidad importe a retirar de cuenta
 * @return resultado de la operación
 */
		public boolean enviaTransferencia(CuentaBancaria _cccDest,float cantidad) {
			boolean result;
			if ((this.Saldo >= cantidad) && (cantidad >0)) {
			this.retiraDeCuenta(cantidad);
			_cccDest.ingresaEnCuenta(cantidad);
			result = true;
			} else
			{
				result = false;
			}
			return result;	
		}	
	 
} // Class	

