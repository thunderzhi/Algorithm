package org.cxz.algorithm.txt;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/12/1 15:29
 */
public class txtmatch_kmp {
    public static void main(String[] args) {
        String txt = "aecaeaecaed";
        String pattern = "aecaed";
        int res = new txtmatch_kmp().kmp(txt, pattern);

        System.out.println("res = " + res);
    }



    int kmp(String txt,String pattern){
        int n = pattern.length();
       
        int[] next = new int[n];
        GetNext(pattern,next);
        for (int i = 0,j =-1; i < txt.length() ; i++) {
            System.out.println("===================");
            System.out.println("txt i = " + i);
            while(j!=-1&&txt.charAt(i)!=pattern.charAt(j+1)){
                System.out.println(String.format("move j from {0} to {1}",j,next[j]));
                j= next[j];
            }
            if (txt.charAt(i)==pattern.charAt(j+1)){
                j+=1;
            }
            if (pattern.length()==j+1){
                return i-j;
            }
        }
        return -1;
    }

    public void GetNext(String pattern, int[] next) {
        next[0]=-1;
        for (int i = 1,j=-1; i < pattern.length(); i++) {

            while(j!=-1&&pattern.charAt(i)!=pattern.charAt(j+1)){
                //move j to previous

                j = next[j];
            }
            if (pattern.charAt(i)==pattern.charAt(j+1)){
                // match go next
                j+=1;
            }
            next[i] =j;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb.append("Index: ");
        sb2.append("Value: ");
        for (int i = 0; i < next.length; i++) {
            sb.append("   "+i+"  ");
            sb2.append(" ["+next[i]+"] ");
        }
        System.out.println(sb.toString());
        System.out.println(sb2.toString());

        
    }

}
