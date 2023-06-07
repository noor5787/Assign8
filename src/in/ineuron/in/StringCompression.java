package in.ineuron.in;

public class StringCompression {

	    public static int compress(char[] chars) {
	        int index = 0; // index to track the current position in the modified array
	        
	        // Iterate through the array
	        int i = 0;
	        while (i < chars.length) {
	            char currentChar = chars[i];
	            int count = 0; // count of consecutive repeating characters
	            
	            // Count the number of consecutive repeating characters
	            while (i < chars.length && chars[i] == currentChar) {
	                count++;
	                i++;
	            }
	            
	            // Update the modified array with the compressed characters
	            chars[index++] = currentChar;
	            
	            if (count > 1) {
	                // Convert the count into characters and add them to the modified array
	                String countStr = String.valueOf(count);
	                for (char c : countStr.toCharArray()) {
	                    chars[index++] = c;
	                }
	            }
	        }
	        
	        return index; // Return the new length of the array
	    }
	    
	    public static void main(String[] args) {
	        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
	        int newLength = compress(chars);
	        
	        System.out.println("New length: " + newLength);
	        System.out.print("Modified array: [");
	        for (int i = 0; i < newLength; i++) {
	            if (i != 0) {
	                System.out.print(", ");
	            }
	            System.out.print("'" + chars[i] + "'");
	        }
	        System.out.println("]");
	    }
	}


