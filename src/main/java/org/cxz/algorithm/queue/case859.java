package org.cxz.algorithm.queue;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/3/15 22:55
 */
public class case859 {
    public boolean hasRepeat(String a){
        int[] cnt = new int[26];
        char[] ac = a.toCharArray();
        for(int i = 0; i<ac.length;i++){
            cnt[ac[i]-'a'] +=1;
            if(cnt[ac[i]-'a']==2){
                return true;
            }
        }
        return false;
    }
    public boolean buddyStrings(String a, String b) {
        if(a.length()!=b.length()){
            return false;//长度不一样
        }
        if(a.equals(b)){
            return hasRepeat(a);
        }
        int i = 0;
        int j;
        char[] a1 = a.toCharArray();
        char[] b1 = b.toCharArray();
        
        while(a1[i]==b1[i]){
            ++i;
        };//得到第一个不相同的char
        j=i+1;
        while(j<a.length()&&a1[j]==b1[j]){
            ++j;
        }//可能遍历结束，或者得到第二个相同char
        if(j==a.length()){
            return false;
        }
        if(a1[i]!=b1[j]||a1[j]!=b1[i]){
            return false;//交叉不相等
        }
        j+=1;
        while(j<a.length()){
            if(a1[j]!=b1[j]){
                return false;
            }
            j+=1;
        }
        return true;

    }
}
