package org.cxz.algorithm.treepack;

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

        }
    }



    public static void main(String[] args) {

    }


}
