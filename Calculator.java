
public class Calculator {

	public static double SquareRoot(int num) throws NegativeNumberException {
		if (num < 0)
			throw new NegativeNumberException();
		
		if (num == 1)
			return 1;
		 
		double t;
		double squareRoot = num / 2;
	        
		do {
			t = squareRoot;
			squareRoot = (t + (num / t)) / 2;
		}
		while((t - squareRoot) != 0);
	     
		return squareRoot;
	}

	public static double Cosine(int degrees) {
		double y = degrees * Math.PI / 180;
		int n = 10;
		double cosine = 0;
	     
		for(int i = 0; i <= n; i++){
			int fac = 1;

			for(int j = 2; j <= 2 * i; j++)
				fac *= j;
	                
			cosine += Math.pow(-1.0, i ) * Math.pow(y, 2 * i) / fac;
		}
	        
		return cosine;
	}

	public static double NaturalLog(double x) throws InvalidLogInputException {
		if (x <= 0.0)
			throw new InvalidLogInputException();
		
		double old_sum = 0.0;
		double xmlxpl = (x - 1) / (x + 1);
		double xmlxpl_2 = xmlxpl * xmlxpl;
		double denom = 1.0;
		double frac = xmlxpl;
		double term = frac;
		double sum = term;

		while ( sum != old_sum ) {
			old_sum = sum;
	        denom += 2.0;
	        frac *= xmlxpl_2;
	        sum += frac / denom;
		}
	        
	    return 2.0 * sum;
	}

}
