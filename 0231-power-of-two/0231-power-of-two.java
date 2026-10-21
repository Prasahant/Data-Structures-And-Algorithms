class Solution {
    public boolean isPowerOfTwo(int n) {
        String bin = decToBin(n);
        int size = bin.length();
        int cnt = 0;
        for(int i=0; i<size; i++){
            if(bin.charAt(i)=='1'){
                cnt++;
            }
        }
        if(cnt == 1){
            return true;
        }
        
        return false;
    }
    public String decToBin(int n){
        String s = "";
        while(n>0){
            if(n%2==1){
                s = s+'1';
            }
            else{
                s=s+'0';
            }
            n=n/2;
        }
        return new StringBuilder(s).reverse().toString();
    }
}