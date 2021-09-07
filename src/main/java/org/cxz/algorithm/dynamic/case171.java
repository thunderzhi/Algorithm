package org.cxz.algorithm.dynamic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/9/6 22:19
 */
public class case171 {
    public static void main(String[] args) {

        Integer a = Integer.valueOf('A');
        System.out.println("a = " + a);
    }


    public int titleToNumber(String columnTitle) {
        int ans = 0;

        for(int i = 0;i<columnTitle.length();i++) {
            int num = columnTitle.charAt(i) - 'A' + 1;
            ans = ans * 26 + num;
        }
        return ans;

    }
}
