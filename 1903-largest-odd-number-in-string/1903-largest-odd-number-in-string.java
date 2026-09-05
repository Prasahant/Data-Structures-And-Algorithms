class Solution {
    public String largestOddNumber(String num) {
        int n = num.length();
        for(int i =n-1; i>=0; i--){
            int number= num.charAt(i)-'0';
            if(number%2==1){
                return num.substring(0,i+1);
                
            }
        }
        return "";
    }
    // public String largestOddNumber(String num) {
    //     int n = num.length();
    //     int cnt = -1;
    //     StringBuilder sb = new StringBuilder("");
    //     for(int i =0; i<n; i++){
    //         int number= num.charAt(i)-'0';
    //         if(number%2==1){
    //             cnt= i;   
    //         }
    //     }
    //     if (cnt != -1) {
    //         sb.append(num.substring(0, cnt + 1));
    //     }
    //     return sb.toString();
    // }
}