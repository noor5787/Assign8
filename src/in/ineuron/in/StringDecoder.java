package in.ineuron.in;
import java.util.Stack;
public class StringDecoder {


	    public static String decodeString(String s) {
	        Stack<Integer> countStack = new Stack<>();
	        Stack<String> stringStack = new Stack<>();
	        String currentString = "";
	        int count = 0;

	        for (char ch : s.toCharArray()) {
	            if (Character.isDigit(ch)) {
	                count = count * 10 + (ch - '0');
	            } else if (ch == '[') {
	                countStack.push(count);
	                stringStack.push(currentString);
	                count = 0;
	                currentString = "";
	            } else if (ch == ']') {
	                StringBuilder decodedString = new StringBuilder(stringStack.pop());
	                int repeatCount = countStack.pop();
	                for (int i = 0; i < repeatCount; i++) {
	                    decodedString.append(currentString);
	                }
	                currentString = decodedString.toString();
	            } else {
	                currentString += ch;
	            }
	        }

	        return currentString;
	    }

	    public static void main(String[] args) {
	        String s = "3[a]2[bc]";
	        String decodedString = decodeString(s);
	        System.out.println(decodedString);
	    }
	}

