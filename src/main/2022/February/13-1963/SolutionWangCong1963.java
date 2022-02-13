import java.util.Stack;

/**
 * @author wangcong03 <wangcong03@kuaishou.com>
 * Created on 2022-02-13
 */
public class SolutionWangCong1963 {

    public int minSwaps(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        int result = 0;
        int length = chars.length;
        for(int i = 0; i< length; i++) {
            if(chars[i] == '[') {
                stack.push(chars[i]);
            } else {
                if(!stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                } else {
                    result++;
                }
            }
        }
        return (result+1)/2;

    }
}
