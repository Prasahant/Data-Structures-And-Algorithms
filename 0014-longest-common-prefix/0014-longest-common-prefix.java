class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int n = strs.length;
        for(int i=0; i<strs[0].length(); i++){
            char ch = strs[0].charAt(i);
            for(int j = 1; j<n; j++){
                if (i >= strs[j].length() || strs[j].charAt(i) != ch) {
                    return sb.toString();
                }
            }
            sb.append(ch);
        }
        return sb.toString();
    }
}