package org.cxz.algorithm.recurrence;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/10/25 10:19
 */
public class case2698 {

    // ver 1  math
    public int punishmentNumber(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (check(i * i, i)) ans += i * i;
        }
        return ans;
    }
    boolean check(int t, int x) {
        if (t == x) return true;
        int d = 10;
        while (t >= d && t % d <= x) {
            if (check(t / d, x - (t % d))) return true;
            d *= 10;
        }
        return false;
    }

    //ver 2 dfs
    public int punishmentNumber2(int n) {
        int ans = 0;
        for(int i = 1;i<=n;i++){
            int x = i*i;
            if(dfs(i, String.valueOf(x))){
//System.out.println(" x "+ x +" i "+i);
                ans += x;
            }
        }
        return ans;
    }

    public boolean dfs(int s ,String str){
        if("".equals(str)) return s==0;
        // if(s==0) return "".equals(str)||"0".equals(str);
        // if(s<0) return false;
        //s>0
        // if("".equals(str)) return false;
        if(s == Integer.parseInt(str)) return true;
        //s>0 && str.length>0
        boolean res = false;
        int n = str.length();
        for(int i =1;i<n;i++){
            int v = Integer.parseInt(str.substring(0,i));
            //if(v>s) break;
            res |= dfs(s-v,str.substring(i,n));
            if(res) break;
        }
        return res;
    }



}
