class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()){
            return false;
        }
        //One method 

        // for(int i=0; i<s.length(); i++){
        //     String res = s.substring(i) + s.substring(0,i) ;
        //     if(res.equals(goal)){
        //         return true;
        //     }
        // }
        // return false;

        //Another Method
        return (s+s).contains(goal);
    }
}