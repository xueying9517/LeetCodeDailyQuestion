import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author wangcong03 <wangcong03@kuaishou.com>
 * Created on 2022-02-04
 */
public class SolutionWangCong1268 {

    private static final int size = 3;

    public static class TrieNode {
        boolean isEnd = false;
        Map<Character, TrieNode> subNodes = new HashMap<>();

        PriorityQueue<String> queue = new PriorityQueue<>(Comparator.reverseOrder());

        public void addWord(Character key, TrieNode node) {
            subNodes.put(key, node);
        }

        public TrieNode getSubNode(Character key) {
            return subNodes.get(key);
        }

        //判断是否是关键字的结尾
        public boolean isKeyWordEnd() {
            return isEnd;
        }

        //设置为关键字的结尾
        public void setKeyWordEnd(boolean isEnd) {
            this.isEnd = isEnd;
        }

    }

    public void addTireTree(String textLine, TrieNode root) {
        if (textLine == null)
            return;
        TrieNode tempNode = root;
        for (int i = 0; i < textLine.length(); i++) {
            char charWord = textLine.charAt(i);
            TrieNode node = tempNode.getSubNode(charWord);
            if (node == null) {
                node = new TrieNode();
                tempNode.addWord(charWord, node);
            }

            tempNode = node;
            tempNode.queue.offer(textLine);
            if (node.queue.size() > size)
                node.queue.poll();
            if (i == textLine.length() - 1)
                tempNode.setKeyWordEnd(true);
        }
    }


    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        TrieNode root = new TrieNode();
        for (String product : products) {
            addTireTree(product, root);
        }

        List<List<String>> ans = new LinkedList<>();

        TrieNode cur = root;
        boolean flag = false;
        for (int i = 0; i < searchWord.length(); i++) {
            char charWord = searchWord.charAt(i);
            if ( flag || !cur.subNodes.containsKey(charWord)) {
                ans.add(new ArrayList<>());
                flag = true;
            } else {
                cur = cur.subNodes.get(charWord);
                List<String> tmp = new ArrayList<>();
                while(!cur.queue.isEmpty()) {
                    tmp.add(cur.queue.poll());
                }
                Collections.reverse(tmp);
                ans.add(tmp);
            }
        }

        return ans;
    }
}
