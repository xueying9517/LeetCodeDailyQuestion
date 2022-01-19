class Solution {
    public long numberOfWeeks(int[] ms) {
        Arrays.sort(ms);
        int last = ms[ms.length - 1];
        int gap = last - 1;
        long sum = 0;
        for(int i = ms.length - 2;i >= 0;i--) {
            sum += ms[i];
        }

        if(sum >= gap) {
            return sum + last;
        } else {
            return 2 * sum + 1;
        }
    }
}