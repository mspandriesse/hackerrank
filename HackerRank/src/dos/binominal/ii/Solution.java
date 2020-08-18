/**
 * 
 */
package dos.binominal.ii;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * @author Mischa Andriesse
 *
 */
public class Solution {
	static final int REJECTS = 2;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		try (Scanner scan = new Scanner(System.in)) {
			int failure = scan.nextInt();
			int batchSize = scan.nextInt();
			solution.solve(failure, batchSize);
		}
	}
	
	void solve(int failure, int n) {
		double p = failure / 100.0;
		int x = REJECTS;
		double maxRejects = IntStream.rangeClosed(0, x)
				.mapToDouble(r -> b(r, n, p))
				.sum();
		double minRejects = IntStream.rangeClosed(x, n)
				.mapToDouble(r -> b(r, n, p))
				.sum();
		System.out.printf("%.3f\n", maxRejects);
		System.out.printf("%.3f\n", minRejects);
	}
	
	double b(final int x, final int n, final double p) {
		return choose(n, x) * Math.pow(p, x) * Math.pow(1 - p, n - x);
	}

	int choose(int n, int k) {
		if (n < k) {
			return 0;
		}
		if (k == 0 || k == n) {
			return 1;
		}
		return choose(n - 1, k - 1) + choose(n - 1, k);
	}
}
