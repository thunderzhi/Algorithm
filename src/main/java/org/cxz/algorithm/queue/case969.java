package org.cxz.algorithm.queue;

import javax.lang.model.element.VariableElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/3/16 0:15
 */
public class case969 {
    public static void main(String[] args) {
         int[] ints = {3, 2, 4, 1};

        List<Integer> res = new case969().pancakeSort(ints);
        System.out.println(res.toString());
    }
    public void reverse(int[] arr ,int n ,int[] ind){
        for (int i = 0,j=n-1; i <j ; i++,j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            ind[arr[i]]=i;
            ind[arr[j]]=j;
        }
        return;
    }
    public List<Integer> pancakeSort(int[] arr) {

        //List<Integer> collect = Arrays.stream(arr).boxed().collect(Collectors.toList());
        int[] ind = new int[arr.length+1];// ArrayList<>(arr.length + 1);
         
        ArrayList<Integer> ret=new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            //ind.set(arr[i],i);
            ind[arr[i]]=i;
        }
        for (int i = arr.length; i >=1; i--) {
            if(ind[i] ==i-1){
                continue;
            }
            if (ind[i]+1!=1){
                ret.add(ind[i]+1);
                reverse(arr,ind[i]+1,ind);
            }
            if(i!=1){
                ret.add(i);
                reverse(arr,i,ind);
            }
        }
        return ret;

    }

}
