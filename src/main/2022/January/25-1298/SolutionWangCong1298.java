/**
 * @author wangcong03 <wangcong03@kuaishou.com>
 * Created on 2022-01-25
 */
public class SolutionWangCong1298 {

    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes){
        ownKeys = new boolean[status.length];
        ownBoxes = new boolean[status.length];
        openedBox = new boolean[status.length];
        for (int box : initialBoxes) {
            ownBoxes[box] = true;
            if(status[box] == 1|| ownKeys[box]) {
                find(status, candies, keys, containedBoxes, box);
            }
        }
        return current;
    }

    private int current;
    private boolean[] ownKeys;
    private boolean[] ownBoxes;
    private boolean[] openedBox; //当前糖果盒里面钥匙是否已经拿走

    public void find(int[] status, int[] candies, int[][] keys, int[][] containedBoxes,
                     int currentBox) {
        if (!ownBoxes[currentBox] || openedBox[currentBox]) {
            return;
        }
        int currentBoxCandy = candies[currentBox];
        //如果拿走当前box的糖果
        current += currentBoxCandy;
        // System.out.println("currentBox="+currentBox+",currentBoxCandy="+currentBoxCandy);

        openedBox[currentBox] = true;
        int[] newBoxes = containedBoxes[currentBox];
        int[] newKeys = keys[currentBox];
        for (int key : newKeys) {
            ownKeys[key] = true;
            if (ownBoxes[key]) {
                find(status, candies, keys, containedBoxes, key);
            }

        }
        for (int box : newBoxes) {
            ownBoxes[box] = true;
            if (status[box] == 1 || ownKeys[box]) {
                find(status, candies, keys, containedBoxes, box);
            }
        }
    }
}
