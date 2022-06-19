package org.cxz.algorithm.array;

import java.util.*;

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
        //char c = '';
        String s ="";
        StringBuffer sb = new StringBuffer();
        sb.reverse();
        Arrays.sort(ind, 0, ind.length ,(i,j)->{return nums[i]-nums[j];});
        String[] arrstr = new String[]{ "52","3","v","71","J","A","0","v","51","E","k","H","96","21","W","59","I","V","s","59","w","X","33","29","H","32","51","f","i","58","56","66","90","F","10","93","53","85","28","78","d","67","81","T","K","S","l","L","Z","j","5","R","b","44","R","h","B","30","63","z","75","60","m","61","a","5"};
        System.out.println("arrstr = " + arrstr.length);
        sb.length();
        String[] split = s.split(",");
        Deque<Integer> st = new LinkedList<>();
        st.push(2);
        st.push(1);
        st.push(3);
        System.out.println("st = " + st);
        System.out.println("Arrays.toString(ind) = " + Arrays.toString(ind));
    }



}
