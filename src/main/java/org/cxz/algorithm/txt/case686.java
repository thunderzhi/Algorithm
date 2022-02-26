package org.cxz.algorithm.txt;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/2/26 16:54
 */
public class case686 {

    //
    public int repeatedStringMatch(String a, String b) {
        int la = a.length();
        int lb = b.length();
        int cnt = 1;
        StringBuffer sb = new StringBuffer(a);
        while(sb.length()<lb){
            sb.append(a);
            cnt++;
        }
        int end = cnt+1;
        while(cnt<=end){
            // if(sb.indexOf(b)!=-1) return cnt;
            if(kmp(sb.toString(),b)!=-1) return cnt;
            sb.append(a);
            cnt++;
        }

        return -1;
    }

    public void getNext(String pattern,int[] next){
        next[0]=-1;
        for (int i = 1,j=-1; i < pattern.length(); i++) {
            while(j!=-1&&pattern.charAt(i)!=pattern.charAt(j+1)){//miss j+1
                j = next[j];
            }
            if (pattern.charAt(i)==pattern.charAt(j+1)){//miss j+1
                j+=1;
            }
            next[i] =j;
        }
        return ;
    }

    int kmp(String txt,String pattern){
        int[] next = new int[pattern.length()];
        getNext(pattern,next);
        int j =-1;
        for (int i = 0; i < txt.length(); i++) {

            while (j!=-1&&txt.charAt(i)!=pattern.charAt(j+1)){
                j = next[j];
            }
            if (txt.charAt(i)==pattern.charAt(j+1)){
                j+=1;
            }
            if(pattern.length() == j+1){
                return i-j;
            }
        }
        return -1;
    }
}
