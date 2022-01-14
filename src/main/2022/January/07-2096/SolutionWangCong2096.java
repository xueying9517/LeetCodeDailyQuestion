import java.util.*;

public class SolutionWangCong2096 {
    public String getDirections(TreeNode root, int startValue, int destValue) {
//记录每个节点的父节点值是啥，-1表示没有父节点
        int max = 100001;
        int[] nodeParentValue = new int[max];
        //记录每个节点在父节点中是左孩子还是右孩子, true表示左，false表示右
        boolean[] nodeParentIndex = new boolean[max];

        int startDepth = 0, destDepth = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        nodeParentValue[root.val] = -1;
        queue.offer(root);
        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode treeNode = queue.poll();
                int currentValue = treeNode.val;
                if (currentValue == startValue) {
                    startDepth = depth;
                }
                if (currentValue == destValue) {
                    destDepth = depth;
                }
                size--;
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                    nodeParentValue[treeNode.left.val] = currentValue;
                    nodeParentIndex[treeNode.left.val] = true;
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                    nodeParentValue[treeNode.right.val] = currentValue;
                }
            }
            depth++;
            if (startDepth > 0 && destDepth > 0) {
                break;
            }
        }

        int[] startPath = findRootPath(startValue, nodeParentValue, startDepth);
        int[] destPath = findRootPath(destValue, nodeParentValue, destDepth);
        int end = Math.min(startDepth, destDepth);
        StringBuffer buffer = new StringBuffer();
        int i = 0;
        int publicNodeValue = startPath[0];
        for (i = 0; i < end; i++) {
            if (startPath[i] != destPath[i]) {
                break;
            }
        }
        publicNodeValue = startPath[i-1];
        for (int j = i; j < startDepth; j++) {
            buffer.append('U');
        }
        StringBuffer tmpPath = new StringBuffer();
        int parentValue = destValue;
        // System.out.println("publicNodeValue="+ publicNodeValue+ ",i="+i);
        // System.out.println("startPath=" +Arrays.toString(startPath));
        // System.out.println("destPath=" +Arrays.toString(destPath));
        while (parentValue != publicNodeValue) {
            tmpPath.append( nodeParentIndex[parentValue] ? 'L' : 'R');
            parentValue = nodeParentValue[parentValue];
        }
        buffer.append(tmpPath.reverse());
        return buffer.toString();
    }


    public int[] findRootPath(int value, int[] nodeParentValue, int depth) {
        int[] path = new int[depth];
        int tmp = value;
        while (tmp != -1) {
            path[--depth] = tmp;
            tmp = nodeParentValue[tmp];
        }
        return path;
    }
}
