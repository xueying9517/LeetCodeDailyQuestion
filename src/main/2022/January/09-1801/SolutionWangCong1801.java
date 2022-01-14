import java.util.*;

public class SolutionWangCong1801 {
    class Solution {
        public int getNumberOfBacklogOrders(int[][] orders) {
//最大堆
            PriorityQueue<AbstractMap.SimpleEntry<Integer, Integer>> buyQueue =
                    new PriorityQueue<>((o1, o2) -> o2.getKey() - o1.getKey());
            //最小堆
            PriorityQueue<AbstractMap.SimpleEntry<Integer, Integer>> sellQueue =
                    new PriorityQueue<>((o1, o2) -> o1.getKey() - o2.getKey());

            for (int[] line : orders) {
                //0表示buy, 1表示sell
                if (line[2] == 0) {
                    AbstractMap.SimpleEntry<Integer, Integer> lowest = sellQueue.peek();
                    int leftBuyAmount = line[1];
                    while (lowest != null && lowest.getKey() <= line[0] && leftBuyAmount > 0) {
                        if (lowest.getValue() > leftBuyAmount) {
                            lowest.setValue(lowest.getValue() - leftBuyAmount);
                            leftBuyAmount = 0;
                        } else {
                            sellQueue.poll();
                            leftBuyAmount = leftBuyAmount - lowest.getValue();
                            lowest = sellQueue.peek();
                        }
                    }
                    if (leftBuyAmount > 0) {
                        // System.out.println("buy_add, "+line[0]+ "," + leftBuyAmount);
                        buyQueue.add(new AbstractMap.SimpleEntry(line[0], leftBuyAmount));
                    }
                } else {
                    AbstractMap.SimpleEntry<Integer, Integer> highest = buyQueue.peek();
                    int leftSellAmount = line[1];
                    while (highest != null && highest.getKey() >= line[0] && leftSellAmount > 0) {
                        if (highest.getValue() > leftSellAmount) {
                            highest.setValue(highest.getValue() - leftSellAmount);
                            leftSellAmount = 0;
                        } else {
                            buyQueue.poll();
                            leftSellAmount = leftSellAmount - highest.getValue();
                            highest = buyQueue.peek();
                        }
                    }
                    if (leftSellAmount > 0) {
                        // System.out.println("sell_add, "+line[0]+ "," + leftSellAmount);
                        sellQueue.add(new AbstractMap.SimpleEntry(line[0], leftSellAmount));
                    }
                }
            }

            long buyOrderNum = buyQueue.stream().map(entry -> entry.getValue().longValue())
                    .reduce(Long::sum).orElse(0L);
            long sellOrderNum = sellQueue.stream().map(entry -> entry.getValue().longValue())
                    .reduce(Long::sum).orElse(0L);
            // System.out.println("buyOrderNum="+buyOrderNum +",sellOrderNum="+sellOrderNum);

            return (int) ((buyOrderNum + sellOrderNum) % (1000_000_000 + 7));
        }
    }

}
