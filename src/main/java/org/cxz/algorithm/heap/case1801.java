package org.cxz.algorithm.heap;

import java.util.PriorityQueue;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/4/15 17:53
 */
public class case1801{
    public static void main(String[] args) {
        int[][] arr = new int[][]{{10,5,0},{15,2,1},{25,1,1},{30,4,0}};
        int numberOfBacklogOrders = new case1801().getNumberOfBacklogOrders(arr);

    }


    public int getNumberOfBacklogOrders(int[][] orders) {
        //小顶
        PriorityQueue<int[]>  sell = new PriorityQueue<>((o1,o2)->o1[0]-o2[0]);
        //大顶
        PriorityQueue<int[]> buy = new PriorityQueue<>((o1,o2)->o2[0]-o1[0]);

        for (int[] order : orders) {
            int price = order[0],amount = order[1];
            if (order[2]==0){
                while(amount>0 && !sell.isEmpty()&&price>= sell.peek()[0] ){
                    int cnt = Math.min(amount,sell.peek()[1]);
                    amount -= cnt;
                    sell.peek()[1] -= cnt;
                    if(sell.peek()[1]==0){
                        sell.poll();
                    }

                }
                if(amount>0){
                    order[1] =amount;
                    buy.offer(order);
                }
            }
            else {
                while (amount>0&& !buy.isEmpty()&&price<= buy.peek()[0]){
                    int cnt = Math.min(amount,buy.peek()[1]);
                    amount -=cnt;
                    buy.peek()[1] -= cnt;
                    if (buy.peek()[1]==0){
                        buy.poll();
                    }
                }
                if (amount>0){
                    order[1] =amount;
                    sell.offer(order);
                }
            }
        }

        int result = 0;
        int c = 1000000007;
        while(!buy.isEmpty()){
            result = (result + buy.poll()[1])%c;
        }
        while(!sell.isEmpty()){
            result = (result + sell.poll()[1])%c;
        }

        return result;
    }
}
