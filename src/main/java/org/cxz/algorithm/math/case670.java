package org.cxz.algorithm.math;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/3 23:57
 */
public class case670 {

    public int maximumSwap(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        int[] lastpos = new int[10];
        for(int i= 0;i<arr.length;i++){
            lastpos[ arr[i]-'0']=i;
        }

        for(int i= 0;i<arr.length;i++){
            for(int j= 9;j>(arr[i]-'0');j--){
                if(lastpos[j]>i){
                    swap(arr,lastpos[j],i);
                    return  Integer.parseInt(new String(arr));
                }

            }
        }
        return num;
    }

    public void swap(char[] arr,int i,int j){
        char t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
