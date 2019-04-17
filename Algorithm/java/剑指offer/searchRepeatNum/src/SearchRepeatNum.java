import java.util.Scanner;



public class SearchRepeatNum {
    public static void main(String[] args) {
        int a[]={2,3,1,4,4,4};

        System.out.println(search(a));

        System.out.println(search2(a));
    }

    /**
     * 寻找数组中重复的数字，返回其中一个
     * 如{1,4,5,7,8,3,2,4,3}
     * 则返回 3或者4 其中一个即可
     * @param nums
     * @return
     */

    public static int search(int nums[]){
        if(nums.length<=2||nums==null){
            return -1;
        }


        for(int i=0;i<nums.length;i++){
            if (nums[i]<0||nums[i]>=nums.length)
                return -1;
        }
        for(int i=0;i<nums.length;i++){
            while(nums[i]!=i){
                int temp;
                if(nums[i]==nums[nums[i]]){
                    return nums[i];
                }

                temp=nums[i];
                nums[i]=nums[nums[i]];
                nums[temp]=temp;

            }
        }

        return -1;
    }


    /**
     * 题目：不修改数组找出重复的数字
     *
     * 在长度为n+1的数组中，
     * @param nums
     * @return
     */

    public static int search2(int nums[]){


        if(nums.length<1)
            return -1;
        int start=1;
        int end=nums.length-1;
        while(start<=end){
            int middle=(end-start>>1)+start;
            int count=countRange(start,middle,nums);

            if(start==end){
                if (count>1)
                    return start;
                break;
            }
            if (count>middle-start+1) {
                end=middle;
            }else {
                start=middle+1;
            }

        }

        return -1;
    }


    public static int countRange(int start,int end,int nums[]){
        int count=0;
        for (int i = 0; i <nums.length  ; i++) {
            if(nums[i]<=end&&nums[i]>=start){
                count++;
            }

        }
        return count;
    }


}
