package dos.poisson.i;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) {
    	Solution solution = new Solution();
    	try (Scanner scan = new Scanner(System.in)) {
    		final double l = scan.nextDouble();
    		final int k = scan.nextInt();
    		final double p = solution.poisson(k, l);
    		System.out.printf("%.3f\n", p);
    	}
    }
    
    double poisson(final int k, final double l) {
    	return Math.pow(l,  k) * Math.exp(-l) / factorial(k);
    }
    
    long factorial(int n) {
    	if (n <= 1) {
    		return 1;
    	}
    	return IntStream.rangeClosed(1, n)
    				.reduce(1, (x, y) -> x*y);
    }
}