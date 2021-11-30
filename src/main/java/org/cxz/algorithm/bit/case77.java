package org.cxz.algorithm.bit;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/11/29 17:59
 */
public class case77 {
    public static void main(String[] args) {

    }
    // not test pass
    public List<List<Integer>> ans;
    public int length;
    public List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<Integer>();
        length =k;
        dfs(track,0,n);
        return ans;
    }

    public void dfs(LinkedList<Integer> track ,int ind ,int n){
        if (track.size() ==length){
            ans.add(new LinkedList<>(track));
            return;
        }

        for (int i = 1; i <= n ; i++) {
            if(track.contains(i)){
                continue;
            }
            int t = i;

            track.addLast(i);
            dfs(track,ind+1,n);
            track.removeLast();
        }

        return;
    }
}
