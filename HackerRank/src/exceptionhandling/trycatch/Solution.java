/**
 * 
 */
package exceptionhandling.trycatch;

import java.util.Locale;
import java.util.Scanner;

/**
 * @author Mischa Andriesse
 * @version 1.0 (23 aug. 2020)
 *
 */
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner s = new Scanner(System.in)) {
			s.useLocale(Locale.US);
			Integer one = s.nextInt();
			Integer two = s.nextInt();
			System.out.println(one / two);
		} catch (Exception e) {
			if (e instanceof ArithmeticException) {
				System.out.println("java.lang.ArithmeticException: / by zero");
			} else {
				System.out.println(e.getClass().getCanonicalName());
			}
		}
	}

}
