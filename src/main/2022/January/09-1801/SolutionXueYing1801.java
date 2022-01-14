import java.util.*;

public class SolutionXueYing1801 {
    class Solution {
        class Order {
            int price;
            int num;
            public Order(int price, int num) {
                this.price = price;
                this.num = num;
            }
        }
        public int getNumberOfBacklogOrders(int[][] orders) {
            PriorityQueue<Order> sell = new PriorityQueue<>(new Comparator<Order>(){
                @Override
                public int compare(Order o1, Order o2) {
                    return o1.price - o2.price;
                }
            });
            PriorityQueue<Order> buy = new PriorityQueue<>(new Comparator<Order>(){
                @Override
                public int compare(Order o1, Order o2) {
                    return o2.price - o1.price;
                }
            });
            for (int i = 0; i < orders.length; i++) {
                if (orders[i][2] == 0) {
                    Order sellCur;
                    int buyNum = orders[i][1];
                    int buyPrice = orders[i][0];
                    // System.out.println("order:" + buyPrice);
                    // System.out.println("sell:" + sell.size());
                    if (sell.size() > 0) {
                        sellCur = sell.poll();
                        while (sellCur != null && sellCur.price <= buyPrice && buyNum > 0) {
                            // System.out.println("sellnum:" + sellCur.num);
                            // System.out.println("sellp:" + sellCur.price);
                            if (sellCur.num > buyNum) {
                                sell.offer(new Order(sellCur.price, sellCur.num - buyNum));
                                sellCur = sell.poll();
                                buyNum = 0;
                            } else if (sellCur.num < buyNum){
                                buyNum -= sellCur.num;
                                sellCur = sell.poll();
                            } else {
                                buyNum = 0;
                                sellCur = null;
                                break;
                            }
                        }
                        if (sellCur != null) {
                            sell.offer(sellCur);
                        }
                        // System.out.println("buyNum:" + buyNum);
                        // System.out.println("buyPrice:" + buyPrice);
                        if (buyNum > 0) {
                            buy.offer(new Order(buyPrice, buyNum));
                        }
                    } else {
                        // System.out.println("buyNum:" + buyNum);
                        // System.out.println("buyPrice:" + buyPrice);
                        buy.offer(new Order(buyPrice, buyNum));
                        continue;
                    }
                } else if (orders[i][2] == 1) {
                    int sellPrice = orders[i][0];
                    int sellNum = orders[i][1];
                    // System.out.println("order:" + sellPrice);
                    if (buy.size() > 0) {
                        Order buyOrder = buy.poll();
                        while (buyOrder != null && buyOrder.price >= sellPrice && sellNum > 0) {
                            // System.out.println("buyP:" + buyOrder.price);
                            if (buyOrder.num > sellNum) {
                                buy.offer(new Order(buyOrder.price, buyOrder.num - sellNum));
                                buyOrder = buy.poll();
                                sellNum = 0;
                            } else if (buyOrder.num < sellNum) {
                                sellNum -= buyOrder.num;
                                buyOrder = buy.poll();
                            } else {
                                sellNum = 0;
                                buyOrder = null;
                                break;
                            }
                        }
                        if (buyOrder != null) {
                            buy.offer(buyOrder);
                        }
                        // System.out.println("sellNum:" + sellNum);
                        if (sellNum > 0) {
                            sell.offer(new Order(sellPrice, sellNum));
                        }
                    } else {
                        // System.out.println("sellNum:" + sellNum);
                        sell.offer(new Order(sellPrice, sellNum));
                    }
                }
            }
            long orderSum = 0;
            int n1 = buy.size();
            for (int i = 0; i < n1; i++) {
                Order o = buy.poll();
                // System.out.println("buy:" + o.price);
                // System.out.println("buy:" + o.num);
                orderSum += o.num;
            }
            int n2 = sell.size();
            for (int i = 0; i < n2; i++) {
                Order o = sell.poll();
                // System.out.println("sell:" + o.price);
                // System.out.println("sell:" + o.num);
                orderSum += o.num;
            }
            return (int) (orderSum % 1000000007);
        }
    }
}
