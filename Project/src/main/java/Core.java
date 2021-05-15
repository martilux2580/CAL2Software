import java.util.Scanner;

public class Core {
    //Program to calculate the function
    public static void main(String[] args) {

        //Need to request a value from the user
        Scanner input = new Scanner(System.in);
        Function function = new Function();
        double value = 0.0d;

        //Requesting and storing the value provided by the user
        System.out.print("Give me a number (x,x) to calculate the function value: ");
        value = input.nextDouble();

        //Calculating the value of the function at the point given by the user.
        try
        {
            System.out.println("\nValue of function at point " + value + " is: "+ function.CalculateFunction(value));
        }
        catch (InvalidLogInputException ie)
        {
            System.err.println(ie);
        }
        catch (NegativeNumberException ne)
        {
            System.err.println(ne);
        }
        catch (ArithmeticException ae)
        {
            System.err.println(ae);
        }
    }
}
