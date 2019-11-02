import com.sun.deploy.util.StringUtils;

import java.util.Arrays;

/**
 * 题目：在二维数组中，每一行从左往右递增，每一列从上往下递增。输入一个数，存在返回true，不存在返回false
 *
 * 解法，从上往下，从右往左找最右上角的数字
 * 如果比查找的数字大，则列数减一
 * 若比查找的数字小，则行数加一
 */

public class FindNumInArray {
    public static void main(String[] args) {
        int a[][]={
                    {1,2,7,8},
                    {3,4,7,9},
                    {4,6,8,10},
                    {7,9,11,16}
                    };

        System.out.println(FindNumInArray(a,16));


    }

    public static boolean FindNumInArray(int array[][],int num){

        // 边界值判定
        if(array!=null&&array.length>0){
            for (int i = 0; i <array.length ; i++) {
                for (int j = array[i].length-1; j >=0; j--) {
                    if(array[i][j]==num){
                        return true;
                    }else if(array[i][j]<num){
                        break;
                    }else {
                        continue;
                    }
                }
            }
        }
        return false;

    }
}
