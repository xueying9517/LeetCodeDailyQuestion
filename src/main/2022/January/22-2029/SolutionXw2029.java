class Solution {
    public boolean stoneGameIX(int[] stones) {
        int[] leftCnt = new int[3];
        for(int i = 0;i < stones.length;i++) {
            int value = stones[i];
            leftCnt[value % 3]++;
        }
        if(leftCnt[0] % 2 == 0) return leftCnt[1] > 0 && leftCnt[2] > 0;
        else return Math.abs(leftCnt[1] - leftCnt[2]) > 2;
    }
}