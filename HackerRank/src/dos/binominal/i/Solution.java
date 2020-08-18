package dos.binominal.i;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * The ratio of boys to girls is 1.09 : 1. If there is 1 child born per birth, 
 * what proportion of families with exactly 6 children will have at least 3 boys?
 * (Note: if input '1.09 1' does not work, try '1,09 1') 
 * @author Mischa Andriesse
 *
 */
public class Solution {

	public static final int TOTAL_CHILDREN = 6;
	public static final int AT_LEAST_BOYS =3;

	public static void main(String[] args) {
		Solution solution = new Solution();
		try (final Scanner scan = new Scanner(System.in)) {
			final double boys = scan.nextDouble();
			final double girls = scan.nextDouble();
			solution.solve(boys, girls);
		}
	}

	void solve(double boys, double girls) {
		final double p = boys / (boys + girls);
		final int x = AT_LEAST_BOYS;
		final int n = TOTAL_CHILDREN;
		final double bd = IntStream.rangeClosed(x, n)
				.mapToDouble(r -> b(r, n, p))
				.sum();
		System.out.printf("%.3f\n", bd);
	}

	double b(int x, int n, double p) {
		return choose(n, x) * Math.pow(p, x) * Math.pow(1 - p, n - x);
	}

	/**
	 * Returns the binomial for the two values <code>n</code> and <code>k</code>: \binom{n}{k}
	 * @param n
	 * @param k
	 * @return \binom{n}{k}
	 */
	int choose(int n, int k) {
		if (n < k) {
			return 0;
		}
		if (k == 0 || k == n) {
			return 1;
		}
		return choose(n - 1, k - 1) + choose(n - 1, k);
	}

	int binomial(final int n, final int k) {
		if (n < k) {
			return 0;
		}
		if (n == k) {
			return 1;
		}
		return (int) (limitedFactorial(n, k) / factorial(n - k));
	}

	/**
	 * Calculates <code>n</code>!.
	 * @param n
	 * @return n!
	 */
	long factorial(int n) {
		long result = 1;
		if (n > 0) {
			for (int i = 1; i <= n; i++) {
				result *= i;
			}
		}
		return result;
	}

	/**
	 * Calculates n!/k!
	 * @param n
	 * @param k
	 * @return
	 */
	long limitedFactorial(final int n, final int k) {
		long result = 1;
		for (int i = n; i > k; i--) {
			result *= i;
		}
		return result;
	}
}
