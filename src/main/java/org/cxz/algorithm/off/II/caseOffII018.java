package org.cxz.algorithm.off.II;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/24 16:26
 */
public class caseOffII018 {

    //ver 1
    public boolean isPalindrome1(String s) {
        int n = s.length();
        if(n==0) return true;
        int l =0, r=n-1;
        while(l<r){
            while(l<r&&!isvalid(s.charAt(l))){l++;}
            while(l<r&&!isvalid(s.charAt(r))){r--;}
            if(l>=r) return true;
            if(!compare(s.charAt(l),s.charAt(r))){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public boolean compare(char a, char b){
        if(isdigit(a)&&isdigit(b)){// all num
            return a==b;
        }
        if(!isdigit(a)&&!isdigit(b)){// all alpha
            return toLower(a)==toLower(b);
        }
        return false;
    }

    public boolean isvalid(char c){
        if('0'<=c&&c<='9') return true;
        if('a'<=c&&c<='z') return true;
        if('A'<=c&&c<='Z') return true;
        return false;
    }

    public boolean isdigit(char c){
        if('0'<=c&&c<='9') return true;
        return false;
    }

    public char toLower(char c){
        if(c>='A'&&c<='Z'){
            c += 'a'-'A';
        }
        return c;
    }

    //ver2
    public boolean isPalindrome2(String s) {
        char[] arr = s.toCharArray();
        int n = s.length();
        if(n==0) return true;
        int l =0, r=n-1;
        while(l<r){
            while(l<r&&!isvalid(arr,l)){l++;}
            while(l<r&&!isvalid(arr,r)){r--;}
            if(l>=r) return true;
            if(arr[l]!=arr[r]){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    public boolean isvalid(char[] arr,int i){
        char c = arr[i];
        if('0'<=c&&c<='9') return true;
        if('a'<=c&&c<='z') return true;
        if('A'<=c&&c<='Z'){
            arr[i] +='a'-'A';
            return true;
        }
        return false;
    }
}
