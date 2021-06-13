package org.cxz.algorithm.koj;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/6/13 14:56
 */
public class jcase103 {
    public static void main(String[] args) {


    }

    public class Data{
        public String data;
        public String date;
        public int ind;

        public Data(String data, String date, int ind) {
            this.data = data;
            this.date = date;
            this.ind = ind;
        }
    }

    public Data[] temp;
    public void f103(String[] identi){
        //18
        temp =new Data[identi.length];
        Data[] list = new Data[identi.length];
        for (int i = 0; i < list.length; i++) {
            list[i] =new Data(identi[i],identi[i].substring(6,14),i);
            temp[i] = new Data("","",0);
        }

        merge(list,0,list.length-1);
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i].data);
        }
    }

    public void merge(Data[] arr,int l,int r){
        if(l>=r){
            return;
        }
        int mid=(l+r)>>1;

        merge(arr,l,mid);
        merge(arr,mid+1,r);
        int k = l,p1 = l,p2 = mid+1;
        while (p1<=mid||p2<=r){
            if((p2>r)||(p1<=mid)&&( d1bigOrEquald2(arr[p1],arr[p2]))){
                temp[k++] =arr[p1++];
            }
            else{
                temp[k++] =arr[p2++];
            }
        }
        for (int i = l; i <=r ; i++) {
            arr[i] = temp[i];
        }
    }

    public boolean d1bigOrEquald2(Data d1,Data d2){
        if(d1.date.compareTo(d2.date)>0){
            //d1<=d2
            return true;
        }
        if(d1.date.compareTo(d2.date)==0){
            if(d1.data.compareTo(d2.data)>=0){
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }
}
