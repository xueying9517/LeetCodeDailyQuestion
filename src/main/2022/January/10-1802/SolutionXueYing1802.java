public class SolutionXueYing1802 {
    public int maxValue(int n, int index, int maxSum) {
        long l = 1, r = maxSum;
        while (l < r) {
            long mid = (l + r + 1) >> 1;
            double sum = arrSum(index + 1, mid) + arrSum(n - index, mid) - mid;
            if (sum > maxSum) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return (int)l;
    }
    private double arrSum(int index, long num) {
        double res = 0;
        if (num > index) {
            res = (num + num - index + 1) * index / 2;
        } else {
            res = (1 + num) * num / 2 + index - num;
        }
        return res;
    }
}
