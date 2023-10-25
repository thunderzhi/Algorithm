package org.cxz.contest.test20230521346week;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/5/21 10:17
 */
public class test0521c {
    // wait
    public boolean dfs(String s ,int tar){
        if(s.length()==0){
            return tar==0;
        }
        if(s.length()==1){
            return s.equals(String.valueOf(tar));
        }

        int len = s.length();
        for (int i = 1; i <len ; i++) {
            String s1 = s.substring(0,i);
            System.out.println("s1 = " + s1);
            String s2 = s.substring(i);
            int v = Integer.parseInt(s1);
            if(dfs(s2,tar-v)) return true;
        }
        return false;
    }
    public int punishmentNumber(int n) {
        // 1~n    i
        //i^2+i1^2
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int t = i*i;
            if(dfs(String.valueOf(t),i)){
                sum +=t;
            }
        }
        return sum;
    }
}
