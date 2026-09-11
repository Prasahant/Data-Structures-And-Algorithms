class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int hash[] = new int[n+1];
        for(int i=0; i<nums.length; i++){
            if(nums[i]>0 && nums[i]<=n){
                hash[nums[i]]++;
            }
        }
        for(int i=1; i<hash.length; i++){
            if(hash[i]==0){
                return i;
            }
        }
        return n+1;
    }
}