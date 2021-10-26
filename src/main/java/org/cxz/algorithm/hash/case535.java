package org.cxz.algorithm.hash;

import java.util.HashMap;
import java.util.Random;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/10/26 11:53
 */
public class case535 {

    public static void main(String[] args) {

    }
    public char getchar(int x){
        x %= 62;
        if(x<26){
            return (char)(x+'a');
        }
        if(x<52){
            return (char)(x-26+'A');
        }
        return (char)(x-52+'0');
    }
    public String getStr(int l){
        Random random = new Random();
        int n =0;
        StringBuilder sb = new StringBuilder();
        while(n<l){
            int i = random.nextInt(1000);
            sb.append(getchar(i));
            n++;
        }
        return sb.toString();
    }
    public static HashMap<String, String> map = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        StringBuilder url = new StringBuilder("http://tinyurl.com/");
        String s = "";
        do{
            url.append(getStr(5));
            s = url.toString();
        }while (map.containsKey(s));
        map.put(s,longUrl);
        return s;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }

}
