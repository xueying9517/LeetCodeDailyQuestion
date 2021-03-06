import java.util.*;
public class SolutionXueYing1503 {
    public int getLastMoment(int n, int[] left, int[] right) {
        Arrays.sort(left);
        Arrays.sort(right);
        return Math.max(left.length > 0 ? left[left.length - 1] : 0, right.length > 0 ? n - right[0] : 0);
    }
}
