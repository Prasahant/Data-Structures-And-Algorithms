class Solution {
    public int minimizedMaximum(int p, int[] quantities) {
      
        int n = quantities.length;
        int low =1; 
        int high = Arrays.stream(quantities).max().getAsInt();
        while(low<=high){
            int mid = low + (high-low)/2;
            long total = distribution(quantities, mid);
            if(total>p){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return low;
    }
    public static long distribution(int[] arr, int mid){
        
        long sum = 0;
        for(int i=0; i<arr.length; i++){
            sum = sum + (arr[i]+(long)mid-1)/mid;
        }
        return sum;
    }
}