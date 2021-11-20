package org.cxz.algorithm.treepack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/11/19 16:21
 */
public class case449 {
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if(root==null){
                return "";
            }
            StringBuilder sb = new StringBuilder();
            sb.append(root.val);
            if(root.left!=null||root.right!=null){
                sb.append("(");
            }
            sb.append(serialize(root.left));
//            String left ="";
//            left = serialize(root.left);
            if(root.right!=null){
                sb.append(",");
            }
            sb.append(serialize(root.right));
//            String rigth ="";
//            rigth = serialize(root.right);
            if(root.left!=null||root.right!=null){
                sb.append(")");
            }
            System.out.println("sb = " + sb.toString());
            return sb.toString();

            //preorder
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            int code = 0,ind =0,k=0;// code is status.ind is index of string ,k is 1left or 2right.
            Deque<TreeNode> st = new LinkedList<>();
            TreeNode p=null;
            TreeNode root=null;
            while(ind<data.length()){
                switch(code){
                    case 0:{
                        if(data.charAt(ind)<='9'&&data.charAt(ind)>='0'){
                            //is num
                            code =1;
                        }
                        else if(data.charAt(ind)=='('){
                            code = 2;
                        }
                        else if(data.charAt(ind)==','){
                            code = 3;
                        }
                        else if(data.charAt(ind)==')'){
                            code = 4;
                        }

                    } break;
                    case 1:{
                        int num=0;
                        while(ind<data.length()&&data.charAt(ind)<='9'&&data.charAt(ind)>='0'){
                            num = num*10+(data.charAt(ind)-'0');
                            ind+=1;
                        }
                        p = new TreeNode(num);
                        if(root==null){
                            root = p;
                        }
                        if(k==1){
                            st.peekLast().left = p;
                        }
                        else if(k==2){
                            st.peekLast().right = p;
                        }
                        code =0;
                    } break;
                    case 2:{
                        // (
                        st.offerLast(p);
                        k=1;
                        ind+=1;
                        code=0;
                    } break;
                    case 3:{
                        // ,
                        k = 2;
                        ind+=1;
                        code=0;
                    } break;
                    case 4:{
                        // )
                        st.pollLast();
                        ind+=1;
                        code=0;
                    } break;

                }
            }
            return root;
        }
    }



    public static void main(String[] args) {

    }


}
