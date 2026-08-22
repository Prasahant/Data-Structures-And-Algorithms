class Solution {
    public boolean isPalindrome(String s) {
        
        s = s.trim().toLowerCase();
        s=s.replaceAll("[^a-z0-9]","");
        return check(s,0);
    }
    public boolean check(String s, int i){
        if(i>=s.length()/2){
            return true;
        }
        if(s.charAt(i)!=s.charAt(s.length()-i-1)){
            return false;
        }
        return check(s,i+1);
    }
}