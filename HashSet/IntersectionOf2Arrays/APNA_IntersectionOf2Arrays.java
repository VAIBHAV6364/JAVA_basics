import java.util.*;
public class APNA_IntersectionOf2Arrays {
    public static void main(String args[]){
        int arr1[] = {1,2,3,4,5,6,7,8,9};
        int arr2[] = {1,3,5,7,9};
        union(arr1, arr2);
    }

    public static void union(int arr1[], int arr2[]){
        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        for(int i = 0; i < arr1.length; i++){
            set.add(arr1[i]);
        }

        System.out.println("Intersected Set : ");
        for(int j = 0; j < arr2.length; j++){
            if(set.contains(arr2[j])){
                count++;
            }
        }
        System.out.println("No of intersected elements : "+ count);
    }
}
