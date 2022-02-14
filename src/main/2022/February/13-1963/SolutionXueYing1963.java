public class SolutionXueYing1963 {
    public int minSwaps(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                stack.addFirst(s.charAt(i));
            } else if (s.charAt(i) == ']') {
                if (stack.isEmpty() || stack.getFirst() == ']') {
                    stack.addFirst(s.charAt(i));
                } else {
                    stack.removeFirst();
                }
            }
        }
        int size = stack.size() / 2;
        if (size % 2 == 0) {
            return size / 2;
        } else {
            return size / 2 + 1;
        }
    }
}
