package dos.normal.i;

import java.util.Locale;
import java.util.Scanner;
import java.util.function.Function;

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		try (Scanner scanner = new Scanner(System.in)) {
			scanner.useLocale(Locale.US);
			int u = scanner.nextInt();
			int s = scanner.nextInt();
			double x = scanner.nextDouble();
			double a = scanner.nextInt();
			double b = scanner.nextInt();
			Function<Double, Double> phi = solution.phi(u,s);
			solution.print(phi.apply(x));
			solution.print(phi.apply(b) - phi.apply(a));
		}

	}

	Function<Double,Double> phi(int u, int s) {
		return x -> 0.5 * (1 + erf((x - u)/(s * Math.sqrt(2))));
	}
	
	void print(double o) {
		System.out.printf("%.3f\n", o);
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

