package org.cxz.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
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

        @Override
        public String toString() {
            return "Data{" +
                    "ind=" + ind +
                    ", cnt=" + cnt +
                    ", val=" + val +
                    '}';
        }
    }
    private List<Data> temp;
    private int[][] data;//transform
    private int[][] tmp;//tmp
    public static void main(String[] args) {
        int[] a = new int[]{5,2,6,1};

        List<Integer> res = new case315().countSmaller2(a);

        System.out.println("res = " + Arrays.asList(res));

    }

    public List<Integer> countSmaller(int[] nums) {

        List<Data> arr = new ArrayList<>();
        temp = new ArrayList<>();
        for (int i = 0; i <nums.length; i++) {
            arr.add(new Data(i,0,nums[i]));
            temp.add(new Data(0,0,0));
        }
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
                Data data = temp.get(k);
                arr.get(p1).cnt += r-p2+1;
                data.val = arr.get(p1).val;
                data.ind = arr.get(p1).ind;
                data.cnt = arr.get(p1).cnt;
                k++;
                p1++;
            }
            else {
                Data data = temp.get(k);
                data.val = arr.get(p2).val;
                data.ind = arr.get(p2).ind;
                data.cnt = arr.get(p2).cnt;
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
    public void merge2(int[][] arr,int l ,int r){
        if(l>=r){
            return;
        }
        int mid =(l+r)>>1;
        merge2(arr,l,mid);
        merge2(arr,mid+1,r);
        int k = l ,p1 = l, p2 = mid+1;
        while(p1<=mid||p2<=r){
            if((p2>r)||(p1<=mid&&arr[p1][2]>arr[p2][2])){
                int[] _data = tmp[k];
                arr[p1][1] += r-p2+1;
                tmp[k++]= arr[p1++];
            }
            else {
                int[] _data = tmp[k];
                tmp[k++]= arr[p2++];
            }
        }
        for (int i = l; i <=r ; i++) {
            arr[i]=tmp[i];
        }
        return ;
    }


    public List<Integer> countSmaller2(int[] nums){
        data = new int[nums.length][3];//0 index, 1 count ,2 value;
        tmp = new int[nums.length][3];
        List<Integer> ans  =new ArrayList<>();
        for (int i = 0; i <nums.length; i++) {
            int[] t = new int[]{i,0,nums[i]};
            data[i]=t;
            tmp[i]=new int[]{0,0,0};
        }

        merge2(data,0,data.length-1);

//        Arrays.sort(data, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[0]-o2[0];
//            }
//        });
        int[] res = new int[nums.length];

        for (int i = 0; i < data.length; i++) {
            res[data[i][0]] = data[i][1];
        }
        for (int i = 0; i < res.length; i++) {
            ans.add(res[i]);
        }
        return ans;
    }


}
