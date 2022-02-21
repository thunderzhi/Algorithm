package org.cxz.algorithm.array;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/2/21 18:10
 */
public class case59 {

    public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        // 控制数组下标
        int i = 0, j = 0;
        //控制边界
        int x = n, y = n;
        // 启动数字
        int num = 1;
        // 每⾏输出的数字个数
        int index = 0;
        //总输出个数
        int count = n * n;
        //输出的⽅向
        int flag = 1;
        while (x != 0 && y != 0) {
            index = y;
            while (index-- != 0) {
                arr[i][j] = num;
                num++;
                j += flag;
            }

            j-= flag;
            i += flag;
            x--;
            if (x == 0) break;
            index = x;
            while (index-- != 0) {
                arr[i][j] = num;
                num++;
                i += flag;
            }
            j-= flag;
            i -= flag;
            y--;
            flag *= -1;
        }
        return arr;
    }
}
