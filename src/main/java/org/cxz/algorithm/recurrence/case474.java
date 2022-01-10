package org.cxz.algorithm.recurrence;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/1/10 10:56
 */
public class case474 {
    public static void main(String[] args) {
        String[] arr = {"10", "0001", "111001", "1", "0"};
        int maxForm = new case474().findMaxForm(arr, 0, 0);
        System.out.println("maxForm = " + maxForm);
    }

    public class Node{
        public String value;
        public int countZero;
        public int countOne;
        public Node(String s){
            int n = s.length();
            for (int i = 0; i < n; i++) {
                if(s.charAt(i)=='0'){
                    countZero++;
                }
                if(s.charAt(i)=='1'){
                    countOne++;
                }
            }
        }
    }

    public int findMaxForm(String[] strs, int m, int n) {
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });
        Node[] list = new Node[strs.length];
        for (int i = 0; i < list.length; i++) {
            list[i] = new Node(strs[i]);
        }

        /*
        dp[i][j] = repesent contain i 0 and j 1 MAX set
        1  dp[i-1][j]
        2  dp[i][j-1]
        dp[i][j] =max(dp[i][j-1],dp[i-1][j])

        * */
        int[][] dp = new int[m][n];//
        dp[0][0]=0;
//        for (int i = 0; i < list; i++) {
//
//        }
        
        

        System.out.println("strs = " + Arrays.toString(strs));
        return 1;



    }
}
