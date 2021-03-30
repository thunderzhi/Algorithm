package org.cxz.algorithm.queue;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/3/15 20:21
 */
public class case1709knumber {

    public static void main(String[] args) {
        int kthMagicNumber = new case1709knumber().getKthMagicNumber(1);
        System.out.println(kthMagicNumber);

        String arr = "az";
        char[] chars = arr.toCharArray();

        for (int i = 0; chars[i] >0 ; i++) {
            System.out.println(chars[i]);
        }
    }

    public  int getKthMagicNumber(int k) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);

        int p3 = 0;
        int p5 = 0;
        int p7 = 0;
        while (arr.size() < k){
            int ans = 3* arr.get(p3);
            ans = Math.min(ans,5*arr.get(p5));
            ans = Math.min(ans,7*arr.get(p7));

            if (3* arr.get(p3)==ans){
                p3++;
            }
            if (5* arr.get(p5)==ans){
                p5++;
            }
            if (7* arr.get(p7)==ans){
                p7++;
            }
            arr.add(ans);
        }
        return arr.get(k-1);
    }
}
