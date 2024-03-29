package org.cxz.algorithm.off.I;

import java.util.*;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description: backtrack not good ver 2
 * @date 2022/2/16 15:02
 */
public class caseOff038b {

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        StringBuilder sb2 = new StringBuilder();

        sb.append("c");
        System.out.println(" l:"+sb.length());
        System.out.println(sb.toString());
        sb.deleteCharAt(sb.length()-1);
        System.out.println(" l:"+sb.length());
        System.out.println(sb.toString());

    }
    public boolean[] visited ;
    public List<String> anslist;
    public String[] permutation(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        visited = new boolean[arr.length];
        LinkedList<Character> sb = new LinkedList();
        anslist = new ArrayList();
        backtrack(arr,0,sb,anslist);

        String[] ans = new String[anslist.size()];
        int p =0;
        for(String str: anslist){
            ans[p++]= str;
        }
        return ans;
    }
    public void backtrack(char[] arr,int ind,
                          LinkedList<Character> track,List<String> anslist ){
        if(track.size()==arr.length){
            StringBuffer sb = new StringBuffer();
            for(Character c: track){
                sb.append(c);
            }
            anslist.add(sb.toString());
            return;
        }

        for(int i=0;i<arr.length;i++){
            //
            if(visited[i]||i>0&&!visited[i-1]&&arr[i-1]==arr[i]){
                continue;
            }
            visited[i] = true;
            track.add(arr[i]);
            backtrack(arr,ind+1,track,anslist);
            track.removeLast();
            visited[i] = false;
        }
        return;
    }

        // to be continue
//    public String[] permutation2(String s){
//        char[] arr = s.toCharArray();
//        List<String> list = new ArrayList<>();
//        list.add(getStr(arr));
//        nextpermutaion(arr,0,list);
//        String[] ans = new String[list.size()];
//        int p =0;
//        for(String str: list){
//            ans[p++] = str;
//        }
//        return ans;
//    }
//
//
//    public void nextpermutaion(char[] arr,int start,List<String> list){
//        if(start==arr.length-1){
//            return;
//        }
//        int p=start;
//        while(arr[start]==arr[p]){
//            p++;
//        }
//        int next = p;
//        for(int i= p;i<arr.length;i++){
//            swap(arr,start,p);
//            list.add(getStr(arr));
//            swap(arr,start,p);
//        }
//        nextpermutaion(arr,next,list);
//        return ;
//    }
//    public void swap(char[] arr,int i,int j){
//        char c = arr[i];
//        arr[i] = arr[j];
//        arr[j] = c;
//    }
//
//    public String getStr(char[] arr){
//        StringBuffer sb = new StringBuffer();
//        for(char c: arr){
//            sb.append(c);
//        }
//        return sb.toString();
//    }
}
