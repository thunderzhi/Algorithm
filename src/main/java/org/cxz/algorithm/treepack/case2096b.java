package org.cxz.algorithm.treepack;

import java.util.LinkedList;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/2/3 15:57
 */
public class case2096b {

    public String getDirections(TreeNode root, int startValue, int destValue) {
        char[] buff = new char[200000];
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        dfs(root,0,startValue,destValue,sb1,sb2,buff,0);
        String left = sb1.toString();
        String right = sb2.toString();
        int p = 0;
        while(left.length()>0&&right.length()>0
                &&p<left.length()&&p<right.length()&&left.charAt(p)==right.charAt(p)){
            p++;
        }
        left = left.substring(p);
        right = right.substring(p);
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<left.length();i++){ sb.append("U");}
        sb.append(right);
        return sb.toString();
    }

    public void dfs(TreeNode root,int k,int a,int b
            , StringBuffer astr, StringBuffer bstr,char[] buff,int c){
        if(root==null){
            return;
        }
        if(root.val ==a ){
            for(int i=0;i<k;i++){
                astr.append(buff[i]);
            }
            c++;
        }
        if(root.val ==b ){
            for(int i=0;i<k;i++){
                bstr.append(buff[i]);
            }
            c++;
        }
        if(c==2){
            return;
        }
        buff[k] ='L';
        dfs(root.left,k+1,a,b,astr,bstr,buff,c);
        buff[k] ='R';
        dfs(root.right,k+1,a,b,astr,bstr,buff,c);
        return;
    }
}
