package org.cxz.algorithm.math;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/2/7 12:43
 */
public class case779 {

    //my self
    public int kthGrammar1(int N, int K) {
        if(K==1){
            return 0;
        }
        // if(N==2&&K==2){
        //     return 1;
        // }
        int ans;
        int father = kthGrammar1(N-1,(K+1)/2);
        if(K%2==0){
            ans = father==0?1:0;
        }
        else{
            ans = father==0?0:1;
        }
        return ans;
    }

    public int kthGrammar2(int N, int K) {
        if (N == 1) {
            return 0;
        }
        return (~K & 1) ^ kthGrammar2(N-1, (K+1)/2);
    }

}
