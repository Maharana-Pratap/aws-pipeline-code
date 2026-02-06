package com.example.demo.emp;

import java.util.Stack;

public class JsonTest {
	
	public static boolean isValid(String value) {
		Stack<Character> stack = new Stack<Character>(); //(LIFO)

		for (char c : value.toCharArray()) {
			// Push opening brackets
			if (c == '{' || c == '(' || c == '[') {
				stack.push(c);
			}
			// Check closing brackets
			else if (c == '}' || c == ')' || c == ']') {
				if (stack.isEmpty())
					return false;
				char top = stack.pop();

				if ((c == '}' && top != '{') || (c == ')' && top != '(') || (c == ']' && top != '[')) {
					return false;
				}
			}
		}
		// Valid if no unmatched brackets remain
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		String jsonStr = "{(])}";
		String jsonStr2 = "[{}]";
        System.out.println(isValid(jsonStr));
        //isValidJson(jsonStr);
	}

}
