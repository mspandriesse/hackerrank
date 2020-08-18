/**
 * 
 */
package bignumber.bigdecimal;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Mischa Andriesse
 * @version 1.0 (18 aug. 2020)
 *
 */
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			int n = scan.nextInt();
	        String []s = new String[n+2];
	        for(int i = 0; i < n; i++) {
	            s[i]=scan.next();
	        }
	        
	        Arrays.sort(s, 0, n, (s1, s2) -> new BigDecimal(s2).compareTo(new BigDecimal(s1)));
	        
	        for (int i = 0; i < n; i++) {
	        	System.out.println(s[i]);
	        }
		}
	}
}
