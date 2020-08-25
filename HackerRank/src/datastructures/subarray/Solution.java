/**
 * 
 */
package datastructures.subarray;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * @author Mischa Andriesse
 * @version 1.0 (23 aug. 2020)
 *
 */
public class Solution {
	private int[] array;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			int size = scan.nextInt();
			int[] array = new int[size];
			for (int i = 0; i < size; i++) {
				array[i] = scan.nextInt();
			}
			Solution solution = new Solution(array);
			int result = solution.solve();
			System.out.println(result);
		}
	}

	public Solution(int[] array) {
		this.array = array;
	}

	public int solve() {
		int result = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = i; j < array.length; j++) {
				int sum = IntStream.rangeClosed(i, j)
						.map(k -> array[k])
						.sum();
				if (sum < 0) {
					result++;
				}
			}
		}
		return result;
	}

}
