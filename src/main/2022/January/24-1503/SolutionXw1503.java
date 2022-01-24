class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int max = Integer.MIN_VALUE;
        for(int i = 0;i < left.length;i++) {
            max = Math.max(left[i], max);
        }
        for(int i = 0;i < right.length;i++) {
            max = Math.max((n - right[i]), max);
        }
        return max;
    }
}