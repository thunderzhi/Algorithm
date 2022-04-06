package org.cxz.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description: 建立索引数组，并且将索引数组的索引，按照原始数组的大小排序
 * @date 2021/10/12 11:41
 */
public class sth {
    public static void main(String[] args) {
        int[] nums = {7,2,15,11,1};
        List<List<Integer>> arr = new ArrayList();
        int[][] ans = new int[arr.size()][];
        for(int i = 0;i<arr.size();i++){
            ans[i] = arr.get(i).stream().mapToInt(Integer::intValue).toArray();
        }
        Integer[] ind = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ind[i] = i;
        }

        Arrays.sort(ind, 0, ind.length ,(i,j)->{return nums[i]-nums[j];});

        System.out.println("Arrays.toString(ind) = " + Arrays.toString(ind));
    }



}
