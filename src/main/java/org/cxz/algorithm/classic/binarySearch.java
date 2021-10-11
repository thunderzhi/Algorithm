package org.cxz.algorithm.classic;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/10/11 14:37
 */
public class binarySearch {

    public static void main(String[] args) {

    }
    //classic BS
    public int classicBS(int[] arr,int x){
        int head = 0;
        int tail = arr.length-1;
        while(head<tail){
            int mid = head+(tail-head)/2;
            if(arr[mid] ==x){
                return mid;
            }
            else if(arr[mid]>x){
                tail = mid-1;
            }
            else{
                head = mid+1;
            }
        }
        return head;
    }

    //improve bs  binary first ,then liner search
    public int classicBS_improve(int[] arr,int x){
        int head = 0;
        int tail = arr.length-1;
        while(tail-head>3){
            int mid = head+(tail-head)/2;
            if(arr[mid] ==x){
                return mid;
            }
            else if(arr[mid]>x){
                tail = mid-1;
            }
            else{
                head = mid+1;
            }
        }
        for (int i = head; i <= tail; i++) {
            if(arr[i]!=x){
                continue;
            }
            return i;
        }
        return -1;
    }




}
