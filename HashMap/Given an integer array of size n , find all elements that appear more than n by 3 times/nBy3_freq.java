import java.util.*;
public class nBy3_freq {

    public static void majorityElement(int nums[]){
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            else{
                map.put(nums[i], 1);
            }
        }

        for(int key : map.keySet()){
            if(map.get(key) > (n/3))
                System.out.println("Number : " + key + " Frequency : "+ map.get(key));
        }
    }

    public static void main(String args[]){
        int nums[] = {1,2,3,4,1,5,7,1,3,5,7,1,2,5,8,3,1,1,1};
        majorityElement(nums);
    }
}
