public class SolutionXueYing1953 {
    public long numberOfWeeks(int[] milestones) {
        long max = 0;
        long sum = 0;
        for (int i = 0; i < milestones.length; i++) {
            sum += milestones[i];
            max = Math.max(milestones[i], max);
        }
        if (sum - max >= max) {
            return sum;
        } else {
            return (sum - max) * 2 + 1;
        }
    }
}
