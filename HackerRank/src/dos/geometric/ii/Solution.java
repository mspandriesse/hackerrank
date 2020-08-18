/**
 * 
 */
package dos.geometric.ii;

import java.util.Scanner;

/**
 * @author Mischa Andriesse
 *
 */
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		try (Scanner scan = new Scanner(System.in)) {
			int num = scan.nextInt();
			int den = scan.nextInt();
			int ins = scan.nextInt();
			double p = num / Double.valueOf(den);
			solution.solve(ins, p);
		}
	}
	
	void solve(int insp, double p) {
		double b = 1 - Math.pow(1 - p, insp);
		System.out.printf("%.3f\n", b);
	}
}
