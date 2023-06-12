package org.cxz.contest.test2023343week;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/4/30 1:12
 */
public class test0430a {
    public int getscore(int[] arr){
        int n = arr.length,pre =-1,sum=0;
        for (int i = 0; i < n; i++) {
            int cur = arr[i];
            if(pre!=-1&&i-pre<3){
                cur *=2;
            }
            sum+=cur;
            if(arr[i]==10) pre = i;
        }
        return sum;
    }

    public int isWinner(int[] player1, int[] player2) {
        int s1 = getscore(player1);
        int s2 = getscore(player2);
        if(s1==s2) return 0;
        return s1>s2?1:2;
    }
}
