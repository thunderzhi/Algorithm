package org.cxz.algorithm.math;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/8/19 10:41
 */
public class case2355 {


    public int sum(int num1, int num2) {
        String s1 = Integer.toBinaryString(num1);
        String s2 = Integer.toBinaryString(num2);
        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);


        return num1+num2;
    }
}
