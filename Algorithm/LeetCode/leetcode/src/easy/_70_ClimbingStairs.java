package easy;

/**
 * 题目：  假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *        每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *        注意：给定 n 是一个正整数。
 *
 * 示例：  输入： 3
 *        输出： 3
 *        解释： 有三种方法可以爬到楼顶。
 *        1.  1 阶 + 1 阶 + 1 阶
 *        2.  1 阶 + 2 阶
 *        3.  2 阶 + 1 阶
 *
 * 思路：  这个可以看成是斐波那契数列的变形
 *        如果转变成这个，那么就很好解决了
 *        可以使用递归，也可以使用其他方法
 */




class _70_ClimbingStairs {

    /**
     * 递归方法
     * @param n
     * @return
     */


    public int climbStairs_recursion(int n){

        if(n <= 1)
            return 1;
        if(n == 2)
            return 2;
        return climbStairs(n-1)+climbStairs(n-2);
    }


    /**
     * 动态方法
     * 画个图就知道了  1 2 3 5 8 13 21
     *              第三个新的数等于前面两个数的和，
     *              第一个数又变成上一步的第二个数
     *              第二个数又变成最新的那个第三个数
     *              我们把他们存储下来，在进行计算就行
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if(n == 0)
            return 0;
        if(n ==1)
            return 1;
        if(n == 2)
            return 2;
        
        int  first =1,second =2,sum =0;
        for(int i=3;i<= n;i++){
            sum = first+second;
            
            first = second;
            second= sum;
        }
        return sum;
    }



}