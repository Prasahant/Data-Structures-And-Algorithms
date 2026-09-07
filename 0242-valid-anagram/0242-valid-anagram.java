class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int count = 1;
        for(int i=0; i<s.length(); i++){
            char ch1 = s.charAt(i);
            if (map.containsKey(ch1)) {
                map.put(ch1, map.get(ch1) + 1);
            } else {
                map.put(ch1, 1);
            } 
        }
        for(int i=0; i<t.length(); i++){
            char ch = t.charAt(i);
            if(!map.containsKey(ch)){
                return false;
            }else{
                map.put(ch, map.get(ch)-1);
            }
            if (map.get(ch) < 0) {
                return false;
            }
        }
        return true;
    }
}