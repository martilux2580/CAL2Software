import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class FunctionTester {

    @Test
    void TestSquareRootResult() {
        try {
            assertEquals(2, Function.SquareRoot(4));
            assertEquals(1, Function.SquareRoot(1));
            assertEquals(10, Function.SquareRoot(100));
        } catch (NegativeNumberException e) {
            e.printStackTrace();
        }
    }

    @Test
    void TestSquareRootException() {
        assertThrows(NegativeNumberException.class, () -> { Function.SquareRoot(-1); } );
    }

    @Test
    void TestLogException() {
        assertThrows(InvalidLogInputException.class, () -> { Function.NaturalLog(-1); } );
        assertThrows(InvalidLogInputException.class, () -> { Function.NaturalLog(0); } );
    }

    @Test
    void TestLog() {
        try {
            assertEquals(1.0, Function.NaturalLog(Math.E), 0.00001);
        } catch (InvalidLogInputException e) {
            e.printStackTrace();
        }
    }

    @Test
    void TestCosine() {
        assertEquals(1.0, Function.Cosine(0));
        assertEquals(0.5, Function.Cosine(60), 0.0001);
    }

}
