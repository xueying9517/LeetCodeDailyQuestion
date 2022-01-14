public class SolutionXiaoWei2096 {
    String startPath;
    String destPath;
    StringBuilder sb;
    public String getDirections(TreeNode root, int startValue, int destValue) {
        sb = new StringBuilder();
        helper(root, startValue, destValue);
        int i = 0, j = 0;
        while(i < startPath.length() && j < destPath.length()
                && startPath.charAt(i) == destPath.charAt(j)) {
            i++;
            j++;
        }
        StringBuilder res = new StringBuilder();
        while(i < startPath.length()) {
            res.append("U");
            i++;
        }
        while(j < destPath.length()) {
            res.append(destPath.charAt(j++));
        }
        return res.toString();
    }

    public void helper(TreeNode root, int startValue, int destValue) {
        if(root == null) return;
        if(root.val == startValue) startPath = sb.toString();
        if(root.val == destValue) destPath = sb.toString();
        sb.append("L");
        helper(root.left, startValue, destValue);
        sb.deleteCharAt(sb.length() - 1);
        sb.append("R");
        helper(root.right, startValue, destValue);
        sb.deleteCharAt(sb.length() - 1);
    }
}
