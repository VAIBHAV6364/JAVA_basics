import java.util.*;
public class IntersectionOf2Arrays {
    public static void main(String args[]){
        int arr1[] = {1,2,3,4,5,6,7,8,9};
        int arr2[] = {1,3,5,7,9};

        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> intersection = new HashSet<>();

        // Add all elements of arr1 to set1
        for (int num : arr1) {
            set1.add(num);
        }

        // Check for common elements
        for (int num : arr2) {
            if (set1.contains(num)) {
                intersection.add(num);
            }
        }

        // Print result
        System.out.println("No of elements in Intersection set : " + intersection.size());
        System.out.println("Intersected set : " + intersection);
    }
}
