import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestBank {
/*
	@Test
	void test() {
		fail("Not yet implemented");
	}
*/
	@Test
	
	void test_Retirada() {
		
		CuentaBancaria c = new CuentaBancaria();
		c.setSaldo(100);
		assertFalse(c.retiraDeCuenta(150));
	}
}
