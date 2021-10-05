package org.cxz.algorithm.string;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/10/5 23:45
 */
public class case752a {
    public static void main(String[] args) {

    }

    public class Data{
        String s;

        int v;
        Data(String str, int val){
            s= str;
            v = val;
        }
    }

    public String getStr(String str ,int i,int j){
        char[] arr = str.toCharArray();

        switch(j){
            case 0:
                arr[i]-=1;
                break;
            case 1:
                arr[i]+=1;
                break;
        };
        if(arr[i]<'0'){
            arr[i]='9';
        }
        if(arr[i]>'9'){
            arr[i]='0';
        }
        return new String(arr);
    }

    public int openLock(String[] deadends, String target) {
        HashSet<String> set = new HashSet<String>();

        for(int i=0;i<deadends.length;i++){
            set.add(deadends[i]);
        }
        Queue<Data> queue = new LinkedList<Data>();

        if(set.contains("0000")){
            return -1;
        }
        queue.offer(new Data("0000",0));
        set.add("0000");
        while(!queue.isEmpty()){
            Data t = queue.peek();
            if(target.equals(t.s)){
                return t.v;
            }
            for(int i =0;i<4;i++){
                for(int j=0;j<2;j++){
                    String s = getStr(t.s,i,j);
                    if(set.contains(s)){
                        continue;
                    }
                    set.add(s);
                    queue.offer(new Data(s,t.v+1));
                }
            }

            queue.poll();
        }
        return -1;
    }
}
