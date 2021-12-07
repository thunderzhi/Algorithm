package org.cxz.algorithm.txt;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/12/6 22:52
 */
public class txtmatch_brute_force {
    public static void main(String[] args) {
        String txt = "aecaeaecaedc";
        System.out.println("txt length = " + txt.length()    );
        String pattern = "aecaed";
        System.out.println("pattern length = " + pattern.length());
        int i = new txtmatch_brute_force().brute_force(txt, pattern);
        System.out.println("i = " + i);

    }


    public int brute_force(String txt ,String pattern) {
        int n = txt.length();
        int m = pattern.length();
        for (int i = 0; i <n; i++) {
            int flag = 1;
            for (int j = 0; j < m; j++) {
                if (txt.charAt(i+j)==pattern.charAt(j)){
                    continue;
                }
                flag =0;
                break;
            }
            if(flag==1){
                return i;
            }
        }
        return -1;
    }
}
