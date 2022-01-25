import java.util.*;
public class SolutionXueYing1298 {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int res = 0;
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> k = new HashSet<>();
        Set<Integer> boxes = new HashSet<>();
        boolean[] visit = new boolean[status.length];
        for (int i = 0; i < initialBoxes.length; i++) {
            boxes.add(initialBoxes[i]);
            if (status[initialBoxes[i]] == 1) {
                queue.offer(initialBoxes[i]);
                visit[initialBoxes[i]] = true;
            }
        }
        while (!queue.isEmpty()) {
            int box = queue.poll();
            res += candies[box];
            for (int i = 0; i < keys[box].length; i++) {
                int curKey = keys[box][i];
                k.add(curKey);
                if (!visit[curKey] && boxes.contains(curKey)) {
                    queue.offer(curKey);
                    visit[curKey] = true;
                }
            }
            for (int i = 0; i < containedBoxes[box].length; i++) {
                int curBox = containedBoxes[box][i];
                boxes.add(curBox);
                if (!visit[curBox] && (k.contains(curBox) || status[curBox] == 1)) {
                    queue.offer(curBox);
                    visit[curBox] = true;
                }
            }
        }
        return res;
    }
}
