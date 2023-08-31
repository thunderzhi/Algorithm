package org.cxz.algorithm.array;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/8/26 16:06
 */
public class case649 {

    public String predictPartyVictory(String senate) {
        int n = senate.length();
        int cntr =0,cntd=0;
        int leftd = 0,leftr = 0;
        Deque<Integer> queue = new ArrayDeque();
        // R==0 ,D==1;
        for(int i =0;i<n;i++){
            int cur = senate.charAt(i)=='R'?0:1;
            if(cur==0){
                if(queue.isEmpty()||cntd==0){
                    queue.offerLast(cur);
                    leftr++;
                    cntr++;
                }
                else if(cntd>0){
                    cntd--;
                }
            }
            else{
                if(queue.isEmpty()||cntr==0){
                    queue.offerLast(cur);
                    cntd++;
                    leftd++;
                }
                else if(cntr>0){
                    cntr--;
                }
            }
        }

        while(!queue.isEmpty()){
            if(leftd==0||leftr==0){
                return leftd==0?"Radiant":"Dire";
            }
            int cur = queue.pollFirst();
            if(cur==0){
                leftr--;
                // R
                if(cntd==0){
                    queue.offerLast(cur);
                    cntr++;
                    leftr++;
                }
                else{
                    cntd--;
                }
            }
            else{
                leftd--;
                //D
                if(cntr==0){
                    queue.offerLast(cur);
                    cntd++;
                    leftd++;
                }
                else{
                    cntr--;
                }
            }
        }
        return "";
    }
/* 如果是R，
 queue 为空，or cntD==0 -> R可以入队，&&cntR+1
 否则cntD>0,此刻R会被forbid，无法入队，&&cntD-1
如果是D，
queue 为空，or cntR==0 -> D可以入队，&&cntD+1
否则cntR>0,此刻D会被forbid，无法入队，&&cntR-1
第一轮结束，此刻在队列中的，还有权利，再次模拟，直到，整个队列中只有一个阵营。* /

}
