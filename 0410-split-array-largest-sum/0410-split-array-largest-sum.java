class Solution {
    public int splitArray(int[] nums, int k) {
        long low = Arrays.stream(nums).max().getAsInt();
        long high = 0;
        for(int i=0; i<nums.length; i++){
            high = high+nums[i];
        }
        while(low<=high){
            long mid = low + (high-low)/2;
            int count = sumCount(nums, mid);
            if(count>k){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return (int) low;
    }
    public static int sumCount(int[] arr, long totalSum){
        long arraySum= 0;
        int subArray =1;
        for(int i=0; i<arr.length; i++){
            if(arraySum + arr[i]<=totalSum){
                arraySum += arr[i];
            }else{
                subArray++;
                arraySum = arr[i];
            }
        }
        return subArray;
    }
}