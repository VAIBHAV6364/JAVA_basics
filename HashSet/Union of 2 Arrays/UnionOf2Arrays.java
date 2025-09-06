import java.util.*;
public class UnionOf2Arrays {
    public static void main(String args[]){
        int arr1[] = {1,2,3,4,5,6,7,8};
        int arr2[] = {1,3,5,7,9};
        int n = arr1.length;
        int m = arr2.length;

        HashSet<Integer> set = new HashSet<>();
        for(int i =0; i < n; i++){
            set.add(arr1[i]);
        }

        for(int i = 0; i < m; i++){
            set.add(arr2[i]);
        }
        System.out.println(set);
    }
}
