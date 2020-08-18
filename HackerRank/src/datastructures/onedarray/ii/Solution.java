/**
 * 
 */
package datastructures.onedarray.ii;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Mischa Andriesse
 * @version 1.0 (16-08-2020)
 *
 */
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		try (Scanner scan = new Scanner(System.in)) {
			final int q = scan.nextInt();
			Boolean[] result = new Boolean[q];
			for (int i = 0; i < q; i++) {
				final int n = scan.nextInt();
				final int leap = scan.nextInt();
				int[] game = new int[n];
				for (int j = 0; j < n; j++) {
					game[j] = scan.nextInt();
				}
				result[i] = solution.isSolvable(leap, game, 0);
			}
			Arrays.stream(result)
				.map(r -> r ? "YES" : "NO")
				.forEach(System.out::println);
		}
	}
	
	boolean isSolvable(final int leap, int[] game, final int index) {
		if (index >= game.length) {
			return true;
		} else if (index < 0 || game[index] != 0) {
			return false;
		}
		game[index] = 1;
		return isSolvable(leap, game, index + leap) ||
				isSolvable(leap, game, index + 1) ||
				isSolvable(leap, game, index - 1);
	}
	
}
