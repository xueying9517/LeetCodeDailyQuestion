import java.util.*;

public class SolutionWangCong1104 {
    public List<Integer> pathInZigZagTree(int label) {

        //分奇偶数
        List<Integer> result = new LinkedList<>();
        int height = (int) (Math.log(label) / Math.log(2));
        int tmp = getFixedValue(label, height);
        result.add(label);
        for (int i = height - 1; i >= 0; i--) {
            tmp = tmp / 2;
            result.add(0, getFixedValue(tmp, i));
        }
        return result;
    }

    public int getFixedValue(int value, int height) {
        if (height % 2 == 1) {
            int pairSum = (int) Math.pow(2, height + 1)
                    + (int) Math.pow(2, height) - 1;
            return pairSum - value;
        } else {
            return value;
        }
    }
}
