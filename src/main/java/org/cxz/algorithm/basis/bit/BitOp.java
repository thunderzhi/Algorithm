package org.cxz.algorithm.basis.bit;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/5/3 12:02
 */
public class BitOp {
    /*
    Positive :
0 Binary is = 0
1 Binary is = 1
2 Binary is = 10
3 Binary is = 11
4 Binary is = 100
5 Binary is = 101
6 Binary is = 110
7 Binary is = 111
Negetive :
-1 Binary is = 11111111111111111111111111111111
-2 Binary is = 11111111111111111111111111111110
-3 Binary is = 11111111111111111111111111111101
-4 Binary is = 11111111111111111111111111111100
-5 Binary is = 11111111111111111111111111111011
-6 Binary is = 11111111111111111111111111111010
-7 Binary is = 11111111111111111111111111111001
    * */
    public static void main(String[] args) {
//        System.out.println("Positive : ");
//        for (int i = 0; i <8 ; i++) {
//            System.out.println(i+" Binary is = " + Integer.toBinaryString(i));
//        }
//        System.out.println("Negetive : ");
//
//        for (int i = -1; i >-8 ; i--) {
//            System.out.println(i+" Binary is = " + Integer.toBinaryString(i));
//        }

         int a = -1;
        System.out.println("a = " + Integer.toBinaryString(a));
        int  b = new BitOp().updateBit(a,3,false);
        System.out.println("b = " + Integer.toBinaryString(b));
        System.out.println("b = " + b);

    }
    int repeatedArithmeticShift(int x,int n){
        for (int i = 0; i < n; i++) {
            x>>=1;//Arithmetic shift by 1  at the end we'll get 111111
        }
        return x;
    }
    int repeatedLogicalShift(int x,int n){
        for (int i = 0; i < n; i++) {
            x>>>=1;// logical shift by 1  at the end we'll get 00000
        }
        return x;
    }

    boolean getBit(int num,int i){
        return ((num&(1<<i)))!=0;
    }

    int setBit(int num,int i){
        return (num|(1<<i));
    }

    // this op will clear ith bit and leave the remainder unchanged
    int clearBit(int num,int i){
        int mask = ~(1<<i);
        return num&mask;
    }
    //Integer = 1111 ,i =2
    //Integer.toBinaryString() = 11
    // this op will leave last i bits
    int clearBitsMSBhtroughI(int num,int i){
        int mask = (1<<i)-1;
        return num&mask;
    }
//    a = 1111  i=1
//    mask = 11111111111111111111111111111100
//    b = 1100
    //in java this op will clear (i+1) bit
    int clearBitsIthrough0(int num,int i){
        int mask = (-1<<(i+1));
        System.out.println("mask = " + Integer.toBinaryString(mask));
        return num&mask;
    }
//    a = 11111111111111111111111111111111 ,i =3
//    mask = 11111111111111111111111111110111
//    b = 11111111111111111111111111110111
    // this op will set (i+1)bit to 1 or 0
    int updateBit(int num,int i,boolean is1){
        int v = is1?1:0;
        int mask = ~(1<<(i));
        return (num&mask)|(v<<i);
    }
}
