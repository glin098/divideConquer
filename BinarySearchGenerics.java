import java.util.Arrays;

public class BinarySearchGenerics {

 	private static <T> String vectorToString(String text, T[] vector) {
	    String s = text + " {";

	    for (int i=0; i < vector.length; i++)
	        s = s + vector[i].toString() + ((i < vector.length - 1) ? ", " : "");

	    s = s + "}";

	    return s;
	}

	private static <T extends Comparable<T>> boolean iterativeBinarySearch(T[] vector, T value) {
        int mid, low = 0, high = vector.length - 1;
        
        while (low <= high) {
            mid = (low + high) / 2;

            if(vector[mid].compareTo(value) == 0) {
                return true;
            } else if (vector[mid].compareTo(value) > 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
  }
	
	private static <T extends Comparable<T>> boolean recursiveBinarySearch(T[] vector, T value) {
		return recursiveBinarySearch(vector, value, 0, vector.length - 1);
	}
	
	private static <T extends Comparable<T>> boolean recursiveBinarySearch(T[] vector, T value, int low, int high) {
        if(low > high){
            return false;
        }
        else {
            int mid = (low + high) / 2;
            if (vector[mid] == value)
                return true;
            else
                if(vector[mid].compareTo(value) > 0)
                    return recursiveBinarySearch(vector, value, low, mid - 1);
                else
                    return recursiveBinarySearch(vector, value, mid + 1, high);
        }
  }
	
	public static void main(String[] args) {
		int value;
		
		Integer[] data = { 5, 7, 9, 10, 15, 19, 21, 23, 31, 45, 56, 67, 70 };
		
		System.out.println(vectorToString("Data  ", data));
		
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

    
		// Search using an array of Person
		
		IPerson[] people = new Person [] { new Person(50, "John", "Smith"), new Person(20, "Jane", "Johnson"), new Person(10, "Mary", "White"), new Person(40, "Peter", "Collins"), new Person(30, "Julia", "Smith") };
		
		Arrays.sort(people);
		
		System.out.println(vectorToString("\nPeople", people));
		
		System.out.println("\nIterativeBinarySearch \n");
		
		IPerson p = new Person(90, "James", "Parker");
		
		System.out.println(p + ((iterativeBinarySearch(people, p) ? " found " : " not found")));
		
		p = new Person(10, "Mary", "White");
		
		System.out.println(p + ((iterativeBinarySearch(people, p) ? " found " : " not found")));
		
		System.out.println("\nIterativeBinarySearch \n");
		
		p = new Person(90, "James", "Parker");
		
		System.out.println(p + ((recursiveBinarySearch(people, p) ? " found " : " not found")));
		
		p = new Person(10, "Mary", "White");
		
		System.out.println(p + ((recursiveBinarySearch(people, p) ? " found " : " not found")));
    
    
	}
}
