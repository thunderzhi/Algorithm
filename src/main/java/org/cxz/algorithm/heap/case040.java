package org.cxz.algorithm.heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/4/13 17:43
 */
public class case040 {
    public static void main(String[] args) {

        int[] a = new int[]{3,2,1};
        int k = 2;
        int[] leastNumbers = new case040().getLeastNumbers(a, k);
        System.out.println(Arrays.toString(leastNumbers));
        //System.out.println(leastNumbers);
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        int[] ans = new int[k];
        if(k==0){
            return new int[]{};
        }
        if(arr.length<=0){
            return new int[]{};
        }
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((o1, o2)->o2-o1);
        for (int i = 0; i < arr.length; i++) {
            if (pq.size()<k){
                pq.offer(arr[i]);
                continue;
            }
            if (arr[i]< pq.peek()) {
                pq.poll();
                pq.offer(arr[i]);
            }
        }
        for (int i = 0; i < ans.length; i++) {
            ans[i]=pq.poll();
        }
        return ans;
    }

    //ver 2 recommend On
    public Random random;
    public int[] getLeastNumbers2(int[] arr, int k) {
        random = new Random();
        qs(arr,0,arr.length-1,k);
        int[] list = new int[k];
        for(int i=0;i<k;i++) list[i] = arr[i];
        return list;
    }

    public void qs(int[] arr ,int l,int r,int k){
        if(l>=r) return;
        int x = l ,y = r;
        int i = random.nextInt(y-x+1)+x;
        if(i!=l){
            swap(arr,i,l);
        }
        int base = arr[l];
        while(x<y){
            while(x<y&&arr[y]>= base) y--;
            if(x<y){
                arr[x++] = arr[y];
            }
            while(x<y&&arr[x]<= base) x++;
            if(x<y){
                arr[y--] = arr[x];
            }
        }
        arr[x] = base;
        int num = x-l+1;
        if(num == k) return;
        if(num>k){
            qs(arr,l,x-1,k);
        }
        else{
            qs(arr,x+1,r,k-num);
        }
        return;
    }

    public void swap(int[] num,int i,int j){
        int t = num[i];
        num[i] = num[j];
        num[j] = t;
        return;
    }
}
