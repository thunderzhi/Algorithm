package org.cxz.algorithm.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/6/10 1:06
 */
public class case315 {
    public class Data{
        public int ind;//orign array index
        public int cnt;//the number
        public int val;//array value

        public Data(int ind,int cnt,int val){
            this.ind = ind;
            this.cnt = cnt;
            this.val = val;
        }

    }
    private List<Data> temp;
    public static void main(String[] args) {
        int[] a = new int[]{5,2,6,1};

        new case315().countSmaller(a);

    }

    public List<Integer> countSmaller(int[] nums) {
        List<Data> data = new ArrayList<>();
        temp = new ArrayList<>();
        while(temp.size()<nums.length){
            temp.add(new Data(0,0,0));
        }


        System.out.println("temp = " + temp);
        merge(nums,0,nums.length-1);


        return new ArrayList<>();
    }

    public void merge(int[] nums,int l ,int r){
        if(l>=r){
            return;
        }
        


    }
}
