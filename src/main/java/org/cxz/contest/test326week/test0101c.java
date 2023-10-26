package org.cxz.contest.test326week;

import java.util.*;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/1/1 10:30
 */
public class test0101c {

    public static void main(String[] args) {
        test0101c test0101c = new test0101c();
        String s = "165462";
        int k = 60;
        int i = test0101c.minimumPartition(s, k);
        System.out.println("i = " + i);
    }
    public int minimumPartition(String s, int k) {
        //f[i][j] 最少的数目
        s = " "+s;
        int n = s.length();
        int[][] f = new int[n+1][n+1];
        for (int i = 1; i <n; i++) {
            Arrays.fill(f[i],n);
            f[i][i] = (s.charAt(i)-'0'<=k)?1:0;
            if(f[i][i]==0) return -1;
        }
        System.out.println("n = " + n);
        int ans = n-1;
        for (int len = 2; len < n; len++) {
            for (int i = 1;  i+len-1<=n; i++) {
                int r = i+len-1;
                for (int j = i+1; j <=r ; j++) {
                    System.out.println("i = " + i+" r = " + r+ " j="+j);
                    String str =s.substring(i,j);
                    int v = Integer.parseInt(str);
                    if(v<=k){
                        if(j==r){
                            f[i][r] =1;
                        }
                        else{
                            f[i][r] =Math.min(f[i][r],1+f[j][r]);
                        }
                    }
                }
            }
        }
        ans = Math.min(ans,f[1][n-1]);
        return ans;
    }

    public int ans;
    public int minimumPartition2(String s, int k) {
        ans =-1;
        int cnt =0;
        List<String> list = new ArrayList<>();
        dfs(s,k,0,cnt,list);
        return ans;
    }
    public void dfs(String s, int k, int ind, int cnt,List<String> list){
        System.out.println("ind = " + ind+" cnt ="+cnt+" list "+list.size());
        if(ind == s.length()){
            if(s.length()==cnt){
                if(ans==-1||ans>list.size()){
System.out.println("-ind = " + ind+" cnt ="+cnt+" ans "+list.size());

                    ans = list.size();
                }
            }
            return;
        }
        System.out.println("2  ind = " + ind+" cnt ="+cnt);
        for (int i = ind+1; i < s.length(); i++) {
            String str = s.substring(ind,i);
            System.out.println("ind = " + ind+"str = " + str);
            if(Integer.valueOf(str)>k)break;
            cnt += str.length();
            list.add(str);
            dfs(s,k,i,cnt,list);
            cnt-= str.length();
            list.remove(list.size()-1);
        }
        return;
    }
}
