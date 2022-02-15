package org.cxz.algorithm.off;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/10/27 21:45
 */
public class offer11 {
    public static void main(String[] args) {

    }

    public int minArray(int[] numbers) {
        if(numbers.length==1){
            return numbers[0];
        }
        int l =0,r=numbers.length-1;
        int mid =0;

        while(r-l>3){
            mid = (r+l)/2;
            if(numbers[mid]<numbers[r]){
                r = mid;
            }
            else if(numbers[mid]>numbers[r]){
                l=mid+1;
            }
            else{
                r-=1;
            }
        }
        int min = numbers[0];
        for(int i=l;i<=r;i++){
            min = Math.min(min,numbers[i]);
        }
        return min;
    }


    public int minArray2(int[] numbers){
        int left =0,right = numbers.length-1;
        int min =Integer.MAX_VALUE;
        if(numbers[right]==numbers[left]) min = numbers[left];
        while(numbers[left]==numbers[right]&&left<right){
            left++;
            right--;
        }
        if(left>=right) return Math.min(min,numbers[left]);

        //num[left]!=num[right]
        //now must num[left]>num[right],
        int mid = 0;
        while(left<right){
            mid = left+(right-left)/2;

            if(numbers[mid]<=numbers[right]){
                right=mid;
            }
            else if(numbers[mid]>numbers[right]){
                left = mid+1;
            }
        }
        //System.out.println("left:"+left);
        return Math.min(min,numbers[left]) ;
    }
}
