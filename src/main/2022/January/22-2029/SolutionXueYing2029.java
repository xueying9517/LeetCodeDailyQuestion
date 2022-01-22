public class SolutionXueYing2029 {
    public boolean stoneGameIX(int[] stones) {
        int[] num = new int[3];
        for (int i = 0; i < stones.length; i++) {
            num[stones[i] % 3]++;
        }
        int n1 = Math.abs(num[1] - num[2]);
        int n2 = num[0] % 2;
        if (n2 == 0) {
            if (num[1] != 0 && num[2] != 0) {
                return true;
            }
        } else {
            if (n1 > 2) {
                return true;
            }
        }
        return false;
    }
}
