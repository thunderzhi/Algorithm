package org.cxz.algorithm.string;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/3/30 17:37
 */
public class case1576 {
    public static void main(String[] args) {
        String s = new case1576().modifyString("j?qg??b");
        System.out.println(s);

    }
    public String modifyString(String s) {
        if(s.isEmpty()){
            return s;
        }
        char[] chars = s.toCharArray();

        if(chars.length==1&&chars[0]=='?'){
            return "a";
        }
        if(chars.length==1&&chars[0]=='?'&&chars[1]=='?'){
            return "ab";
        }

        for(int i=0;i<s.length()-1;i++){
            char c ='0';
            if(chars[i]=='?'){
                if(i+1==s.length()-1){
                    c = genchar(chars[i-1],chars[i-1]);
                    chars[i] = c;
                    break;
                }
                else{
                    if(i>=1){
                        c = genchar(chars[i-1],chars[i+1]);

                    }
                    else{
                        c = genchar(chars[i+1],chars[i+1]);
                    }
                    chars[i] = c;
                }

            }


        }
        return new String(chars);
    }

    public char genchar(char a,char b){
        int i = 0;
        char c ='0' ;
        while(i<26){
            c = (char)(i+97);
            if(c!=a&&c!=b){
                break;
            }
            i++;
        }
        return c;
    }
}
