package org.cxz.algorithm.treepack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/5/24 14:06
 */
public class case095 {
    public static void main(String[] args) {
        List<TreeNode> treeNodes = new case095().generateTrees(3);


        System.out.println("Arrays.toString() = " );
    }

    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1,n);
    }
    /*
    生成左右子树形成笛卡尔积，

     */
    public List<TreeNode> generateTrees(int start ,int end){
        List<TreeNode> ans = new ArrayList<>();
        if(start>end){
            ans.add(null);
            return ans;
        }
        for (int i = start; i <= end ; i++) {

            List<TreeNode> left = generateTrees(start,i-1);
            List<TreeNode> right = generateTrees(i+1,end);
            for (TreeNode ln : left) {
                for (TreeNode rn : right) {
                    ans.add(new TreeNode(i,ln,rn));
                }
            }
        }
        return ans;
    }



}
