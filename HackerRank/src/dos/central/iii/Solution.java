package dos.central.iii;

import java.util.Locale;
import java.util.Scanner;

public class Solution {
	private Scanner scan;
	
	public Solution(Scanner scan) {
		this.scan = scan;
	}
	
	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			scan.useLocale(Locale.US);
			Solution solution = new Solution(scan);
			solution.solve();
		}
	}
	
	public void solve() {
		double samples = scan.nextDouble();
		double mean = scan.nextDouble();
		double sd = scan.nextDouble();
		scan.nextDouble();
		double z = scan.nextDouble();
		double sd_sample = sd / Math.sqrt(samples);
		System.out.printf("%.2f\n", mean - sd_sample * z);
		System.out.printf("%.2f\n", mean + sd_sample * z);
	}

}