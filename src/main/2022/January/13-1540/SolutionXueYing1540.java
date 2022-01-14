import java.util.*;
public class SolutionXueYing1540 {
    public boolean canConvertString(String s, String t, int k) {
        int a = k / 26;
        int m = k % 26;
        if (s.length() != t.length()) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (c1 != c2) {
                int diff = 0;
                if (c2 > c1) {
                    diff = c2 - c1;
                } else {
                    diff = c2 - 'a' + 'z' - c1 + 1;
                }
                if (map.containsKey(diff)) {
                    int v = map.get(diff);
                    if (diff <= m) {
                        if (a + 1 < v + 1) {
                            return false;
                        }
                    } else {
                        if (a < v + 1) {
                            return false;
                        }
                    }
                    map.put(diff, v + 1);
                } else {
                    if (diff > k) {
                        return false;
                    }
                    map.put(diff, 1);
                }
            }
        }
        return true;
    }
}
