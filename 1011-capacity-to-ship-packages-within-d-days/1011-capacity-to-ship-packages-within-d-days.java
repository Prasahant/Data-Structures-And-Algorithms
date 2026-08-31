class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = Arrays.stream(weights).max().getAsInt();
        int high = 0;
        for(int i=0; i<weights.length; i++){
            high = high+weights[i];
        }
        while(low<=high){
            int mid = low + (high-low)/2;
            int totalDays = checkDay(weights, mid);
            if(totalDays<=days){
                high = mid-1;

            }else{
                low = mid+1;
            }
        }
        return low;
    }
    public static int checkDay(int[] arr, int capa){
        int day = 1;
        int load = 0;
        for(int i=0; i<arr.length; i++){
            if(load+arr[i]>capa){
                day++;
                load = arr[i];
            }else{
                load += arr[i];
            }
        }
        return day;
    }
}