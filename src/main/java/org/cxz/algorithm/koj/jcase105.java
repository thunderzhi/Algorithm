package org.cxz.algorithm.koj;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/11/1 18:08
 */
public class jcase106 {
    public static void main(String[] args) {
        long res = new jcase106().getNfb(35);


        System.out.println("res = " + res);
        System.out.println("Integer.MAX_VALUE = " + Integer.MAX_VALUE);
    }

    public long getNfb(long N){
        long prev = 1;//f0
        long cur = 1;// f1
        int cnt = 0;
        long res = 0;
        while(cnt <N){
            long sum = prev + cur;
            prev = cur;
            cur = sum;
            if(!judge(sum)){
                cnt+=1;
                res = sum;
            }
        }
        return res;
    }



    public boolean judge(long n){

        for (long i = 2; i <= Math.sqrt(n) ; i++) {
            if(n%i==0){
                return false;
            }
        }
        return true;
    }


}
