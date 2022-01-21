package org.cxz.algorithm.string;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/1/21 12:29
 */
public class case1147 {
    public int longestDecomposition(String text) {
        return getResult(text,0,text.length()-1);
    }


    public int getResult(String txt,int l,int r){
        int n = r -l+1;
        if(n<0){
            return 0;
        }
        if(n<=1){
            return n;
        }
        for(int i= 1;i<=n/2;i++){
            boolean flag = true;
            for( int j = l,k = r-i+1;k<=r;j++,k++){
                if(txt.charAt(j)==txt.charAt(k)){
                    continue;
                }
                flag = false;
                break;
            }
            if(flag){
                int res =getResult(txt,l+i,r-i)+2;
                return res;
            }
        }
        return 1;
    }
}
