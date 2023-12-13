public class BinarySearchIntegers {

	private static String toString(String name, int[] vector) {
	    String s = name + " {";

	    for (int i=0; i<vector.length; i++)
	        s = s + vector[i] + ((i < vector.length - 1) ? ", " : "");

	    s = s + "}";

	    return s;
	}

	private static boolean iterativeBinarySearch(int[] vector, int value) {
        int mid, low = 0, high = vector.length - 1;

        while (low <= high) {
            mid = (low + high) / 2;

            if (vector[mid] == value) {
                return true;
            } else if (vector[mid] > value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }
    private static boolean recursiveBinarySearch(int[] vector, int value){
        return recursiveBinarySearch(vector, value, 0, vector.length - 1);
    }

    private static boolean recursiveBinarySearch(int[] vector, int value, int low, int high){
        
        if(low > high){
            return false;
        }
        else {
            int mid = (low + high) / 2;
            if (vector[mid] == value)
                return true;
            else
                if(vector[mid] > value)
                    return recursiveBinarySearch(vector, value, low, mid - 1);
                else
                    return recursiveBinarySearch(vector, value, mid + 1, high);
        }
    }

	public static void main(String[] args) {
		int value;
		
		int[] data = { 5, 7, 9, 10, 15, 19, 21, 23, 31, 45, 56, 67, 70 };
		
		System.out.println(toString("Data", data));
		
		System.out.println("\nIterativeBinarySearch \n");
		
		value = 99;
		System.out.println(value + ((iterativeBinarySearch(data, value) ? " found " : " not found")));
		value = 15;
		System.out.println(value + ((iterativeBinarySearch(data, value) ? " found " : " not found")));
		value = 70;
		System.out.println(value + ((iterativeBinarySearch(data, value) ? " found " : " not found")));
		value = 3;
		System.out.println(value + ((iterativeBinarySearch(data, value) ? " found " : " not found")));
		value = 45;
		System.out.println(value + ((iterativeBinarySearch(data, value) ? " found " : " not found")));
		value = 65;
		System.out.println(value + ((iterativeBinarySearch(data, value) ? " found " : " not found")));

        System.out.println("\nRecursiveBinarySearch \n");

        value = 99;
		System.out.println(value + ((recursiveBinarySearch(data, value) ? " found " : " not found")));
		value = 15;
		System.out.println(value + ((recursiveBinarySearch(data, value) ? " found " : " not found")));		
		value = 70;
		System.out.println(value + ((recursiveBinarySearch(data, value) ? " found " : " not found")));		
		value = 3;
		System.out.println(value + ((recursiveBinarySearch(data, value) ? " found " : " not found")));		
		value = 45;
		System.out.println(value + ((recursiveBinarySearch(data, value) ? " found " : " not found")));		
		value = 65;
		System.out.println(value + ((recursiveBinarySearch(data, value) ? " found " : " not found")));

	}
}
