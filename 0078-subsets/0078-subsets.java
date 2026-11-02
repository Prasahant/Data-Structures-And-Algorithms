class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // List<List<Integer>> result = new ArrayList<>();
        // List<Integer> current = new ArrayList<>();

        // printSub(0, nums, current, result);

        // return result;

        return bitManipulation(nums);
    }
    private void printSub(int idx, int[] arr, List<Integer> current,    List<List<Integer>> result){
        int n = arr.length; 
        if(idx >= n){
            result.add(new ArrayList<>(current));
            return;
        }
        current.add(arr[idx]);
        printSub(idx+1, arr, current, result);

        current.remove(current.size()-1);
        printSub(idx+1, arr, current, result);
    }
    public List<List<Integer>> bitManipulation(int[] nums){
        //by using Bit Manipulation
        List<List<Integer>>list = new ArrayList<>();
        int n = nums.length;
        int subsetCounts = 1<<n;
        for(int num=0; num<subsetCounts; num++){
            List<Integer>curr = new ArrayList<>();
            for(int i=0; i<n; i++){
                if((num & (1<<i))!=0){
                    curr.add(nums[i]);
                }
            }
            list.add(curr);
        }
        return list;
    }
}