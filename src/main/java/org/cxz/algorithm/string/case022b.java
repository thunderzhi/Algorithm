package org.cxz.algorithm.string;

import java.util.*;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/11/4 18:22
 */
public class case022b {
    int m;
    StringBuilder sb;
    List<String> ans;
    public List<String> generateParenthesis(int n) {
        m = 2*n;
        sb = new StringBuilder();
        ans = new ArrayList();
        dfs(0,0);
        return ans;
    }
    public void dfs(int idx,int left){
        if(left>m/2|| idx-left>left) return;
        //System.out.println(" idx "+ idx + " left "+left +" sb "+sb.toString());
        if(idx==m){
            ans.add(sb.toString());
            return;
        } 
        //if(left>=right){
        // add (
        sb.append('(');
        dfs(idx+1,left+1);
        sb.deleteCharAt(idx);
        //}
        //if(right<left){
        sb.append(')');
        dfs(idx+1,left);
        sb.deleteCharAt(idx);
        //}


        return ;
    }
}
