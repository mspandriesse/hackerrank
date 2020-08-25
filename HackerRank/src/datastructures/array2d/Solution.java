/**
 * 
 */
package datastructures.array2d;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author Mischa Andriesse
 * @version 1.0 (23 aug. 2020)
 *
 */
public class Solution {
	private static final Scanner scanner = new Scanner(System.in);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int [][] array = new int[6][6];
		int max = -9 * 7;
		try {
			for (int i = 0; i < 6; i++) {
				String[] row = scanner.nextLine().split(" ");
				scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
				for (int j = 0; j < 6; j++) {
					array[i][j] = Integer.parseInt(row[j]);
					if (i > 1 && j > 1) {
						int sum = array[i-2][j-2] + array[i-2][j-1] + array[i-2][j];
						sum += array[i-1][j-1];
						sum += array[i][j-2] + array[i][j-1] + array[i][j];
						max = Math.max(max, sum);
					}
				}
				List<Integer> list = new ArrayList<>();
				list.stream().map(Objects::toString).collect(Collectors.joining(" "));
			}
			System.out.println(max);
		} finally {
			scanner.close();
		}
	}
}
