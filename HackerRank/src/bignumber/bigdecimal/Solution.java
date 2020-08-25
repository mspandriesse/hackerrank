/**
 * 
 */
package bignumber.bigdecimal;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.function.Consumer;

import org.apache.commons.math3.stat.descriptive.SummaryStatistics;

import static java.util.Comparator.nullsLast;
import static java.util.Comparator.comparing;

/**
 * @author Mischa Andriesse
 * @version 1.0 (18 aug. 2020)
 *
 */
public class Solution<T> {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution<String> solution = new Solution<>();
		try (Scanner scan = new Scanner(System.in)) {
			int n = scan.nextInt();
			String []s = new String[n+2];
			for(int i = 0; i < n; i++) {
				s[i]=scan.next();
			}
			Comparator<String> comparator = nullsLast(
					comparing((String m) -> new BigDecimal(m))
					.reversed()
			); 
			solution.time(s, 100, t -> Arrays.sort(t, comparator));
		}
	}

	public void time(final String[] s, final int N, Consumer<String[]> runnable) {
		final SummaryStatistics stats = new SummaryStatistics();
		for (int i = 0; i < N; i++) {
			final String[] t = new String[s.length];
			for (int j = 0; j < s.length; j++) {
				t[j] = s[j];
			}
			final long start = System.nanoTime();
			runnable.accept(t);
			final double time = (System.nanoTime() - start) / 1000.0; // µs
			for (int j = 0; j < t.length; j++) {
				System.out.println(t[j]);
			}
			if (i > 0) {
				stats.addValue(time);
				System.out.printf("Time: %.2f µs\n", time);
				System.out.println();
			}
		}
		System.out.printf("Mean time %.2f µs, variance: %.2f µs\n", stats.getMean(), stats.getStandardDeviation());
	}	
}
