/**
 * 题目：找出数组中超过一半的那个数字
 * 思路：从头遍历数组，如果相同，则加一，不同则减一
 *      如果times为零，那么就将下一个数字赋值给他
 */
public class Main {
    public static void main(String[] args) {
        
        int nums[]={1,1,2,2,3,5,6,7,1,1,1,3,1,1,1};
        System.out.println("moreThanHalfNum(nums) = " + moreThanHalfNum(nums));

    }

    public static int moreThanHalfNum(int nums[]){
        if(nums.length==0||nums==null)
            return -100;

        int result=nums[0];
        int times=1;
        for (int i = 1; i < nums.length; i++) {
            if(times==0){
                result=nums[i];
                times=1;

            }
            else if(result==nums[i])
                times++;

            else
                times--;

        }
        if(!isMoreThanHalf(result,nums)){

            return -1000;
        }


        return result;
    }

    private static boolean isMoreThanHalf(int result, int[] nums) {
        int times=0;
        for (int i = 0; i < nums.length; i++) {
            if(result==nums[i])
                times++;
        }
        return times>nums.length/2?true:false;
    }
}
