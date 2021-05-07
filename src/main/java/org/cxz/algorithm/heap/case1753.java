package org.cxz.algorithm.heap;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/4/15 19:29
 */
public class case1753 {

    public void swap(int x,int y){

    }

    public int maximumScore(int a, int b, int c) {
        if(a>c){
            int t = a;
            a = c;
            c = t;
        }
        if(a>b){
            int t = a;
            a = b;
            b = t;
        }
        if(b>c){
            int t = b;
            b = c;
            c = t;
        }
        // a min  c max;
        int ans =0;
        //step1
        int cnt = Math.min(c-b,a);
        a -=cnt;
        c -=cnt;
        ans +=cnt;
        //step 2
        if(a!=0){
            //a 有剩， 此时b==c
            if(a%2==1){a-=1;}
            b-=a/2;
            c-=a/2;
            ans +=a;
        }
        //step 3
        ans +=b;
        return ans;



    }
}
