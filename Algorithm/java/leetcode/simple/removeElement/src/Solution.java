class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int a[]={1,2,5,3,2,1,4,5,3,5};
        solution.removeElement(a,2);
    }
}