package org.cxz.algorithm.heap;

import java.util.PriorityQueue;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/4/15 10:57
 */
public class case295 {

    public static void main(String[] args) {
        case295 case295 = new case295();
        case295.addNum(1);
        case295.addNum(2);
        double median = case295.findMedian();
        System.out.println(median);
        case295.addNum(3);
          median = case295.findMedian();
        System.out.println(median);
    }
    public PriorityQueue<Integer> ps;
    public PriorityQueue<Integer> pb;
    public case295(){
        ps = new PriorityQueue<>();//小顶
        pb = new PriorityQueue<>((o1, o2) -> o2-o1 );//大顶
    }

//    addNum(1)
//    addNum(2)
//    findMedian() -> 1.5
//    addNum(3)
//    findMedian() -> 2
    public void addNum(int num) {
        //设定 pb ---ps   调整 pb-ps=1;
        if(pb.isEmpty()||ps.isEmpty()){
            if(pb.isEmpty()&&ps.isEmpty()){
                pb.offer(num);
                return;
            }
            if (!ps.isEmpty()&&num<ps.peek()){
                pb.offer(num);
                return ;
            }
            if(!pb.isEmpty()&&num>pb.peek()){
                ps.offer(num);
                return;
            }
        }

        if((pb.size()-ps.size()) ==1){
//插入判断插入到pb,ps
            if (pb.peek()>num){
                ps.offer(pb.poll());
                pb.offer(num);
            }
            else{
                ps.offer(num);
            }
            return;
        }
        if(pb.size()==ps.size()){
            //插入判断插入到pb,ps
            if (pb.peek()>=num||ps.peek()>=num){
                pb.offer(num);
            }
            if(ps.peek()<num){

                pb.offer(ps.poll());
                ps.offer(num);
            }
            return;
        }
    }

    public double findMedian() {
        if((pb.size()-ps.size()) ==1){
            return pb.peek();
        }
        double a = (double)pb.peek();
        double b = (double)ps.peek();
        return (a+b)/2;
    }
}


