package org.cxz.algorithm.off;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/12/9 17:27
 */
public class case0105 {
    public static void main(String[] args) {

    }


    public boolean oneEditAway(String first, String second) {
        // set the first is longer
        if(second.length()>first.length()){
            String tmp = second;
            second = first;
            first = tmp;
        }
        //now first is longer or equals
        int n = first.length();
        int m = second.length();
        if(n-m>1){
            return false;
        }
        if(n==m){
            int cnt =0;
            for (int i = 0; i < n; i++) {
                if (first.charAt(i)==second.charAt(i)){
                    continue;
                }
                cnt++;
                if(cnt==2){
                    return false;
                }
            }
            return true;
        }

        int i = 0;
        int j = m-1;
        while (i<=j && first.charAt(i)==second.charAt(i) ){
            i++;
        }
        while(i<=j&& first.charAt(j+1)==second.charAt(j)){
            j--;
        }
        return i>j;

    }
}

