package org.cxz.algorithm.off.I;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/11 18:09
 */
public class caseOff044 {
    public static void main(String[] args) {
        int n = 99;
        int nthDigit = new caseOff044().findNthDigit(n);
        System.out.println("nthDigit = " + nthDigit);
        int nthDigit2 = new caseOff044().findNthDigit2(n);
        System.out.println("nthDigit2 = " + nthDigit2);
        System.out.println("Integer.MAX_VALUE = " + Integer.MAX_VALUE);
    }

    public int findNthDigit(int n) {
        if(n<=9) return n;
        long digit = 1;
        // Math.pow(10,digit) - Math.pow(10,digit-1)
        long cnt =0;
        long n1 = (long)n;
        while(n1 >cnt){
            cnt = (long)(Math.pow(10L,digit) - Math.pow(10L,digit-1L))*digit ;
            if(n1<=cnt) break;
            n1-=cnt;
            digit++;
        }
        System.out.println("n1 = " + n1);
        System.out.println("digit = " + digit);
        long left = (long)Math.pow(10L,digit-1L);
        System.out.println("left = " + left);
        int m = (int)((n1-1)%digit);
        System.out.println("m = " + m);
        long num = left +(n1-1)/digit;//(Math.pow(10,digit-1))+n/digit;
        System.out.println("num = " + num);

        String s = String.valueOf(num);
        return s.charAt(m)-'0';
    }

    public int findNthDigit2(int n) {
        int len = 1;
        while (len * 9 * Math.pow(10, len - 1) < n) {
            n -= len * 9 * Math.pow(10, len - 1);
            len++;
        }
        System.out.println("n = " + n);
        System.out.println("len = " + len);
        long s = (long) Math.pow(10, len - 1);
        System.out.println("s = " + s);
        long x = n / len - 1 + s;
        System.out.println("x = " + x);
        n -= (x - s + 1) * len;
        return n == 0 ? (int) (x % 10) : (int) ((x + 1) / Math.pow(10, len - n) % 10);
    }
}
