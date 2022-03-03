package org.cxz.algorithm.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/3 12:15
 */
public class case205 {
    public boolean isIsomorphic(String s, String t) {
        int[] mapx = new int[256];
        int[] mapy = new int[256];
        Arrays.fill(mapx,-1);
        Arrays.fill(mapy,-1);
        for(int i=0;i<s.length();i++){
            int x = s.charAt(i);
            int y = t.charAt(i);
            if((mapx[x]!=-1&&mapx[x]!=y)||(mapy[y]!=-1&&mapy[y]!=x)){
                return false;
            }
            mapx[x] =y;
            mapy[y] =x;
        }
        return true;
    }

    public boolean isIsomorphic2(String s, String t) {
        Map<Character,Character> mapx = new HashMap();
        Map<Character,Character> mapy = new HashMap();
        for(int i=0;i<s.length();i++){
            char x = s.charAt(i);
            char y = t.charAt(i);
            if((mapx.containsKey(x)&&mapx.get(x)!=y)
                    ||(mapy.containsKey(y)&&mapy.get(y)!=x)){
                return false;
            }
            mapx.put(x,y);
            mapy.put(y,x);
        }
        return true;
    }
}
