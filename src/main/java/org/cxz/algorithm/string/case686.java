package org.cxz.algorithm.string;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/3 12:06
 */
public class case686 {
    public int repeatedStringMatch(String a, String b) {
        StringBuffer sb = new StringBuffer(a);
        int cnt = 1;
        while(sb.length()<b.length()){
            sb.append(a);
            cnt++;
        }

        int end = cnt+1;
        while(cnt<=end){

            if(kmp(sb.toString(),b)!=-1){
                return cnt;
            }
            sb.append(a);
            cnt++;
        }
        return -1;
    }

    public int kmp(String txt,String pattern){
        int m = txt.length();
        int n = pattern.length();
        int[] next = new int[n];

        getNext(pattern,next);//miss
        //System.out.println("next: "+Arrays.toString(next));
        for(int i =0,j=-1;i<m;i++){
            while(j!=-1&&txt.charAt(i)!=pattern.charAt(j+1)){ j = next[j];}
            if(txt.charAt(i)==pattern.charAt(j+1)) {j++;}//j++;
            if(j==n-1){ return i-j;}//miss
        }
        return -1;
    }

    public void getNext(String txt,int[] next){
        next[0]=-1;//miss
        for(int i =1,j=-1;i<txt.length();i++){
            while(j!=-1&&txt.charAt(i)!=txt.charAt(j+1)) {j = next[j];}
            if(txt.charAt(i)==txt.charAt(j+1)) j++;
            //if(j==txt.length()-1) return;
            next[i]=j;
        }
        return ;
    }
}
