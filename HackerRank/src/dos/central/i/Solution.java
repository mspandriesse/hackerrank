package dos.central.i;

import java.util.Locale;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		try (Scanner scan = new Scanner(System.in)) {
			scan.useLocale(Locale.US);
			double max = scan.nextDouble();
			double n = scan.nextDouble();
			double mean = scan.nextDouble();
			double dev = scan.nextDouble();
			System.out.printf("%.4f\n", solution.phi(max, n*mean, (dev*Math.sqrt(n))));
			
		}
	}

	double phi(double x, double u, double s) {
		return 0.5 * (1 + erf((x - u)/(s * Math.sqrt(2))));
	}
	
	double erf(double z) {
		double t = 1.0 / (1.0 + 0.5 * Math.abs(z));

		// use Horner's method
		double ans = 1 - t * Math.exp(-z*z - 1.26551223 +
				t * ( 1.00002368 +
				t * ( 0.37409196 + 
				t * ( 0.09678418 + 
				t * (-0.18628806 + 
				t * ( 0.27886807 + 
				t * (-1.13520398 + 
				t * ( 1.48851587 + 
				t * (-0.82215223 + 
				t * ( 0.17087277))))))))));
		if (z >= 0) {
			return ans;
		}
		return -ans;
	}
}
