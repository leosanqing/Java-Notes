package easy.array;

/**描述：
 *     Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *     给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：
 *     你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 *
 * 思路：使用异或运算：
 *      异或运算有三个特征：
 *      1、0 ^ 任何数都为 那个数   0^a = a；
 *      2、两个相同的数异或结果为 0 a^a = 0;
 *      3、异或具有交换律  a^b^c = a^c^b
 *
 */
public class _136_singleNum {
    public static void main(String[] args) {
        int[] nums = {4,2,1,2,1};
        System.out.println("singleNum(nums) = " + singleNum(nums));

    }

    public static int singleNum(int[] nums){
        int result = 0;
        for (int num :
                nums) {
            result ^=num;
        }
        return result;
    }
}
