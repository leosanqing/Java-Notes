/**
 * 题目：二进制中1的个数
 *      例如 7的二进制为111，输入7，则返回3
 */


public class Count1InNum {
    public static void main(String[] args) {
        System.out.println("count1InNum(2) = " + count1InNum(7));
        System.out.println("solution(7) = " + solution(7));

        System.out.println(43^33);

    }

    /**
     * 将flag右移，不过需要循环32次
     * @param num
     * @return
     */
    public static int count1InNum(int num){

        int flag=1;

        int count=0;
        while(flag!=0){
            if((num&flag)!=0)
                count++;
            flag=flag<<1;

        }

        return count;
    }


    /**
     * 最优解法
     * 有多少个1就循环多少次
     *
     * 思路：将n与n-1进行与运算
     *      例如 12  1100  与  1011  得到 1000
     *      则刚好将 1100 最右边的1消掉，
     * @param n
     * @return
     */
    public static int solution(int n){
        int count=0;
        while(n!=0){
            count++;
            n=(n-1)&n;
        }
        return count;
    }
}
