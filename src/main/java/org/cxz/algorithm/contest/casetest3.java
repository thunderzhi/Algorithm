package org.cxz.algorithm.contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/16 15:26
 */
public class casetest3 {
    public static void main(String[] args) {

    }
    public class FenwickTree {

        public int[] C;

        //biggest index
        public int n;

        public FenwickTree(int size){
            C = new int[size+1];
            n = size;
        }

        public int lowbit(int x){
            return x&(-x);
        }
        public void add(int i ,int x){
            while(i<=n){
                C[i] +=x;
                i = i+lowbit(i);
            }
            return;
        }

        //s[i] = s[i-lowbit(i)] +c[i]
        public int query(int i){
            int sum =0;
            while(i>0){
                sum += C[i];
                i = i -lowbit(i);
            }
            return sum;
        }
        //get original index array value
        public int getIndVal(int i){
            if(i==0){
                return 0;
            }
            return query(i)- query(i-1);
        }

        public void output(){

            for (int i = 1; i <= n; i++) {
                System.out.printf("%5d", i);
            }
            System.out.print("\n");
            System.out.println(" ================================================ " );

            System.out.print("\n");
            for (int i = 1; i <= n; i++) {
                System.out.printf("%5d",C[i]);
            }
            System.out.print("\n");
            for (int i = 1; i <= n; i++) {
                System.out.printf("%5d",getIndVal(i));
            }
            System.out.print("\n");
            System.out.print("\n");
            System.out.print("\n");
            return;
        }

    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int getNumber(TreeNode root, int[][] ops) {
        List<Integer> list = new ArrayList<>();
        inorder(root,list);
        int[] arr = list.stream().mapToInt(Integer::intValue).toArray();
        //blue :0 red: 1
        int[] color = new int[arr.length];
        FenwickTree ft = new FenwickTree(color.length);
        for (int i = 0; i <ops.length ; i++) {
            int x = ops[i][1];
            int y = ops[i][2];
            int c = ops[i][0];
            int indx = findind(arr,0,arr.length-1,x);
            if(indx==-1) continue;
            for (int j = indx; j <arr.length&&arr[j]<=y; j++) {
                if(color[j]==c) continue;
                if(c==0){
                    color[j] = 1;
                    ft.add(j+1,-1);
                }
                else{
                    color[j] = 0;
                    ft.add(j+1,1);
                }
            }
            System.out.println("ft.C = " +Arrays.toString(ft.C) );
        }
        return ft.query(arr.length);
    }

    public int findind(int[] arr, int l,int r,int tar){
        int mid=0;
        while(l<r){
            mid = l+(r-l)/2;
            if(arr[mid]==tar){
                return mid;
            }
            else if(arr[mid]<tar){
                l=mid+1;
            }
            else{
                r = mid -1;
            }
        }
        return arr[l]==tar?l:-1;
    }

    public void inorder(TreeNode root,List<Integer> list){
        if(root==null) return;
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
        return;
    }
}
