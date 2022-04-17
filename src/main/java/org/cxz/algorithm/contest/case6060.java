package org.cxz.algorithm.contest;

import sun.awt.image.PNGImageDecoder;

import java.util.PrimitiveIterator;
import java.util.PriorityQueue;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/16 22:32
 */
public class case6060 {
    public static void main(String[] args) {
        int[] a = new int[]{61488,18221,-1321,90249,-62158,55128,-93476,53905,57644,24630,89599,-95795,-14891,-60298,17690,99022,-24006,-89156,80135,-46303,18812,59924,32024,82924,-47519,-77086,1763,68618,53629,-56957,95485,99630,-7977,31164,94481,-80239,-57749,-3319,-58231,-94841,-19292,33200,-31446,-3528,2229,74241,-19992,-91852,-28073,31453,-74484,35491,38870,-9499,39838,87369,21123,-38616,-89277,-14541,-81586,-18569,-58242,-71216,10816,15086,-10519,51080,53257,-4912,-37142,-16723,-69795,54937,-24920,68970,-10010,-81717,36203,-67939,73877,-58258,-57183,36637,91518,-8492,-57476,50523,62462,73152,-9511,-66761,28333,-87163,5187};
        int closestNumber = new case6060().findClosestNumber(a);
        System.out.println("closestNumber = " + closestNumber);
    }
    //  pass
    public int findClosestNumber(int[] nums) {
        PriorityQueue<Integer> pqneg = new PriorityQueue<Integer>((o1,o2)->{
            return o2-o1;
        });
        PriorityQueue<Integer> pqpost = new PriorityQueue<>();
        boolean zero = false;
        for(int i :nums){
            if(i==0){
                zero = true;
            }
            else if(i>0){
                pqpost.offer(i);
                System.out.println("addtopost = " + i);
            }
            else {
                pqneg.offer(i);
                System.out.println("addtoNEG = " + i);
            }
        }
        if(zero) return 0;
        if(!pqpost.isEmpty()&&!pqneg.isEmpty()){
            int a = pqpost.peek();
            int b = pqneg.peek();
            b = -b;
            return a==b?a:(a<b?a:-b);
        }
        return pqpost.isEmpty()?pqneg.peek():pqpost.peek();
    }
}
