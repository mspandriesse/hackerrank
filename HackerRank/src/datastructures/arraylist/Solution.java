/**
 * 
 */
package datastructures.arraylist;

import java.util.*;

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
		try (Scanner scan = new Scanner(System.in)) {
            int tries = scan.nextInt();
            List<List<Integer>> lists = new ArrayList<>(tries);
            while (tries-- > 0) {
            	int size = scan.nextInt();
            	List<Integer> list = new ArrayList<>(size);
            	while (size-- > 0) {
            		list.add(scan.nextInt());
            	}
            	lists.add(list);
            }
            int q = scan.nextInt();
            while (q-- > 0) {
            	int x = scan.nextInt();
            	int y = scan.nextInt();
            	List<Integer> list = lists.get(x-1);
            	String value = (y <= list.size()) ? list.get(y-1).toString() : "ERROR!";
            	System.out.println(value);
            }
        }
	}

}
