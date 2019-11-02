/**
 * 题目：给一个整形数组，排列输出最小的数，
 *      比如 给{3，32，321}，输出 321323
 *
 * 思路：两次for循环，挨个比
 *      因为 3 和32 组合之后长度一样，所以直接使用字符串的比较即可
 *      然后交换两个的位置，最后输出即可
 */

public class Main {
    public static void main(String[] args) {
        int a[] = {3,32,321,1,55};

        System.out.println("printMinNumber(a) = " + printMinNumber(a));
    }

    public static StringBuilder printMinNumber(int nums[]){

        StringBuilder stringBuilder = new StringBuilder();
        if (nums == null) {
            return null;
        }
        if(nums.length==1)
            return stringBuilder.append(nums[0]);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                String a = nums[i]+""+nums[j];
                String b = nums[j]+""+nums[i];
                if(a.compareTo(b)>0){
                    swap(i,j,nums);
                }
            }

        }


        for (int j = 0; j < nums.length; j++) {
            stringBuilder.append(nums[j]);
        }
        return stringBuilder;
    }

    private static void swap(int i, int j, int[] nums) {
        int temp=nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

    }
}
