import java.util.*;

public class SolutionXiaoWei1801 {
    class Solution {
        public int getNumberOfBacklogOrders(int[][] orders) {
            PriorityQueue<int[]> buyBackLog = new PriorityQueue<>(new Comparator<int[]>() {
                public int compare(int[] o1, int[] o2) {
                    return o2[0] - o1[0];
                }
            });

            PriorityQueue<int[]> sellBackLog = new PriorityQueue<>(new Comparator<int[]>(){
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });

            for(int[] order : orders) {
                if(order[2] == 0) {
                    //buy
                    int amount = order[1];
                    int price = order[0];
                    while(amount > 0 && sellBackLog.size() > 0) {
                        int[] blsell = sellBackLog.poll();
                        int sellPrice = blsell[0];
                        int sellAmount = blsell[1];
                        if(sellPrice > price) {
                            sellBackLog.add(blsell);
                            break;
                        } else {
                            if(sellAmount > amount) {
                                blsell[1] -= amount;
                                sellBackLog.add(blsell);
                                amount = 0;
                            } else if(sellAmount == amount) {
                                amount = 0;
                            } else {
                                amount -= sellAmount;
                            }
                        }
                    }
                    if(amount > 0) {
                        buyBackLog.add(new int[]{price, amount, order[2]});
                    }
                } else {
                    //sell
                    int amount = order[1];
                    int price = order[0];
                    while(amount > 0 && buyBackLog.size() > 0) {
                        int[] blbuy = buyBackLog.poll();
                        int buyPrice = blbuy[0];
                        int buyAmount = blbuy[1];
                        if(buyPrice < price) {
                            buyBackLog.add(blbuy);
                            break;
                        } else {
                            if(buyAmount > amount) {
                                blbuy[1] -= amount;
                                buyBackLog.add(blbuy);
                                amount = 0;
                            } else if(buyAmount == amount) {
                                amount = 0;
                            } else {
                                amount -= buyAmount;
                            }
                        }
                    }
                    if(amount > 0) {
                        sellBackLog.add(new int[]{price, amount, order[2]});
                    }
                }
            }
            long res = 0;
            while(buyBackLog.size() > 0) {
                res += buyBackLog.poll()[1];
                res %= 1000000007;
            }
            while(sellBackLog.size() > 0) {
                res += sellBackLog.poll()[1];
                res %= 1000000007;
            }
            return (int)res;
        }
    }
}
