import java.util.Stack;

/**
 * 题目：按照顺时针打印矩阵
 */

public class Main {
    public static void main(String[] args) {

        int nums[][]={
                        {1,2,3,4,5,6,7,8,9},
                        {10,11,12,13,14,15,16,17,18},
                        {19,20,21,22,23,24,25,26,27},
                        {28,29,30,31,32,33,34,35,36}
                    };


        cycleCount(nums);
    }

    public static void cycleCount(int num[][]){
        if(num==null||num.length==0||num[0].length==0)
            return;
        int start=0;

        while (start*2<num.length&&start*2<num[0].length){
            printMatrixInCircle( num,num[0].length,num.length,start);
            start++;

        }
    }

    private static void printMatrixInCircle(int[][] num, int column, int row,int start) {
        int endX=column-start-1;
        int endY=row-start-1;

        //从左到右
        for(int i=start;i<=endX;i++){
            int elem=num[start][i];
            System.out.print(elem+"\t");
        }

        //从上到下
        for(int i=start+1;i<=endY;i++){
            int elem=num[i][endX];
            System.out.print(elem+"\t");
        }
        // 从右到左
        for(int i=endX-1;i>=start;i--){
            int elem=num[endY][i];
            System.out.print(elem+"\t");
        }

        // 从下到上
        for(int i=endY-1;i>=start+1;i--){
            int elem=num[i][start];
            System.out.print(elem+"\t");
        }
        System.out.println();

    }


}
