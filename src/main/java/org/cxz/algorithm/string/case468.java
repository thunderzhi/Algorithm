package org.cxz.algorithm.string;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description: myself
 * @date 2021/12/29 10:52
 */
public class case468 {
    public static void main(String[] args) {
        String test ="1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111.1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111.1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111.1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111";


        //String s = new case468().validIPAddress("20EE:FGb8:85a3:0:0:8A2E:0370:7334");
        String s = new case468().validIPAddress(test);
        System.out.println("s = " + s);

    }


    public String validIPAddress(String queryIP) {
        if(queryIP.equals("")){
            return "Neither";
        }
        int n = queryIP.length();
        boolean isIPv4 = false;
        boolean isIPv6 = false;
        for (int i = 0; i < n; i++) {
            char c = queryIP.charAt(i);
            if(c<='9'&&c>='0'){
                continue;
            }
            if(c=='.'){
                //maybe v4
                isIPv4 = VaildateIPv4(queryIP);
                return isIPv4?"IPv4":"Neither";
            }
            if((c==':')||(c<='F'&&c>='A')||(c<='f'&&c>='a')){
                //maybe v6
                isIPv6 = VaildateIPv6(queryIP);
                return isIPv6?"IPv6":"Neither";
            }

            return "Neither";
        }

        return "Neither";
    }

    public boolean VaildateIPv4(String ip){
        if(ip.endsWith(".")){
            return false;
        }
        String[] arr = ip.split("[.]");
        if(arr.length!=4){
            return false;
        }
        boolean res = true;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].equals("")){
                return false;
            }
            if(arr[i].length()>1&&arr[i].charAt(0)=='0'){
                return false;
            }
            if(arr[i].length()>3){
                return false;
            }
            int num =0;
            for (int j = 0; j < arr[i].length(); j++) {
                if(arr[i].charAt(j)<'0'||arr[i].charAt(j)>'9'){
                    return false;
                }
                num = num*10 +arr[i].charAt(j)-'0';
            }
            if(num>255){
                return false;
            }
        }
        return res;
    }
    public boolean VaildateIPv6(String ip){
        if(ip.endsWith(":")){
            return false;
        }
        String[] arr = ip.split(":");
        if(arr.length!=8){
            return false;
        }
        boolean res = true;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].equals("")){
                return false;
            }
            if(arr[i].length()>4){
                return false;
            }
            for (int j = 0; j < arr[i].length(); j++) {
                if(arr[i].charAt(j)>='0'&&arr[i].charAt(j)<='9'){
                    continue;
                }
                if(arr[i].charAt(j)>='a'&&arr[i].charAt(j)<='f'){
                    continue;
                }
                if(arr[i].charAt(j)>='A'&&arr[i].charAt(j)<='F'){
                    continue;
                }
                return false;
            }
        }
        return res;
    }
}