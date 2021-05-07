package org.cxz.algorithm.treepack;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/4/4 15:54
 */
public class case105 {

    public static void main(String[] args) {
        String preorderfile ="D://preorder.txt";
        String inorderfile ="D://inorder.txt";
        String prestr = readfile(preorderfile);
        String[] prearr = prestr.split(" ");
        String instr = readfile(inorderfile);
        String[] inarr = instr.split(" ");
        int[] prearray = Arrays.asList(prearr).stream().mapToInt(Integer::parseInt).toArray();
        int[] inarray = Arrays.asList(inarr).stream().mapToInt(Integer::parseInt).toArray();
//        int[] a = new int[]{3,9,20,15,7};
//        int[] b = new int[]{9,3,15,20,7};
        TreeNode root = new case105().buildTree(prearray, inarray);
        LinkedList<Integer> queue = new LinkedList<>();
        new case105().post(root,queue);
        long sum =0;
        System.out.println("size "+queue.size());
        for (int i = 0; i <queue.size() ; i++) {
            int j = i+1;

            sum +=  queue.get(i)* j;
        }

        System.out.println(sum);


    }

    public static String readfile(String fileName ){
        File file = new File(fileName);
        BufferedReader reader = null;
        StringBuilder sb = new StringBuilder();
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));


            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                System.out.println("line " + line + ": " + tempString);
                line++;
                sb.append(tempString);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return sb.toString();
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        List<Integer> pre= new ArrayList<>();
        List<Integer> in= new ArrayList<>();
        int i =0;
        while(i<preorder.length){
            pre.add(preorder[i]);
            i++;
        }
        i=0;
        while(i<inorder.length){
            in.add(inorder[i]);
            i++;
        }

        return _buildTree(pre,in);

    }

    public TreeNode _buildTree(List<Integer> preorder, List<Integer> inorder){
        if(preorder.size()==0){return null;}
        int pos =0 ;
        System.out.println("inorder "+inorder.size());
        while (!inorder.get(pos).equals(preorder.get(0))  ) {
            System.out.println(pos);
            pos++;
        }
        List<Integer> lpre = new ArrayList<>();
        List<Integer> lin = new ArrayList<>();
        List<Integer> rpre = new ArrayList<>();
        List<Integer> rin = new ArrayList<>();
        for(int i = 0;i<pos ;i++){
            lpre.add(preorder.get(i+1));
            lin.add(inorder.get(i));
        }
        for(int i = pos+1;i<inorder.size();i++){
            rpre.add(preorder.get(i));
            rin.add(inorder.get(i));
        }
        TreeNode root = new TreeNode(preorder.get(0)) ;
        root.left = _buildTree(lpre,lin);
        root.right = _buildTree(rpre,rin);
        return root;
    }

    public void  post(TreeNode root, LinkedList<Integer> queue){
        if(root == null){
            return ;
        }
        post(root.left,queue);
        post(root.right,queue);
        queue.offer(root.val);
        return;
    }
}
