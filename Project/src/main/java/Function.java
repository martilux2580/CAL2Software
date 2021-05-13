/*
FP1: f(x) = sqrt((x^2)/(x+4)) + ln(1/x^2) * (-cos(x))

 */

public class Function {
    public static void main(String[] args) {


        //System.out.println("SquareRoot of 80 is " + squareRoot(-1));
        System.out.format("The cosine of " + 45 + " is %f \n",cosine(45));
        System.out.println("Natural Log of 2.718281828 is " + NaturalLog(2.718281828));
    }

    public static double squareRoot(int num) throws Exception
    {
        //temporary variable
        if(num<0)
        {
            throw new Exception("Square Root of negative number does not exist.");
        }
        double t;
        double sqrtroot=num/2;
        do
        {
            t=sqrtroot;
            sqrtroot=(t+(num/t))/2;
        }
        while((t-sqrtroot)!= 0);
        return sqrtroot;
    }

    public static double cosine(int degrees)
    {
        double y;
        y = degrees*Math.PI/180;
        int n = 10;
        int i,j,fac;
        double cosine = 0;
        for(i=0; i<=n; i++){
            fac = 1;
            for(j=2; j<=2*i; j++){
                fac*=j;
            }
            cosine+=Math.pow(-1.0,i)*Math.pow(y,2*i)/fac;
        }
        return cosine;
    }

    public static double NaturalLog(double x)
    {
        double old_sum = 0.0;
        double xmlxpl = (x - 1) / (x + 1);
        double xmlxpl_2 = xmlxpl * xmlxpl;
        double denom = 1.0;
        double frac = xmlxpl;
        double term = frac;// denom start from 1.0
        double sum = term;

        while ( sum != old_sum )
        {
            old_sum = sum;
            denom += 2.0;
            frac *= xmlxpl_2;
            sum += frac / denom;
        }
        return 2.0 * sum;
    }

}
