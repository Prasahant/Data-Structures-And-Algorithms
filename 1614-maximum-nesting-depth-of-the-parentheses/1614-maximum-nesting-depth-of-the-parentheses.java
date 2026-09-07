class Solution {
    public int maxDepth(String s) {
        int curr = 0;
        int max = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                curr++;
            }
            max = Math.max(max, curr);
            if(s.charAt(i)==')'){
                curr--;
            }
        }
        return max;
    }
}