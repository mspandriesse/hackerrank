/**
 * 
 */
package datastructures.stack;

import java.util.Scanner;
import java.util.Stack;

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
		Solution solution = new Solution();
		solution.solve();
	}

	void solve() {
		try (Scanner scan = new Scanner(System.in)) {
			while (scan.hasNext()) {
				String next = scan.next();
				Stack<Character> stack = new Stack<>();
				for (int i = 0; i < next.length(); i++) {
					char n = next.charAt(i);
					if (!stack.isEmpty()) {
						switch (n) {
						case '}': if (stack.peek() == '{') stack.pop(); break;
						case ']': if (stack.peek() == '[') stack.pop(); break;
						case ')': if (stack.peek() == '(') stack.pop(); break;
						default: stack.push(n);
						}
					} else {
						stack.push(n);
					}
				}
				System.out.println(stack.isEmpty());
			}
		}
	}
}
