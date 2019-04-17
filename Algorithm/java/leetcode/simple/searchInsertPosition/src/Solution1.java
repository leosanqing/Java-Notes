public class Solution1 {
        public int searchInsert(int[] nums, int target) {
            int left=0,right=nums.length-1, mid=0;
            while(left<right){
                 mid = (right+left)/2;
                 if(nums[right]<target)
                     return right+1;
                 if(nums[left]>target)
                     return (left-1)<0?0:left-1;

                if(nums[mid] == target)
                    return mid;


                if(nums[mid]>target){
                    if(nums[mid-1]<target)
                        return mid;
                    right = mid-1;
                }else if(nums[mid]<target){

                    if(nums[mid+1]>target)
                        return mid+1;
                    left = mid+1;
                }
            }
            return mid+1;
        }

    public static void main(String[] args) {
        int[] a = {1,3,5,7};
        Solution1 solution1 = new Solution1();
        System.out.println( solution1.searchInsert(a,6));

    }
}
