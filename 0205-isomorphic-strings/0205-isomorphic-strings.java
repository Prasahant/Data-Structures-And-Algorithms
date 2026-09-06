class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        if(s.length()!=t.length()){
            return false;
        }
        for(int i = 0; i<s.length();i++){
            char original = s.charAt(i);
            char replace = t.charAt(i);
            if(!map.containsKey(original)){
                if(!map.containsValue(replace)){
                    map.put(original,replace);
                }
                else{
                    return false;
                }
            }
            else{
                char duplicate = map.get(original);
                if(duplicate!=replace){
                    return false;
                }
            }
        }
        return true;
    }
}