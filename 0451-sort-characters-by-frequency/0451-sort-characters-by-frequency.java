class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer>map = new HashMap<>();
        for(int i =0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }else{
                map.put(ch,1);
            }
        }
        StringBuilder sb = new StringBuilder();
        

        while (!map.isEmpty()) {

            char maxChar = 0;
            int maxFreq = 0;

            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() > maxFreq) {
                    maxFreq = entry.getValue();
                    maxChar = entry.getKey();
                }
            }

            for (int i = 0; i < maxFreq; i++) {
                sb.append(maxChar);
            }

            map.remove(maxChar);
        }

        return sb.toString();
    }
}