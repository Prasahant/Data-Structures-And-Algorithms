class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = Arrays.stream(nums).max().getAsInt();
        while(low<=high){
            int mid = low + (high-low)/2;
            long totalSum = check(nums,mid);
            if(totalSum<=threshold){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
    public static long check(int[] arr, int val){
        long sum = 0;
        for(int i=0; i<arr.length; i++){
            sum = sum + (arr[i]+(long)val-1)/val;
        }
        return sum;
    }
}