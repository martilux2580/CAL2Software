import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;


public class FunctionTester {

    @Test
    void TestSquareRootResult() {
        Function function = new Function();
        try {
            assertEquals(2, function.SquareRoot(4));
            assertEquals(1, function.SquareRoot(1));
            assertEquals(10, function.SquareRoot(100));
        } catch (NegativeNumberException e) {
            e.printStackTrace();
        }
    }

    @Test
    void TestSquareRootException() {
        Function function = new Function();
        assertThrows(NegativeNumberException.class, () -> { function.SquareRoot(-1); } );
    }

    @Test
    void TestLogException() {
        Function function = new Function();
        assertThrows(InvalidLogInputException.class, () -> { function.NaturalLog(-1); } );
        assertThrows(InvalidLogInputException.class, () -> { function.NaturalLog(0); } );
    }

    @Test
    void TestLog() {
        Function function = new Function();
        try {
            assertEquals(1.0, function.NaturalLog(Math.E), 0.00001);
        } catch (InvalidLogInputException e) {
            e.printStackTrace();
        }
    }

    @Test
    void TestCosine() {
        Function function = new Function();
        assertEquals(1.0, function.Cosine(0));
        assertEquals(0.5, function.Cosine(60), 0.00001);
    }


    @Test
    void TestSquareRootMockito(){
        //Mockito receives class we want to mock
        Function function = Mockito.mock(Function.class);

        //Setting up the result → sqrt(40)
        double expectedResult = 1600.0d;
        double actualResult = 0.0d;

        //Mockito in Action
        try{
            Mockito.when(function.SquareRoot(1600)).thenReturn(expectedResult);
            actualResult = function.SquareRoot(1600);
        }
        catch (NegativeNumberException ne)
        {
            System.err.println(ne);
        }

        //Checking values
        assertEquals(expectedResult, actualResult, 0.00001);

    }

    @Test
    void TestCosineMockito(){
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

    @Test
    void TestLogMockito(){
        //Mockito receives class we want to mock
        Function function = Mockito.mock(Function.class);

        //Setting up the result → Cosine(60) degrees
        double expectedResult = 2.71828d;
        double actualResult = 0.0d;

        //Mockito in Action
        try{
            Mockito.when(function.NaturalLog(2.71828d)).thenReturn(expectedResult);
            actualResult = function.NaturalLog(2.71828d);
        }
        catch (InvalidLogInputException ie)
        {
            System.err.println(ie);
        }

        //Checking values
        assertEquals(expectedResult, actualResult, 0.00001);

    }


}
