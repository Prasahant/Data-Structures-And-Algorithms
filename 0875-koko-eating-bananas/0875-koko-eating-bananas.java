class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low  = 1;
        int high = Arrays.stream(piles).max().getAsInt();
        while(low<=high){
            int mid = low + (high-low)/2;
            long totalHrs = hrs(piles, mid);
            if(totalHrs<=h){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }
    public static long hrs(int[] arr, int h){
        long totalhrs = 0;
        for(int i=0; i<arr.length; i++){
            totalhrs += (arr[i] +(long) h - 1) / h; //Ceil

        }
        return totalhrs;
    }
}