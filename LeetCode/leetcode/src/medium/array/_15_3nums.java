package medium.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


/**
 * 题目：    给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *          注意：答案中不可以包含重复的三元组。
 *
 * 实例：    给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *          满足要求的三元组集合为：
 *          [
 *           [-1, 0, 1],
 *           [-1, -1, 2]
 *          ]
 *
 *
 * 思路：1、将数字从大到小排好序
 *      2、然后设置两个游标(left,right)，只要满足 0-第三个数 == nums[left]-nums[right]，
 *         所以设置 sum=0-第三个数，只要找满足 nums[left]-nums[right] ==sum 即可。
 *      3、一个从左往右找，一个从右往左找
 *      4、如果两数之和大于sun,那么说明要找的数字更小，就把右边的游标往左移
 *          反之，左边的往右移
 */
class _15_3nums {
    
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length <3 || nums == null)
            return new LinkedList();
        Arrays.sort(nums);
        List<List<Integer>> list = new LinkedList<>();
        for(int i=0;i<nums.length-1;i++){
            // 避免添加相同的list
            if(i==0 || (i>0 &&nums[i]!=nums[i-1])){
                int left = i+1,right=nums.length-1,sum = 0-nums[i];
                while(left<right){
                    if(nums[left]+nums[right] == sum){
                        // 添加进列表
                        list.add(Arrays.asList(nums[left],nums[right],nums[i]));
                        // 避免添加相同的list
                        while(left<right && nums[left]==nums[left+1])  left++;
                        while(left<right && nums[right]==nums[right-1])  right--;
                        left++;
                        right--;

                        //说明要找的数更大
                    }else if(nums[left]+nums[right]<sum)
                        left++;
                    else
                        //说明要找的数更小
                        right--;
                }
                
            }
        }
        return list;
        
    }
}