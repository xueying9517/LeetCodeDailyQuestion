import java.util.*;

public class SolutionXueYing1104 {
    public List<Integer> pathInZigZagTree(int label) {
        LinkedList<Integer> res = new LinkedList<>();
        int m = (int) (Math.log(label) / Math.log(2)) + 1;
        int offset;
        if (m % 2 == 0) {
            offset = (1 << m) - 1 - label;
        } else {
            offset = label - (1 << (m - 1));
        }
        while (m > 0) {
            int i;
            if (m % 2 == 0) {
                i = (1 << m) - 1 - offset;
            } else {
                i = offset + (1 << (m - 1));
            }
            res.addFirst(i);
            m--;
            offset = offset >> 1;
        }
        return res;
    }
}
