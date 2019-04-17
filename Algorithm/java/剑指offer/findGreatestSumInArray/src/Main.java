/**
 * 题目：求数组的连续最大和
 * 思路：如果当前指到的数字加上原来的之后还比现在的数字小，那么舍去之前
 *
 */
public class Main {
    public static void main(String[] args) {

        int nums[]={1,5,-4,-2,5,7,8,3,-1,5};
        System.out.println(findGreatestSumInArray(nums));


    }


    public static int findGreatestSumInArray(int [] nums){
        if (nums == null) {
            return -1;
        }

        //当前和
        int curSum=0;
        //最大和
        int greatestSum=0;
        for (int i = 0; i < nums.length; i++) {
            if(curSum<=0){
                curSum=nums[i];
            }else {
                curSum+=nums[i];
            }
            if(curSum>=greatestSum)
                greatestSum=curSum;
        }
        return greatestSum;
    }



}
