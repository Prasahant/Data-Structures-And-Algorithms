class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length < (long)m * k) {
            return -1;
    }
        int low = Arrays.stream(bloomDay).min().getAsInt();
        int high = Arrays.stream(bloomDay).max().getAsInt();

        while(low<=high){
            int mid = low + (high-low)/2;
            if(possible(bloomDay, mid, m, k)==true){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }

    public static boolean possible(int[] arr, int day, int m, int k){
        int count = 0;
        int bloomFlower = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]<=day){
                count++;
            }
            else{
                bloomFlower += (count)/k;
                count=0;
            }
        }
        bloomFlower += (count)/k;
        if(bloomFlower>=m){
            return true;
        }
        return false;
    }
}