public class SelectSort {
    public static void main(String[] args) {
        int[] nums = {5,3,47,7,3,1,6,72,0};
        selectSort(nums);

        for (int i :
                nums) {
            System.out.println(i);

        }

    }



    public static void selectSort(int nums[]){
        if(nums == null || nums.length < 2)
            return;
        for(int i = 1; i < nums.length ; i++){
            for (int j = i-1 ; j >= 0 && nums[j]>nums[j+1] ; j--) {
                swap(nums,j,j+1);
            }
        }

    }

    private static void swap(int[] nums, int i, int j) {
        nums[i] = nums[j] ^ nums[i];
        nums[j] = nums[j] ^ nums[i];
        nums[i] = nums[j] ^ nums[i];
    }
}
