package org.cxz.algorithm.dynamic;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/5/30 16:10
 */
public class case470 {
    public static void main(String[] args) {

    }
    public int rand10() {

        while (true){
            int num =0;
            num = (rand7()-1)*7+rand7();//rand49
            if (num<=40){
                return num%10+1;
            }
            num = (num-40-1)*7+rand7();//rand63
            if (num<=60){
                return num%10+1;
            }
            num = (num-60-1)*7+rand7();//rand 21
            if (num<=20){
                return num%10+1;
            }
        }
    }

    public int rand7() {
        return 0;
    }
}
