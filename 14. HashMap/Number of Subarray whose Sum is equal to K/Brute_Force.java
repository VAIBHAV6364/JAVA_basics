public class Brute_Force {
    public static int subArray(int arr[], int sum){
        int subsum = 0, count = 0;
        for(int i = 0; i < arr.length; i++){
            subsum = 0;
            for(int j = i; j < arr.length; j++){
                subsum += arr[j];
                if(subsum == sum)
                    count++;
            }
        }
        return count;
    }

    public static void main(String args[]){
        int arr[] = {10,2,-2,-20,10};
        int sum = -10;
        System.out.println("Number of subarrays : "+ subArray(arr, sum));
    }
}
