package org.cxz.algorithm.tire;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/12/17 17:23
 */
public class case440 {

    public static void main(String[] args) {
        int n =300;//1000000000
        //int n =1000000000;
        //66666666
        int k = 297;//96  //159999997

        int kthNumber = new case440().findKthNumber(n, k);
        System.out.println("kthNumber = " + kthNumber);
    }
    public int findKthNumber(int n, int k) {
        int cur = 1;
        while (k>1){
            int cnt = getcount(n,cur);
            System.out.println("cur = " + cur+" cnt = "+cnt+" k = "+k);

            if(cnt<k){
                cur++;
                k-=cnt;
                System.out.println(" cur++ = " + cur+" k-cnt = "+k);
            }
            else {
                cur *=10;
                k-=1;
                System.out.println(" cnt*10 = " + cnt+" k-1 = "+k);
            }

            System.out.println("---------------------------- = " );
        }
        return cur;
    }

    private int getcount(int n, int cur) {
        int next = cur+1,cnt =0;
        while (cur<=n){
            cnt += Math.min(next-cur,n-cur+1);
            cur*=10;
            next*=10;

        }
        return cnt;
    }

}
