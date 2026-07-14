
// ConceptDemo.java
// A.Adeyemi
// 7/9/26
// Demonstration of the Adapter pattern and use of generics

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ConceptDemo {
    public static void main(String[] args){
        // Create the original Integer[] array
        Integer[] numberArray = {5, 2, 9, 1, 4, 7};

        // Create the ArrayAdapter object and pass the array to it
        ArrayAdapter adapter = new ArrayAdapter(numberArray);

        // Call the adapter’s toList() method to obtain a new, mutable List<Integer>
        List<Integer> numbers = adapter.toList();

        // Print the list before sorting
        System.out.println("Before sorting: " + numbers);

        // Sort the list using Collections.sort() and print it again
        Collections.sort(numbers);
        System.out.println("After sorting: " + numbers);

        // Remove the value 4 from the list. Use Integer.valueOf(4) so Java removes the value 4, not
        //the element at index 4
        numbers.remove(Integer.valueOf(4));
        System.out.println("After removing 4: " + numbers);

        // Call printList(numbers) to demonstrate the unbounded wildcard method
        printList(numbers);
    }
    // The printList() method accepts List<?>, meaning it can receive a list of any element type
    public static void printList(List<?> list) {
        System.out.println(
                "Printing list using unbounded wildcard: " + list);
    }
}
// Finally, create the ArrayAdapter class.
class ArrayAdapter {
    private Integer[] array;
    public ArrayAdapter(Integer[] array) {
        this.array = array;
    }
    public List<Integer> toList() {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, array);
        return list;
    }
}

