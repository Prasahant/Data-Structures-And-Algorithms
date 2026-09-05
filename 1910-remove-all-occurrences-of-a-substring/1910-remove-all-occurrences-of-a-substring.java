class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int p = part.length();
        for(int i=0; i<n; i++){
            sb.append(s.charAt(i));
            if(sb.length()>=p){
                String sub = sb.substring(sb.length()-p);
                if(sub.equals(part)){
                    sb.setLength(sb.length()-p);
                }
            }
        }
        return sb.toString();
    }
}