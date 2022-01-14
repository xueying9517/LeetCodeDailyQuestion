public class SolutionXiaoWei1802 {
    public int maxValue(int n, int index, int maxSum) {
        int l = 1, r = maxSum;
        while(r > l) {
            int m = (r + l + 1) / 2;
            if (isValid(n, index, maxSum, m)) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        return l;
    }

    public boolean isValid(int n, int index, int maxSum, long m) {
        int leftIndexCnt = index;
        int rightIndexCnt = n - (index + 1);

        long sum = m;
        //1, 1, m - 1, m, m - 1, m - 2, ... , 1 , 1
        //1 to m = m;
        if(leftIndexCnt > 0) {
            if(leftIndexCnt >= (m - 1)) {
                sum += (leftIndexCnt - (m - 1));
                sum += m * (m - 1) / 2;
            } else {
                sum += (2 * m - leftIndexCnt - 1) * (leftIndexCnt) / 2;
            }
        }
        if(rightIndexCnt > 0) {
            if(rightIndexCnt >= (m - 1)) {
                sum += (rightIndexCnt - (m - 1));
                sum += m * (m - 1) / 2;
            } else {
                sum += (2 * m - rightIndexCnt - 1) * (rightIndexCnt) / 2;
            }
        }
        return sum <= maxSum;
    }
}
