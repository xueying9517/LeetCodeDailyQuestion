import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author wangcong03 <wangcong03@kuaishou.com>
 * Created on 2022-02-14
 */
public class SolutionWangCong1443 {

    int result = 0;

    boolean[] visitFlags;
    Map<Integer, TreeNode> nodeMap;

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        nodeMap = new HashMap<>(n);
        visitFlags = new boolean[n];

        for (int i = 0; i < n; i++) {
            nodeMap.put(i, new TreeNode(i, hasApple.get(i)));
        }

        int edgesLength = edges.length;
        for (int i = 0; i < edgesLength; i++) {
            int first = edges[i][0];
            int second = edges[i][1];
            TreeNode subNode = nodeMap.get(second);
            subNode.hasParent = true;
            subNode.addParent(first);
            TreeNode node = nodeMap.get(first);
            node.addSubNode(subNode);
        }
        visit(nodeMap.get(0), hasApple);
        return result;
    }

    public boolean visit(TreeNode treeNode, List<Boolean> hasApple) {
        //如果访问过，标记为false
        if (visitFlags[treeNode.val]) {
            return false;
        }

        visitFlags[treeNode.val] = true;

        boolean isAppleNode = hasApple.get(treeNode.val);
        boolean isContainApple = false;
        if (treeNode.subNodes != null) {
            for (TreeNode subNode : treeNode.subNodes) {
                if (visit(subNode, hasApple)) {
                    isContainApple = true;
                }
            }
        }


        if (treeNode.parentList != null) {
            for (Integer parentValue : treeNode.parentList) {
                if (visit(nodeMap.get(parentValue), hasApple)) {
                    isContainApple = true;
                }
            }
        }
        // System.out.println("val="+ treeNode.val +",hasParent="+ treeNode.hasParent
        // +",isAppleNode="+isAppleNode+",isContainApple="+isContainApple);
        if (treeNode.val != 0 && (isAppleNode || isContainApple)) {
            result += 2;
        }

        return isAppleNode || isContainApple;
    }


    public class TreeNode {
        public int val;
        public boolean hasParent;
        public boolean hasApple;
        public List<TreeNode> subNodes;
        public List<Integer> parentList;

        public TreeNode(int val, boolean hasApple) {
            this.val = val;
            this.hasApple = hasApple;
        }

        public void addSubNode(TreeNode treeNode) {
            if (subNodes == null) {
                subNodes = new LinkedList<>();
            }
            subNodes.add(treeNode);
        }

        public void addParent(int parentValue) {
            if (parentList == null) {
                parentList = new LinkedList<>();
            }
            parentList.add(parentValue);
        }
    }
}
