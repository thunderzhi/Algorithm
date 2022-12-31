package org.cxz.contest.test94dweek;

import java.util.*;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/12/24 22:30
 */
public class test1224a {
    public static void main(String[] args) {
        int[] test = new int[]{0,0,1,-1};
        int res = new test1224a().captureForts(test);
        System.out.println("res = " + res);
    }
    public int captureForts(int[] forts) {
        int pre = -1,n = forts.length;
        int max =0;
        List<Integer> one = new ArrayList<>();
        TreeSet<Integer> ts = new TreeSet<>();
        for (int i = 0; i < forts.length; i++) {
            if(forts[i]==1){
                one.add(i);
            }
            else if(forts[i]==-1){
                ts.add(i);
            }
        }
        for (int i = 0; i < one.size(); i++) {
            int curind = one.get(i);
            System.out.println("curind = " + curind);
            Integer left = ts.floor(curind);
            if(left!=null&&(pre==-1||(pre<left&&pre!=-1))){
                max = Math.max(max,curind-left-1);

            }


            Integer right = ts.ceiling(curind);
            System.out.println("curind = " + curind+" left "+left+" right "+right);
            if(right!=null&&(i==one.size()-1||(i+1<one.size()&&one.get(i+1)>right))){
                max = Math.max(max,right-curind-1);
            }
            pre = curind;
        }
        return max;
    }
}
