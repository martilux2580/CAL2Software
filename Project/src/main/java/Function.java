/*
P1: f(x) = sqrt((x^2)/(x+4)) + ln(1/x^2) * (-cos(x))

 */

public class Function
{
    public double SquareRoot(double num) throws NegativeNumberException
    {
        double t;
        double squareRoot = num / 2;

        if (num < 0)
            throw new NegativeNumberException("The Square Root of a negative number is not defined.");

        else if (num == 0)
            return 0;


        else if (num == 1)
            return 1;

        else {
            do {
                t = squareRoot;
                squareRoot = (t + (num / t)) / 2;
            } while ((t - squareRoot) != 0);
        }
        return squareRoot;
    }

    public double Cosine(double degrees)
    {
        double y = degrees * Math.PI / 180;
        int n = 10;
        double cosine = 0;

        for(int i = 0; i <= n; i++)
        {
            int fac = 1;

            for(int j = 2; j <= 2 * i; j++)
                fac *= j;

            cosine += Math.pow(-1.0, i ) * Math.pow(y, 2 * i) / fac;
        }

        return cosine;
    }

    public double NaturalLog(double x) throws InvalidLogInputException
    {
        double old_sum = 0.0;
        double xmlxpl = (x - 1) / (x + 1);
        double xmlxpl_2 = xmlxpl * xmlxpl;
        double denom = 1.0;
        double frac = xmlxpl;
        double term = frac;
        double sum = term;

        if (x <= 0.0)
            throw new InvalidLogInputException("The Natural Log of 0 is not defined.");

        else {
            while (sum != old_sum) {
                old_sum = sum;
                denom += 2.0;
                frac *= xmlxpl_2;
                sum += frac / denom;
            }
        }
        return 2.0 * sum;
    }

    public double CalculateFunction (double x) throws NegativeNumberException, InvalidLogInputException, ArithmeticException
    {
        double function;
        double sqrt;
        double ln;
        double cos;
        if (x == 0 || x == -4)
            throw new ArithmeticException("Division by zero is not defined.");
        else
        {
            sqrt = SquareRoot(((Math.pow(x,2))/(x+4)));
            ln = NaturalLog((1/Math.pow(x,2)));
            cos = -Cosine(x);

            function = sqrt + (ln * cos);
        }
        return function;
    }
}

