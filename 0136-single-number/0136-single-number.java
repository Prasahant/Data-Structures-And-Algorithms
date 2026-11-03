class Solution {
    public int singleNumber(int[] nums) {
        //return usingHashMap(nums) // using hashMap
        return usingXOR(nums);// Bit manipulation
    }
    public int usingHashMaph(int nums[]){
        int num =0;
        HashMap<Integer,Integer>hash = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            if(hash.containsKey(nums[i])){
                hash.put(nums[i],hash.get(nums[i])+1);
            }else{
                hash.put(nums[i],1);
            }
        }
        for(Map.Entry<Integer, Integer>entry:hash.entrySet()){
            if(entry.getValue()==1){
                num = entry.getKey();
            }
        }
        return num;
    }
    public int usingXOR(int nums[]){
        int n = nums.length;
        int xor = 0;
        for(int i=0;i<n; i++){
            xor = xor^nums[i];
        }
        return xor;
    }
}