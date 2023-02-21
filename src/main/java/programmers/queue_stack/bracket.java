package programmers.queue_stack;

import java.util.Stack;

public class bracket {
	public static void main(String[] args) {
//		String str = ")()(";
		String str = "(())()";
//		String str = "())(()";
//		String str = "(()(";

		System.out.println(solution(str));
	}

	/*
	")()(" > false
	"(())()" > true
	"(()(" > false
	 */
	private static boolean solution(String str) {
		if (str.length() % 2 == 1 || str.charAt(0) == ')') {
			return false;
		}

		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			char val = str.charAt(i);	// split :효율성 저하
			if (val == '(') {
				stack.push(val);
			} else {
				if (stack.empty()) {
					return false;
				}
				stack.pop();
			}
		}

		return stack.empty();
	}
}