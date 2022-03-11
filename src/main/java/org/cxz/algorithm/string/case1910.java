package org.cxz.algorithm.string;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/11 18:46
 */
public class case1910 {

    // ver1 api
    public String removeOccurrences(String s, String part) {
        StringBuffer sb = new StringBuffer();
        int n = s.length();
        int m = part.length();
        for(int i = 0;i<s.length();i++){
            sb.append(s.charAt(i));
            if(sb.length()>= m){
                int ind = sb.indexOf(part);
                if(ind==-1) continue;
                sb.delete(ind,sb.length());
            }
        }
        return sb.toString();
    }

    // ver1 api 2
    public String removeOccurrences2(String s, String part) {
        int posi = s.indexOf(part);
        while(posi != -1){
            s = s.replaceFirst(part, "");
            posi = s.indexOf(part);
        }
        return s;
    }

    // ver3 kmp
    public String removeOccurrences3(String s, String part) {
        StringBuffer sb = new StringBuffer();
        for(int i =0;i<s.length();i++){
            sb.append(s.charAt(i));
            if(sb.length()>=part.length()){
                int ind = kmp(sb,part);
                //System.out.println("match:ind "+ind);
                if(ind==-1) continue;
                sb.delete(ind,sb.length());
            }
        }
        return sb.toString();
    }

    public int kmp(StringBuffer txt,String pattern){
        int n = txt.length();
        int m = pattern.length();
        int[] next = new int[m];
        getNext(next,pattern);
        for(int i=0,j=-1;i<n;i++){//miss j=-1
            while(j!=-1&&txt.charAt(i)!=pattern.charAt(j+1)) j = next[j];
            if(txt.charAt(i)==pattern.charAt(j+1)) j++;
            if(j==m-1) return i-j;
        }
        return -1;
    }

    public void getNext(int[] next,String p){
        next[0]=-1;
        for(int i=1,j=-1;i<p.length();i++){//miss j=-1
            while(j!=-1&&p.charAt(i)!=p.charAt(j+1)) j = next[j];
            if(p.charAt(i)==p.charAt(j+1)) j++;
            next[i]=j;
        }
    }

}
