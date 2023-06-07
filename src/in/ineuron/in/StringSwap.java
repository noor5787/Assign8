package in.ineuron.in;

public class StringSwap {

	    public static boolean canSwapStrings(String s, String goal) {
	        if (s.length() != goal.length()) {
	            return false;
	        }

	        int diffCount = 0;
	        int[] diffIndexes = new int[2];
	        for (int i = 0; i < s.length(); i++) {
	            if (s.charAt(i) != goal.charAt(i)) {
	                diffCount++;
	                if (diffCount > 2) {
	                    return false; // More than two differences, can't be swapped
	                }
	                diffIndexes[diffCount - 1] = i;
	            }
	        }

	        if (diffCount != 2) {
	            return false; // There must be exactly two differences to be able to swap
	        }

	        char[] sArray = s.toCharArray();
	        // Swap the characters
	        char temp = sArray[diffIndexes[0]];
	        sArray[diffIndexes[0]] = sArray[diffIndexes[1]];
	        sArray[diffIndexes[1]] = temp;

	        String swappedString = new String(sArray);
	        return swappedString.equals(goal);
	    }

	    public static void main(String[] args) {
	        String s = "ab";
	        String goal = "ba";

	        boolean canSwap = canSwapStrings(s, goal);
	        System.out.println(canSwap);
	    }
	}


