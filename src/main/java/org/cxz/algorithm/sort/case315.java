package org.cxz.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
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

        List<Integer> res = new case315().countSmaller(a);

        System.out.println("res = " + Arrays.asList(res));

    }

    public List<Integer> countSmaller(int[] nums) {
        List<Data> arr = new ArrayList<>();
        temp = new ArrayList<>();
        for (int i = 0; i <nums.length; i++) {
            arr.add(new Data(i,0,nums[i]));
            temp.add(new Data(0,0,0));
        }



        System.out.println("temp = " + temp);
        merge(arr,0,nums.length-1);
        int[] res = new int[nums.length];
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            res[arr.get(i).ind] = arr.get(i).cnt;
        }
        for (int i = 0; i < res.length; i++) {
            ret.add(res[i]);
        }

        return ret;
    }

    public void merge(List<Data> arr,int l ,int r){
        if(l>=r){
            return;
        }
        int mid =(l+r)>>1;
        merge(arr,l,mid);
        merge(arr,mid+1,r);
        int k = l ,p1 = l, p2 = mid+1;
        while(p1<=mid||p2<=r){
            if((p2>r)||(p1<=mid&&arr.get(p1).val>arr.get(p2).val)){
                Data data = temp.get(p1);
                data.cnt += r-p2+1;
                data.val = arr.get(p1).val;
                k++;
                p1++;
            }
            else {
                Data data = temp.get(p2);
                data.val = arr.get(p2).val;
                k++;
                p2++;
            }
        }
        for (int i = l; i <=r ; i++) {
            Data a1 = arr.get(i);
            Data t1 = temp.get(i);
            a1.cnt = t1.cnt;
            a1.ind = t1.ind;
            a1.val = t1.val;

        }
        return ;
    }
}
