package org.cxz.algorithm.array;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/3 21:31
 */
public class case2182 {

    //region ver1 bymy PriorityQueue
    //ver1 bymy PriorityQueue
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] charcnt = new int[26];
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((o1, o2)->{return o2-o1;});
        for(int i=0;i<s.length();i++){
            charcnt[s.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++){
            if(charcnt[i]==0)continue;
            pq.offer(i);
        }
        StringBuffer sb = new StringBuffer();
        int latestchar = -1 ;
        while(!pq.isEmpty()){
            int first = pq.poll();
            int second =-1;
            int cnt =0;
            if(pq.isEmpty()){
                if(latestchar == first){
                    break;// last char same
                }
                else{
                    cnt = Math.min(repeatLimit,charcnt[first]);
                    contact(sb,(char)(first+'a'),cnt);
                    break;
                }
            }
            if(latestchar!=first){
                cnt = Math.min(repeatLimit,charcnt[first]);
                contact(sb,(char)(first+'a'),cnt);
                charcnt[first]-=cnt;
                //latestchar = first;
                //latestnum = cnt;
            }
            else{
                second = pq.poll();
                contact(sb,(char)(second+'a'),1);
                charcnt[second]-=1;
                //latestchar = second;
                //latestnum = 1;
                if(charcnt[second]>0) pq.offer(second);
            }
            latestchar = (latestchar!=first)?first:second;

            if(charcnt[first]>0) pq.offer(first);
        }
        return sb.toString() ;
    }

    public void contact(StringBuffer sb,char c,int cnt){
        for(int i=0;i<cnt;i++) sb.append(c);
        return;
    }
    //endregion

    //region ver 2 CAP
    // ver 2
    public String repeatLimitedString2(String s, int repeatLimit) {
        int n = s.length();
        Character[] str = new Character[n + 5];
        Arrays.fill(str, '\0');
        for (int i = 0; i < n; i++) str[i] = s.charAt(i);
        Arrays.sort(str, (c1, c2) -> c2 - c1);
        StringBuffer temp;
        StringBuffer ans = new StringBuffer();
        int i = 0, j = 0;
        while (i < n) {
            temp = new StringBuffer();
            temp.append(str[i]);
            i++;
            while (i < n && str[i] == temp.charAt(0)) {
                temp.append(str[i]);
                i++;
            }
            j = 0;
            while (temp.length() - j > repeatLimit) {
                ans.append(temp.substring(j, j + repeatLimit));
                if (str[i] == '\0') return ans.toString();
                ans.append(str[i]);
                i++;
                j += repeatLimit;
            }
            if (j < n) {
                ans.append(temp.substring(j, Math.min(j + repeatLimit,
                        temp.length())));
            }
        }
        return ans.toString();
    }
    //endregion
}
