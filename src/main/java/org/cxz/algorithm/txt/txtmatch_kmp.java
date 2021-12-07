package org.cxz.algorithm.txt;

import java.text.MessageFormat;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/12/1 15:29
 */
public class txtmatch_kmp {
    public static void main(String[] args) {
        String txt = "aecaeaecaedc";
        System.out.println("txt length = " + txt.length()    );
        String pattern = "aecaed";
        System.out.println("pattern length = " + pattern.length()    );

        int res = new txtmatch_kmp().kmp(txt, pattern);

        System.out.println("res = " + res);
    }

    //without comment
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

    //without comment
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




    int kmp2(String txt,String pattern){
        int n = pattern.length();
       
        int[] next = new int[n];
        GetNext2(pattern,next);
        for (int i = 0,j =-1; i < txt.length() ; i++) {
            System.out.println("===================");
            System.out.println("txt i = " + i);
            while(j!=-1&&txt.charAt(i)!=pattern.charAt(j+1)){
                System.out.println("j = " + j);
                String s = MessageFormat.format(" move j from {0} to {1} ",j,next[j]);

                String str = next[j]==-1?" [char at -1] ":pattern.charAt(next[j])+"";
                String s2= MessageFormat.format(" char j from {0} to {1} ",pattern.charAt(j),str);
                System.out.println( s+ s2);
                //System.out.println(MessageFormat.format("move j from {0} to {1} --{2} to {3}",j,next[j],pattern.charAt(j),(j!=-1?pattern.charAt(next[j]):" j is out of bound ")));
                j= next[j];
            }
            if (txt.charAt(i)==pattern.charAt(j+1)){
                System.out.println("txt ind= "+i+" equal to pattern (j+1) = " +(j+1)+" == "+txt.charAt(i)+" j will plus 1");
                j+=1;
                System.out.println( " j after plus 1 == "+j);
            }
            if (pattern.length()==j+1){
                return i-j;
            }
        }
        return -1;
    }

    public void GetNext2(String pattern, int[] next) {
        //next[0] means that the first element not equal, only jump to -1
        next[0]=-1;
        //now for[] start at 1
        for (int i = 1,j=-1; i < pattern.length(); i++) {
            //
            while(j!=-1&&pattern.charAt(i)!=pattern.charAt(j+1)){
                //move j to previous

                String s = MessageFormat.format(" pat move j from {0} to {1} ",j,next[j]);

                String str = next[j]==-1?" [char at -1] ":pattern.charAt(next[j])+"";
                String s2= MessageFormat.format(" char j from {0} to {1} ",pattern.charAt(j),str);
                System.out.println( s+ s2);
                j = next[j];
            }
            if (pattern.charAt(i)==pattern.charAt(j+1)){
                System.out.println("pat ind= "+i+" equal to pat (j+1) = " +(j+1)+" == "+pattern.charAt(i)+" j will plus 1");
                // match go next
                j+=1;
                System.out.println("pat j after plus 1 j=="+j);

            }

            next[i] =j;
            System.out.println("next["+i+"] = " + j);
        }

        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb.append("Index: ");
        sb2.append("Value: ");
        for (int i = 0; i < next.length; i++) {
            sb.append("   "+i+pattern.charAt(i)+"  ");
            sb2.append("  ["+next[i]+"] " );
        }
        System.out.println(sb.toString());
        System.out.println(sb2.toString());

        System.out.println("*****************************************************" );
        
    }

}
