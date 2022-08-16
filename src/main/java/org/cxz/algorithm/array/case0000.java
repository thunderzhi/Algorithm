package org.cxz.algorithm.array;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/5 12:08
 */
public class case0000 {
    public static void main(String[] args) {
        
        int res = 0&(-0);
        System.out.println("res = " + res);
        int a = 1;
        while(a!=0){
            a &=(a-1);
            System.out.println("a = " + a);
        }
        a = 1&(-1);
        System.out.println("1 = " + Integer.toBinaryString(1));
        System.out.println("-1 = " + Integer.toBinaryString(-1));
        System.out.println("a = " + a);
//
//        int i = Integer.valueOf("999x");
//        System.out.println("i = " + i);
    }


}
