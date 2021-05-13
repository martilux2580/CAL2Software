import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTester {

	@Test
	void TestSquareRootResult() {
		try {
			assertEquals(2, Calculator.SquareRoot(4));
			assertEquals(1, Calculator.SquareRoot(1));
			assertEquals(10, Calculator.SquareRoot(100));
		} catch (NegativeNumberException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void TestSquareRootException() {
		assertThrows(NegativeNumberException.class, () -> { Calculator.SquareRoot(-1); } );
	}

	@Test
	void TestLogException() {
		assertThrows(InvalidLogInputException.class, () -> { Calculator.NaturalLog(-1); } );
		assertThrows(InvalidLogInputException.class, () -> { Calculator.NaturalLog(0); } );
	}
	
	@Test
	void TestLog() {
		try {
			assertEquals(1.0, Calculator.NaturalLog(Math.E), 0.00001);
		} catch (InvalidLogInputException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void TestCosine() {
		assertEquals(1.0, Calculator.Cosine(0));
		assertEquals(0.5, Calculator.Cosine(60), 0.0001);
	}

}
