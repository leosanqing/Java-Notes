/**
 * 题目：剪绳子
 *      将一个N长的绳子剪成M段,(N,M均大于0)
 *      计算每段相乘的最大数
 */



public class CutString {
    public static void main(String[] args) {

        System.out.println("cutString(6) = " + cutString(6));
        System.out.println("cutStringGreedy(6) = " + cutStringGreedy(6));

    }

    /**
     * 动态规划解法
     * @param length
     * @return
     */
    public static int cutString(int length){

        if(length==0)
            return 0;
        else if(length==1)
            return 1;
        else if (length==2)
            return 1;
        else if(length==3)
            return 2;


        int l[]=new int[length+1];
        l[0]=0;
        l[1]=1;
        l[2]=2;
        l[3]=3;

        int max =0;
        for (int i = 4; i < length+1; i++) {
            for (int j = 1; j <= i/2; j++) {

                int a=l[j]*l[i-j];
                if(max<a)
                    max=a;
            }
            l[i]=max;

        }
        

        return max;
    }


    /**
     * 贪心算法
     *
     * 大于4之后，尽可能切割出3
     *
     * @param length
     * @return
     */

    public static int cutStringGreedy(int length){
        if (length==0)
            return 0;
        else if (length==1)
            return 1;
        int times3=length/3;
        if(length/3==1){
            times3-=1;
        }
        int times2=(length-times3*3)/2;

        return (int)Math.pow(3,times3)*(int)Math.pow(2,times2);
    }
}
