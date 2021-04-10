package org.cxz.algorithm.treepack;

import java.util.LinkedList;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/4/6 11:37
 */
public class case662 {
    public static void main(String[] args) {

    }
    public class TwoTuple<A,B> {
        public final A first;

        public final B second;

        public TwoTuple(A a, B b){
            first = a;
            second = b;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {

        LinkedList<TwoTuple<TreeNode, Integer>> q = new LinkedList<>();
        q.offer(new TwoTuple<>(root,0));
        int ans = 0;
        while (!q.isEmpty()){
            int cnt = q.size();
            int l = q.peekFirst().second;
            int r=0;
            for (int i = 0; i < cnt; i++) {
                TwoTuple<TreeNode, Integer> temp = q.peek();
                r = temp.second -l;
                if(temp.first.left!=null){
                    q.offer(new TwoTuple<>(temp.first.left,r*2));
                }
                if(temp.first.right!=null){
                    q.offer(new TwoTuple<>(temp.first.right,r*2+1));
                }
                q.poll();
            }
            ans = Math.max(ans,r+1);
        }

        return ans;
    }


}
