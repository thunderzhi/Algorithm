package org.cxz.algorithm.array;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/3 21:27
 */
public class case744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int ind = find(letters,target);
        //System.out.println("ind :"+ind);
        if(ind==n) return letters[0];
        return letters[ind];
    }

    public int find(char[] arr,char x){
        int l = 0,r = arr.length;
        int mid =0;
        while(l<r){
            mid = l+(r-l)/2;
            if(arr[mid]-x>0){
                r = mid;
            }
            else{
                l = mid+1;
            }
        }
        return l;
    }
}
