package org.cxz.algorithm.string;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/12/26 10:45
 */
public class case76 {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String s1 = new case76().minWindow(s, t);
        System.out.println("s1 = " + s1);

    }

    public String minWindow(String s, String t) {
        int cnt =0;
        int[] cnts = new int[128];
        for (int i = 0; i < t.length(); i++) {
            int ind = (int)t.charAt(i);
            cnts[ind]-=1;
            if(cnts[ind]==-1){
                cnt+=1;
            }
        }
        int l =0,r=0;
        int ans_len = s.length()+1;
        String ans ="";
        while(r<=s.length()){
            if(cnt>0){
                if(r==s.length()){
                    break;
                }
                cnts[s.charAt(r)]+=1;
                System.out.println("add '" +s.charAt(r)+"' into window ");
                if(cnts[s.charAt(r)]==0){
                    System.out.println("add '" +s.charAt(r)+"' cnts[s.charAt(r)]==0 ");
                    cnt-=1;
                    System.out.println("cnt-=1 = " + cnt);
                }
                r++;
            }
            else {
                //cnt<=0
                cnts[s.charAt(l)]-=1;
                System.out.println("del '" +s.charAt(l)+"' from window ");

                if(cnts[s.charAt(l)]==-1){
                    System.out.println("del '" +s.charAt(l)+"' cnts[s.charAt(l)]==-1 ");

                    cnt+=1;
                    System.out.println("cnt+=1 = " + cnt);

                }
                l++;
            }
            System.out.println("window = " + s.substring(l,r));
            if(cnt==0&&r-l<ans_len){
                ans_len =r-l;
                System.out.println("r = " + r+" l = "+l+" ans_len = "+ans_len);
                ans = s.substring(l,r);
                System.out.println("ans = " + ans);
            }
        }
        return ans;

    }
}
