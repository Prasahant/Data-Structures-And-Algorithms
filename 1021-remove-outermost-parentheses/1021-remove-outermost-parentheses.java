class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int balance = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(') {
                // If balance is > 0, it means this is not an outermost '('
                if (balance > 0) {
                    result.append(c);
                }
                balance++;
            } else {
                balance--;
                // If balance is > 0 after decrementing, it means this is not an outermost ')'
                if (balance > 0) {
                    result.append(c);
                }
            }
        }
        
        return result.toString();
    }
}