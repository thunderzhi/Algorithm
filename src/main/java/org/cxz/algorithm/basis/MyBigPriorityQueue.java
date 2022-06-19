package org.cxz.algorithm.basis;

import jdk.nashorn.internal.ir.ReturnNode;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/6/19 15:11
 */
public class MyBigPriorityQueue {
    public int cnt;
    public int _size;
    public int[] arr;
    //public int head, tail;
    public MyBigPriorityQueue(){
        _size = 1024;
        arr = new int[_size];
    }
    public MyBigPriorityQueue(int size){
        _size= size;
        arr = new int[_size];
    }
    public boolean isEmpty(){
        return cnt==0;
    }
    public int size(){
        return cnt;
    }

    public void offer(int val){
        arr[cnt++] = val;
        shiftup(cnt-1);
        return;
    }
    public Integer peek(){
        if(isEmpty()) return null;
        return arr[0];
    }
    public void swap(int a,int b){
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
        return;
    }

    public Integer pop(){
        if(isEmpty()) return null;
        swap(0,cnt-1);
        cnt--;
        sink(0);
        return arr[cnt];
    }

    public void shiftup(int ind){
        while(ind>0&&arr[ind]>arr[(ind-1)/2]){
            swap(ind,(ind-1)/2);
            ind = (ind-1)/2;
        }
        return;
    }

    public void sink(int ind){
        int end = cnt-1;
        while(ind*2+1<=end){
            int tmp=ind;
            if(arr[tmp]<arr[ind*2+1]) tmp = ind*2+1;
            if(ind*2+2<=end&&arr[tmp]<arr[ind*2+2]) tmp=ind*2+2;
            if(tmp == ind) break;
            swap(ind,tmp);
            ind = tmp;
        }
        return;
    }

}
