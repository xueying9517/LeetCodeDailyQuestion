import java.util.*;
public class SolutionXueYing2096 {
    List<TreeNode> start;
    List<TreeNode> dest;
    public String getDirections(TreeNode root, int startValue, int destValue) {
        start = new ArrayList<>();
        dest = new ArrayList<>();
        findStartDest(new ArrayList<>(), root, startValue, destValue);
        int i = 0;
        for (; i < start.size() - 1 && i < dest.size() - 1; i++) {
            if (start.get(i + 1) != dest.get(i + 1)) {
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int j = i; j < start.size() - 1; j++) {
            sb.append("U");
        }
        for (int j = i; j < dest.size() - 1; j++) {
            if (dest.get(j).left != null && dest.get(j).left.val == dest.get(j + 1).val) {
                sb.append("L");
            }
            if (dest.get(j).right != null && dest.get(j).right.val == dest.get(j + 1).val) {
                sb.append("R");
            }
        }
        return sb.toString();
    }
    private void findStartDest(List<TreeNode> list, TreeNode r, int startVal, int destVal) {
        if (r == null) {
            return;
        }
        list.add(r);
        if (r.val == startVal) {
            start = new ArrayList(list);
        }
        if (r.val == destVal) {
            dest = new ArrayList(list);
        }
        findStartDest(list, r.left, startVal, destVal);
        findStartDest(list, r.right, startVal, destVal);
        list.remove(list.size() - 1);
        return;
    }
}
