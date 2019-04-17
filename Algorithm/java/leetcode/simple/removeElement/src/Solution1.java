public class Solution1 {
        public int searchInsert(int[] nums, int target) {
            int left=0,right=nums.length-1;
            while(left<right){
                int mid = (right+left)/2;
                if(nums[mid] == target)
                    return mid;
                if(nums[mid]>target){
                    if(nums[mid-1]<target)
                        return mid-1;
                    right = mid-1;
                }else if(nums[mid]<target){
                    if(nums[mid+1]>target)
                        return mid+1;
                    left = mid+1;
                }
            }
            return 0;
        }

    public static void main(String[] args) {
        int[] a = {1,3,5,6};
        Solution1 solution1 = new Solution1();
        System.out.println( solution1.searchInsert(a,5));

    }
}
