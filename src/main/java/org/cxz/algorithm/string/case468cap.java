package org.cxz.algorithm.string;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description: myself
 * @date 2021/12/29 10:52
 */
public class case468cap {
    public static void main(String[] args) {
        //String test ="1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111.1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111.1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111.1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111";


        String s = new case468().validIPAddress("20EE:FGb8:85a3:0:0:8A2E:0370:7334:");
        //String s = new case468cap().validIPAddress(test);
        System.out.println("s = " + s);

    }


    public String validIPAddress(String queryIP) {
        int cnt= 0;
        int preind = 0;
        int flag =0;//4--v4,6---v6;
        for (int i = 0; i <= queryIP.length(); i++) {

            if((flag==4&&i==queryIP.length())||(i<queryIP.length()&&queryIP.charAt(i)=='.')){
                //v4
                if(flag==0){
                    flag = 4;
                }
                if(flag!=4||!VaildateIPv4(queryIP,preind,i)){
                    flag =-1;
                    break;
                }
                cnt+=1;
                preind= i+1;
            }
            if((flag==6&&i==queryIP.length())||(i<queryIP.length()&&queryIP.charAt(i)==':')){
                //v6
                if(flag==0){
                    flag = 6;
                }
                if(flag!=6||!VaildateIPv6(queryIP,preind,i)){
                    flag =-1;
                    break;
                }
                cnt+=1;
                preind= i+1;
            }
        }
        if(flag==4&&cnt==4){
            return "IPv4";
        }
        if(flag==6&&cnt==8){
            return "IPv6";
        }
        return "Neither";

    }

    public boolean VaildateIPv4(String ip,int l,int r){
        if(r-l<=0||r-l>3){
            return false;
        }
        if(r-l>1&&ip.charAt(l)=='0'){
            return false;
        }
        int num =0;
        for (int i = l; i < r; i++) {
            char c = ip.charAt(i);
            if(c>'9'||c<'0'){
                return false;
            }
            num = num*10+(c-'0');
        }
        return num<256;
    }
    public boolean VaildateIPv6(String ip,int l,int r){
        if(r-l<=0||r-l>4){
            return false;
        }
        for (int i = l; i < r; i++) {
            char c = ip.charAt(i);
            if(c>='0'&&c<='9'){continue;}
            if(c>='a'&&c<='f'){continue;}
            if(c>='A'&&c<='F'){continue;}
            return false;
        }
        return true;
    }
}