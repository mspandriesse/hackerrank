package dos.poisson.ii;

import java.util.Locale;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		try (Scanner scan = new Scanner(System.in)) {
			scan.useLocale(Locale.US);
			double lx = scan.nextDouble();
			double ly = scan.nextDouble();
			double x2 = solution.poissonSquare(lx); 
			double y2 = solution.poissonSquare(ly);
			System.out.printf("%.3f\n", 160 + 40 * x2);
			System.out.printf("%.3f\n", 128 + 40 * y2);
		}
	}

	double poissonSquare(double x) {
		return x + Math.pow(x, 2);
	}
}
