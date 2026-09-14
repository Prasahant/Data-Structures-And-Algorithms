class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int commonW = Math.min(rec1[2], rec2[2]) - Math.max(rec1[0], rec2[0]);
        
        // Calculate common height
        int commonH = Math.min(rec1[3], rec2[3]) - Math.max(rec1[1], rec2[1]);
        
        // Both common width and common height must be strictly greater than 0
        return commonW > 0 && commonH > 0;
    }
    
}