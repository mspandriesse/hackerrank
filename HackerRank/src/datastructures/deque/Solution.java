/**
 * 
 */
package datastructures.deque;

import java.util.*;

/**
 * @author Mischa Andriesse
 * @version 1.0 (24 aug. 2020)
 *
 */
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			Deque<Integer> deque = new ArrayDeque<>();
			int n = in.nextInt();
			int m = in.nextInt();
			int max = Integer.MIN_VALUE;
			Set<Integer> set = new HashSet<>();
			for (int i = 0; i < n; i++) {
				int input = in.nextInt();
				deque.add(input);
				set.add(input);

				if (deque.size() == m) {
					if (set.size() > max) max = set.size();
					int first = deque.remove();
					if (!deque.contains(first)) set.remove(first);
				}
			}
			System.out.println(max);
		}
	}

}
