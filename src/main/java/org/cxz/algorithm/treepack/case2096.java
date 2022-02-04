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
public class case2096 {


    public String getDirections(TreeNode root, int startValue, int destValue) {
        List<String> spath = findpath(root,new LinkedList(),startValue);
        List<String> dpath = findpath(root,new LinkedList(),destValue);
        StringBuffer sb = new StringBuffer();
        for(String s: spath){
            sb.append(s);
        }
        String sstr = sb.toString();
        System.out.println("s1:"+sstr);
        sb = new StringBuffer();
        for(String s: dpath){
            sb.append(s);
        }
        String dstr = sb.toString();
        System.out.println("s2:"+dstr);
        int p =0;
        while(p<sstr.length()&&p<dstr.length()&&sstr.length()>0&&dstr.length()>0){
            if(sstr.charAt(p)!=dstr.charAt(p)){
                break;
            }
            p++;
        }
        System.out.println("p:"+p);
        sstr = sstr.substring(p,sstr.length());
        dstr = dstr.substring(p,dstr.length());
        sb = new StringBuffer();
        for(int i =0;i<sstr.length();i++){
            sb.append("U");
        }
        for(int i =0;i<dstr.length();i++){
            sb.append(dstr.charAt(i));
        }
        return sb.toString();
    }
    public LinkedList<String> findpath(TreeNode node, LinkedList<String> path, int dest){
        if(node==null){
            return null;
        }
        if(node.val==dest){
            LinkedList<String> ans = new LinkedList(path);
            return ans;
        }
        path.add("L");
        LinkedList<String> l = findpath(node.left,path,dest);
        if(l!=null){
            return l;
        }
        path.removeLast();
        path.add("R");
        LinkedList<String> r = findpath(node.right,path,dest);
        if(r!=null){
            return r;
        }
        path.removeLast();
        return null;
    }
}
