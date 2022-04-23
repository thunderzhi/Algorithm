package org.cxz.algorithm.contest;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/16 15:26
 */
public class casetest2 {
    public static void main(String[] args) {

    }

    public boolean canmake(int[] mat,int[] cook){
        for (int i = 0; i < cook.length; i++) {
            if(mat[i]<cook[i]) return false;
        }
        return true;
    }
    public void refresh(int[] mat,int[] cook){
        for (int i = 0; i < cook.length; i++) {
            mat[i] -= cook[i];
        }
        return;
    }

//    public int perfectMenu(int[] materials,
//                           int[][] cookbooks,
//                           int[][] attribute, int limit) {
//        int n = cookbooks.length;
//        int[][] dp = new int[n+1][(1<<n)+1] ;//count, status
//        for (int i = 1; i <=n ; i++) {
//            int ind = i,num =i;
//            int next =0;
//            while(num>0){
//                num>>=1;
//                next++;
//            }
//            for (int j = 0; j < dp[i].length; j++) {
//
//            }
//            for (int j = next; j <=(1<<n) ; j++) {
//                int tmpind = ind|(1<<j);
//                dp[i][tmpind] = dp[i][ind]
//
//
//            }
//        }
//        for(int i =1,I=(1<<n);i<I;i++){
//
//        }
//    }
}
