package org.cxz.algorithm.txt;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/12/3 16:29
 */
public class txtmatch_sunday {
    public static void main(String[] args) {
        String txt = "aecaeaecaedc";
        System.out.println("txt length = " + txt.length()    );
        String pattern = "aecaed";
        System.out.println("pattern length = " + pattern.length()    );
        int res = new txtmatch_sunday().sunday(txt, pattern);
        System.out.println("res = " + res);
    }

    int sunday(String txt,String pattern){
        int base = 256;
        int[] lastpos = new int[base];
        int n = txt.length();
        int m =0;
        for (int i = 0; i < base; i++) {
            lastpos[i] =-1;
        }
        for (m = 0; m < pattern.length(); m++) {
            int ind = (int)pattern.charAt(m);
            lastpos[ind] = m;
        }
        for (int i = 0; i <= n - m; i+=(m- lastpos[txt.charAt(i+m)]  )) {
            // when start a new loop ,flag set 1
            int flag =1;
            for (int j = 0; j < m; j++) {
                if (txt.charAt(i+j)==pattern.charAt(j)){
                    //char match go next
                    continue;
                }
                // char not match  flag set 0 ,break loop ,i go next
                flag = 0;
                break;
            }
            if (flag==1){
                return i;
            }
        }
        return -1;
    }
}
