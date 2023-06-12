package org.cxz.contest.test2023345week;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/5/14 10:28
 */
public class test0514c {

    public boolean doesValidArrayExist(int[] derived) {
        //orig 0 1  2  3   4 ..    n-1
        //der  0 1  2  3   4 ..    n-1
        //  der i == 1      o[i] o[i+1] 0 1 or 1 0
        //  der i == 0      o[i] o[i+1] 0 0 or 1 1
        //  1  01
        //  1  10
        int n = derived.length;
        if(n==1){
            return derived[0]==0;
        }

        int[] org1= new int[n];
        int[] org2= new int[n];
        //mark 0 as not visit ,-1 represent zero
        if(derived[0]==1){
            org1[0] = 0;org1[1]= 1;
            org2[0] = 1;org2[1]= 0;
        }
        else {//derived[0]==0
            org1[0] = 0;org1[1]= 0;
            org2[0] = 1;org2[1]= 1;
        }
        boolean res = false;
        for (int i = 1; i < n; i++) {
            int j = (i+1)%n;
            int nx1 = derived[i]^org1[i];
            if(j==0&&org1[0]==nx1) return true;
            org1[j] = nx1;
            nx1 = derived[i]^org2[i];
            if(j==0&&org2[0]==nx1) return true;
            org2[j] = nx1;
        }
        return res;
    }
}
