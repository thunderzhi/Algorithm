package org.cxz.algorithm.linkedlist;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/3/9 9:50
 */
public class case202 {
    public static void main(String[] args) {

    }
    public static boolean isHappy(int n) {
        int p  = n ;
        int q = n;
        do{
            p = getnext(p);
            q = getnext(getnext(q));
        }while(q!=p&&q!=1);
        return q ==1;

    }

    public static int getnext(int x){
        int z =0;
        while(x>0){
            z+=(x%10)*(x%10);
            x /=10;
        }
        return z;
    }
}
