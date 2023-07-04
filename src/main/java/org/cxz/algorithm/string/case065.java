package org.cxz.algorithm.string;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/7/4 18:41
 */
public class case065 {
    public boolean isNumber(String s) {
        int opcnt = -1,eidx=-1,dotidx =-1;
        int n = s.length(),cnt =0;
        for(int i = 0;i<n;i++){
            char c = s.charAt(i);
            if(c=='e'||c=='E'){
                if(eidx!=-1)return false;
                eidx = i;
                return Echeck(s.substring(0,i),s.substring(i+1,n));
            }
            else if(c>='0'&&c<='9'){
                cnt++;
            }
        }
        return check(s,false)||check(s,true);
    }

    public boolean Echeck(String a,String b){
        return (check(a,false)||check(a,true))&&check(b,true);
    }

    public boolean check(String s,boolean isint){
        if(s.equals("")) return false;
        int numcnt = 0, opidx = -1,dotidx=-1;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isLetter(c)) return false;
            if(c=='+'||c=='-'){
                if(opidx!=-1)return false;
                opidx = i;
                continue;
            }
            else if(c=='.'){
                if(isint||dotidx!=-1) return false;
                dotidx = i;
                continue;
            }
            numcnt++;
        }
        if(!isint&&dotidx==-1) return false;
        if(opidx>0) return false;
        return numcnt>0;
    }
    // is pure decimal maybe include +_
    public boolean isDecimal(String s){
        if(s.equals("")||!s.contains(".")){
            return false;
        }
        int numcnt = 0, opidx = -1,dotidx=-1;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isLetter(c)) return false;
            if(c=='+'||c=='-'){
                if(opidx!=-1)return false;
                opidx = i;
                continue;
            }
            else if(c=='.'){
                if(dotidx!=-1)return false;
                dotidx = i;
                continue;
            }
            numcnt++;
        }
        if(opidx>0||numcnt==0) return false;
        return true;
    }
    // is pure int maybe include +_
    public boolean isInt(String s){
        if(s.equals("")||s.contains(".")){
            return false;
        }
        int numcnt = 0, opidx = -1;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isLetter(c)) return false;
            if(c=='+'||c=='-'){
                if(opidx!=-1)return false;
                opidx = i;
                continue;
            }
            numcnt++;
        }
        if(opidx>0) return false;
        return numcnt>0;
    }
}
