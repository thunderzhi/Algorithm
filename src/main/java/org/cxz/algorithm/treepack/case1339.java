package org.cxz.algorithm.treepack;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/11/21 17:09
 */
public class case1339 {

    public static void main(String[] args) {

    }

    public int ans ;
    public int avg;
    public int getTotal(TreeNode root){
        if(root==null){
            return 0;
        }
        int v = root.val+getTotal(root.right)+getTotal(root.left);
        //[1,2,3,4,5,6]   total =21,avg=10,max is 10,11，
        // if use > without = ,we can't get 10 as ans
        // we can use if(Math.abs(ans*2-total)>Math.abs(v*2-total))
        if(Math.abs(ans-avg)>=Math.abs(v-avg)){
            System.out.println( );
            System.out.println("ans = " + ans+" v = " + v+" root ="+root.val);
            ans= v;
        }
        return v;
    }
    public int maxProduct(TreeNode root) {
        int total = getTotal(root);
        ans = total;
        avg = total/2;
        System.out.println("total = " + total+" avg = "+avg);
        getTotal(root);
        int m = 1000000007;
        return (int)((long)ans*(total-ans)%(long)m);
    }
}
