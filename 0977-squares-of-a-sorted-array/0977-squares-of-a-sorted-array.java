class Solution {
    public int[] sortedSquares(int[] nums) {
        int squares[] = Arrays.stream(nums).map(n->n*n).toArray();
        Arrays.sort(squares);
        return squares;
    }
}