class Solution {
    public int beautySum(String s) {
        int sum =0;
        for(int i=0; i<s.length(); i++){
            int[] freq = new int[26];
            for(int j=i; j<s.length(); j++){
                freq[s.charAt(j)-'a']++;
                int beauty = getMax(freq) - getMin(freq);
                sum = sum+beauty;
            }
        }
        return sum;
    }
    public int getMax(int[] freq){
        int max = 0;
        for(int i = 0; i<freq.length; i++){
            max = Math.max(max,freq[i]);
        }
        return max;
    }
    public int getMin(int[] freq){
        int min = Integer.MAX_VALUE;;
        for(int i = 0; i<freq.length; i++){
            if(freq[i]!=0){
                min = Math.min(min,freq[i]);
            }
        }
        return min;
    }    
    
    
}