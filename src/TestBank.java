import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestBank {

	@Test
	void test_Retirada() {
		
		CuentaBancaria c = new CuentaBancaria();
		c.setSaldo(100);
		assertFalse(c.retiraDeCuenta(150));
	}
	
	@Test
	void test_Ingreso() {
		
		CuentaBancaria c = new CuentaBancaria();
		c.setSaldo(100);
		assertTrue(c.ingresaEnCuenta(50));
		assertTrue(c.getSaldo() == 150);
		assertFalse(c.ingresaEnCuenta(-1));
	}
	@Test
	void test_transferencia() {
		
		CuentaBancaria corigen = new CuentaBancaria();
		CuentaBancaria cdest = new CuentaBancaria();
		corigen.setSaldo(100);
		cdest.setSaldo(100);
		assertTrue(corigen.enviaTransferencia(cdest, 50));
		assertTrue(corigen.getSaldo()== 50 &&
				   cdest.getSaldo()== 150);
	}
	
	
}
