package in.ineuron.in;
import java.util.ArrayList;
import java.util.List;

public class AnagramIndices {
		    public static List<Integer> findAnagramIndices(String s, String p) {
	        List<Integer> result = new ArrayList<>();

	        if (s == null || s.length() == 0 || p == null || p.length() == 0 || p.length() > s.length())
	            return result;

	        int[] pCount = new int[26];
	        int[] sCount = new int[26];
	        int windowSize = p.length();

	        // Count characters in p
	        for (char c : p.toCharArray()) {
	            pCount[c - 'a']++;
	        }

	        // Count characters in the initial window of s
	        for (int i = 0; i < windowSize; i++) {
	            sCount[s.charAt(i) - 'a']++;
	        }

	        // Check if the initial window is an anagram of p
	        if (matches(pCount, sCount))
	            result.add(0);

	        // Slide the window through s
	        for (int i = windowSize; i < s.length(); i++) {
	            // Add the new character to the window
	            sCount[s.charAt(i) - 'a']++;

	            // Remove the first character from the window
	            sCount[s.charAt(i - windowSize) - 'a']--;

	            // Check if the current window is an anagram of p
	            if (matches(pCount, sCount))
	                result.add(i - windowSize + 1);
	        }

	        return result;
	    }

	    private static boolean matches(int[] pCount, int[] sCount) {
	        for (int i = 0; i < 26; i++) {
	            if (pCount[i] != sCount[i])
	                return false;
	        }
	        return true;
	    }

	    public static void main(String[] args) {
	        String s = "cbaebabacd";
	        String p = "abc";
	        List<Integer> indices = findAnagramIndices(s, p);
	        System.out.println("Anagram indices: " + indices);
	    }
	}


