import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class FunctionTester {

    /* Testing SquareRoot() function with positive values. */
    @Test
    void TestSquareRootPositiveValues() throws NegativeNumberException
    {
        Function function = new Function();

        assertEquals(2, function.SquareRoot(4));
        assertEquals(1, function.SquareRoot(1));
        assertEquals(10, function.SquareRoot(100));
    }

    /* Testing SquareRoot() function with zero value. */
    @Test
    void TestSquareRootZeroValue() throws NegativeNumberException
    {
        Function function = new Function();

        assertEquals(0, function.SquareRoot(0));
    }

    /* Testing SquareRoot() function with negative numbers.
     * SquareRoot() of negative number is not defined, must throw Exception.*/
    @Test
    void TestSquareRootException() throws NegativeNumberException
    {
        Function function = new Function();

        NegativeNumberException ne = assertThrows(NegativeNumberException.class, () -> { function.SquareRoot(-1); } );
        assertTrue(ne.getMessage().contains("The Square Root of a negative number is not defined."));
    }

    /* Testing NaturalLog() function with negative number and with number zero.
       NaturalLog() of negative number or number zero is not defined, must throw Exception.*/
    @Test
    void TestLogException() throws InvalidLogInputException
    {
        Function function = new Function();

        assertThrows(InvalidLogInputException.class, () -> { function.NaturalLog(-1); } );
        assertThrows(InvalidLogInputException.class, () -> { function.NaturalLog(0); } );
    }

    /* Testing NaturalLog() function with positive numbers. */
    @Test
    void TestLog() throws InvalidLogInputException
    {
        Function function = new Function();

        assertEquals(1.0, function.NaturalLog(Math.E), 0.00001);
        assertEquals(0, function.NaturalLog(1), 0.00001);
    }

    /* Testing Cosine() function with zero value. */
    @Test
    void TestCosine()
    {
        Function function = new Function();

        assertEquals(1.0, function.Cosine(0));
        assertEquals(0.5, function.Cosine(60), 0.00001);
        assertEquals(0.258819, function.Cosine(-75), 0.00001);
    }

    /* Testing SquareRoot() function with Mockito and positive number. */
    @Test
    void TestSquareRootMockito() throws NegativeNumberException
    {
        //Mockito receives class we want to mock
        Function function = Mockito.mock(Function.class);

        //Setting up the result → sqrt(40)
        double expectedResult = 1600.0d;
        double actualResult = 0.0d;

        //Mockito in Action
        Mockito.when(function.SquareRoot(1600)).thenReturn(expectedResult);
        actualResult = function.SquareRoot(1600);

        //Checking values
        assertEquals(expectedResult, actualResult, 0.00001);
    }

    /* Testing Cosine() function with Mockito and positive number. */
    @Test
    void TestCosineMockito()
    {
        //Mockito receives class we want to mock
        Function function = Mockito.mock(Function.class);

        //Setting up the result → Cosine(60) degrees
        double expectedResult = 0.5d;
        double actualResult = 0.0d;

        //Mockito in Action
        Mockito.when(function.Cosine(60)).thenReturn(expectedResult);
        actualResult = function.Cosine(60);

        //Checking values
        assertEquals(expectedResult, actualResult, 0.00001);
    }

    /* Testing NaturalLog() function with Mockito and positive number. */
    @Test
    void TestLogMockito() throws InvalidLogInputException
    {
        //Mockito receives class we want to mock
        Function function = Mockito.mock(Function.class);

        //Setting up the result → Cosine(60) degrees
        double expectedResult = 2.71828d;
        double actualResult = 0.0d;

        //Mockito in Action
        Mockito.when(function.NaturalLog(2.71828d)).thenReturn(expectedResult);
        actualResult = function.NaturalLog(2.71828d);

        //Checking values
        assertEquals(expectedResult, actualResult, 0.00001);
    }

    /* Testing CalculateFunction() function with numbers 0 and -4.
       Dividing by zero is not defined, must throw Exception.*/
    @Test
    void TestCalculateFunctionExceptions() throws InvalidLogInputException, NegativeNumberException, ArithmeticException
    {
        Function function = new Function();

        assertThrows(ArithmeticException.class, () -> { function.CalculateFunction(-4.0); } );
        assertThrows(ArithmeticException.class, () -> { function.CalculateFunction(0.0); } );
    }

    /* Testing CalculateFunction() function with negative numbers.*/
    @Test
    void TestCalculateFunctionNegativeNumbers() throws InvalidLogInputException, NegativeNumberException, ArithmeticException
    {
        Function function = new Function();

        assertEquals(3.872078705, function.CalculateFunction((-2.5)), 0.00001);
    }

    /* Testing CalculateFunction() function with positive numbers.*/
    @Test
    void TestCalculateFunctionPositiveNumbers() throws InvalidLogInputException, NegativeNumberException, ArithmeticException
    {
        Function function = new Function();

        assertEquals(2.811417928, function.CalculateFunction((2.5)), 0.00001);
    }

    /* Testing CalculateFunction() function with Mockito and positive number. */
    @Test
    void TestCalculateFunctionPositiveNumbersMockito() throws InvalidLogInputException, NegativeNumberException, ArithmeticException
    {
        //Mockito receives class we want to mock
        Function function = Mockito.mock(Function.class);

        //Setting up the result → CalculateFunction(8.5)
        double expectedResult = 6.637281825d;
        double actualResult = 0.0d;

        //Mockito in Action
        Mockito.when(function.CalculateFunction(8.5d)).thenReturn(expectedResult);
        actualResult = function.CalculateFunction(8.5d);

        //Checking values
        assertEquals(expectedResult, actualResult, 0.00001);
    }

    /* Testing CalculateFunction() function with Mockito and negative number. */
    @Test
    void TestCalculateFunctionNegativeNumbersMockito() throws InvalidLogInputException, NegativeNumberException, ArithmeticException
    {
        //Mockito receives class we want to mock
        Function function = Mockito.mock(Function.class);

        //Setting up the result → CalculateFunction(-3.8)
        double expectedResult = 11.16119036d;
        double actualResult = 0.0d;

        //Mockito in Action
        Mockito.when(function.CalculateFunction(-3.8d)).thenReturn(expectedResult);
        actualResult = function.CalculateFunction(-3.8d);

        //Checking values
        assertEquals(expectedResult, actualResult, 0.00001);
    }
}
