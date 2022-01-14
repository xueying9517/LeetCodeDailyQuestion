public class SolutionXiaoWei1540 {
    public boolean canConvertString(String s, String t, int k) {
        if(s.length() != t.length()) {
            return false;
        }
        int[] cnt = new int[26];
        int len = s.length();
        for(int i = 0;i < len;i++) {
            if(t.charAt(i) != s.charAt(i)) {
                int target = (t.charAt(i) - 'a');
                int source = (s.charAt(i) - 'a');
                int gap = ((target + 26) - source) % 26;
                cnt[gap]++;
            }
        }
        for(int i = 1;i < 26;i++) {
            if(cnt[i] > 0 && (cnt[i] - 1) * 26 + i > k) return false;
        }
        return true;
    }
}
