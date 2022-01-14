import java.util.*;
public class SolutionXiaoWei1104 {
    List<Integer> res;
    public List<Integer> pathInZigZagTree(int label) {
        res = new ArrayList<>();
        helper(label, 1, 2, false);
        return reverse(res);
    }

    private List<Integer> reverse(List<Integer> res) {
        List<Integer> list = new ArrayList<>();
        for(int i = res.size() - 1;i >= 0;i--) list.add(res.get(i));
        return list;
    }

    private int helper(int label, int start, int end, boolean reverse) {
        if(label >= start && label < end) {
            int leftOffset = reverse ? (end - 1 - label) : (label - start);
            res.add(label);
            return leftOffset;
        }

        int nextOffset = helper(label, start * 2, end * 2, !reverse);
        int currentOffset = nextOffset / 2;
        res.add(reverse ? (end - 1 - currentOffset) : (start + currentOffset));
        return currentOffset;
    }
}
