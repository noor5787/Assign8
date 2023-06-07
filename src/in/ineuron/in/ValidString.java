package in.ineuron.in;
import java.util.Stack;

public class ValidString {

	    public static boolean isValid(String s) {
	        Stack<Integer> leftParenthesis = new Stack<>();
	        Stack<Integer> asterisks = new Stack<>();

	        for (int i = 0; i < s.length(); i++) {
	            char c = s.charAt(i);

	            if (c == '(') {
	                leftParenthesis.push(i);
	            } else if (c == '*') {
	                asterisks.push(i);
	            } else {
	                if (!leftParenthesis.isEmpty()) {
	                    leftParenthesis.pop();
	                } else if (!asterisks.isEmpty()) {
	                    asterisks.pop();
	                } else {
	                    return false;
	                }
	            }
	        }

	        while (!leftParenthesis.isEmpty() && !asterisks.isEmpty()) {
	            if (leftParenthesis.pop() > asterisks.pop()) {
	                return false;
	            }
	        }

	        return leftParenthesis.isEmpty();
	    }

	    public static void main(String[] args) {
	        String s = "()";
	        boolean isValid = isValid(s);
	        System.out.println(isValid);
	    }
	}


