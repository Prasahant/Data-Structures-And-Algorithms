class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE; 
        for(int i=0; i<n; i++){
            max = Math.max(max, nums[i]);
            min = Math.min(min,nums[i]);
        }
        ArrayList<Integer>list = new ArrayList<>();
        int[] hash = new int[max+1];
        for (int i = 0; i < n; i++) {
            hash[nums[i]] = 1;
        }
        for (int i = min; i <= max; i++) {
            if (hash[i] == 0) {
                list.add(i);
            }
        }
        return list;
    }
}