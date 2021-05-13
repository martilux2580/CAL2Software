import org.junit.jupiter.api.Test;


public class FunctionTester {
    Function f = new Function();

    //Test Negative number Sqrt
    @Test
    void testSqrtRoot()
    {
        try
        {
            System.out.println("SquareRoot of 80 is " + f.squareRoot(80));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    //Test Negative number Sqrt
    @Test
    void testSqrtRootValue()
    {
        try
        {
            System.out.println("SquareRoot of 4 is " + f.squareRoot(4));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

}
