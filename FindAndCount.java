public class FindAndCount {

	private static String vectorToString(String name, int[] vector) {
	    String s = name + " {";

	    for (int i=0; i<vector.length; i++)
	        s = s + vector[i] + ((i < vector.length - 1) ? ", " : "");

	    s = s + "}";

	    return s;
	}

	// countZeros(int[] vector) returns the number of 0's in a sorted binary vector

    private static int countZeros(int[] vector) {
    	return countZeros(vector, 0, vector.length-1);
    }
    
	private static int countZeros(int[] vector, int low, int high) {
	   	if (vector[low] == 1)
	   		return 0;
	   	else {
	   		if (vector[high] == 0)
	   			return (high - low + 1);
	   		else {
      			int mid = (low + high) / 2;
      			
	       		return countZeros(vector, low, mid) + countZeros(vector, mid + 1, high);        			
        	}
       	}
    }
		
	// countOnes(int[] vector) returns the number of 1's in a sorted binary vector

    private static int countOnes(int[] vector) {
    	return countOnes(vector, 0, vector.length-1);
    }

    private static int countOnes(int[] vector, int low, int high) {
      	if (vector[high] == 0)
    		return 0;
       	else {
    		if (vector[low] == 1)
    			return (high - low + 1);
    		else {
       			int mid = (low + high) / 2;

       			return countOnes(vector, low, mid) + countOnes(vector, mid + 1, high);        			
        	}
       	}
    }
	    
    // count(int[] vector, int value) returns the number of items having a given value in a sorted vector

    private static int count(int[] vector, int value) {
        return count(vector, value, 0, vector.length - 1);
    }

    private static int count(int [] vector, int value, int low, int high) {
       	if (vector[low] > value || vector[high] < value)
       		return 0;
       	else {
   			if (vector[low] == value && vector[high] == value)
   				return (high - low + 1);
   			else {
       			int mid = (low + high) / 2;

       			return count(vector, value, low, mid) + count(vector, value, mid + 1, high);        			
       		}  
       	}
    }

    // findFirst(int[] vector, int value) returns the first position of a value in a sorted vector or -1 when not found

    private static int findFirst(int [] vector, int value) {
        return findFirst(vector, value, 0, vector.length - 1);
    }

    public static int findFirst(int[] vector, int value, int low, int high) {
    	if (vector[low] > value || vector[high] < value)
			return -1;
		else {
			if (vector[low] == value)
				return low;
    		else {
    			int mid = (low + high) / 2;

    			int p = findFirst(vector, value, low, mid);

    			return (p > 0) ? p : findFirst(vector, value, mid+1, high);
    		}
		}
    }	

    // findLast(int[] vector, int value) returns the last position of a value in a sorted vector or -1 when not found

    private static int findLast(int[] vector, int value) {
		return findLast(vector, value, 0, vector.length - 1);
	}

    private static int findLast(int[] vector, int value, int low, int high) {  
		if (vector[low] > value || vector[high] < value) {
			return -1;
		} 
		else {
			if (vector[high] == value) {
				return high;
			} else {
				int mid = (low + high) / 2;
	
				int p = findLast(vector, value, mid + 1, high);
	
				return (p > 0) ? p : findLast(vector, value, low, mid - 1);
			}
		}
    }
  
  
	public static void main(String[] args) {
		    int [] vector = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6, 6, 6 };

        int n;
                
        System.out.println(vectorToString("Data ", vector) + "\n");
        
        for (int i=0; i<7; i++) {
        	System.out.println("The first position of " + i + " is " + findFirst(vector, i) + ", the last position is " + findLast(vector, i));
        }
        
        n = 10;
        
        System.out.println("The first position of " + n + " is " + findFirst(vector, n) + ", the last position is " + findLast(vector, n));
        
        System.out.println("");

        for (int i=0; i<7; i++) {
            System.out.println("Total items with value " + i + " is " + count(vector, i));                	
        }

        n = 10;

        System.out.println("Total items with value " + n + " is " + count(vector, n));   
        
        System.out.println("");

        int [] bin = { 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
        
        System.out.println(vectorToString("Bin  ", bin) + "\n");
        
        for (int i=0; i<2; i++) {
        	System.out.println("Total items with value " + i + " is " + count(bin, i));        
        }
        
        System.out.println("");
        System.out.println("Number of 0s in Bin is " + countZeros(bin));
        System.out.println("Number of 1s in Bin is " + countOnes(bin));
        
        int [] dec = { 0, 1, 1, 1, 2, 2, 3, 3, 4, 5, 5, 5, 5, 6, 6 };

        System.out.println("");
        
        for (int i=0; i<7; i++) {
        	System.out.println("Number of " + i + "s in Dec is " + count(dec, i));
        }
        
        n = 7;
        
        System.out.println("Number of " + n + "s in Dec is " + count(dec, n)); 
	}
}
