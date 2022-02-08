import java.util.*;
public class SolutionXueYing1268 {
    private class Trie {
        TrieNode root;
        Trie() {
            root = new TrieNode();
        }
        void insert(String s) {
            TrieNode r = root;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (r.next[c - 'a'] == null) {
                    r.next[c - 'a'] = new TrieNode();
                }
                r = r.next[c - 'a'];
            }
            r.isEnd = true;
            r.word = s;
        }
        void startWith(String pre, List<String> list) {
            TrieNode r = root;
            for (int i = 0; i < pre.length(); i++) {
                char c = pre.charAt(i);
                if (r.next[c - 'a'] == null) {
                    return;
                }
                r = r.next[c - 'a'];
            }
            find(list, r);
        }
        void find(List<String> list, TrieNode n) {
            if (list.size() >= 3) {
                return;
            }
            if (n.isEnd) {
                list.add(n.word);
            }
            for (int i = 0; i < 26; i++) {
                if (n.next[i] != null) {
                    find(list, n.next[i]);
                }
            }
        }
    }
    private class TrieNode {
        private boolean isEnd;
        private TrieNode[] next;
        String word;
        TrieNode() {
            this.isEnd = false;
            this.next = new TrieNode[26];
            this.word = "";
        }
    }
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < products.length; i++) {
            trie.insert(products[i]);
        }
        for (int i = 1; i <= searchWord.length(); i++) {
            String tmp = searchWord.substring(0, i);
            List<String> list = new ArrayList<>();
            trie.startWith(tmp, list);
            res.add(list);
        }
        return res;
    }
}
