package easy.array;

/**
 * description: 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 *              不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *              元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * example:     给定 nums = [3,2,2,3], val = 3,
 *              函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 *              你不需要考虑数组中超出新长度后面的元素。
 *
 * 思路：        因为他是返回数组的长度，以此来打印出所有val的数字
 *              也就是说我们数组从0到那个长度之间，不会再出现val相等的数字
 *              所以，我们设置一个从0开始的数字i，然后遍历数组，
 *              每当遇到一个不等于 val的值，我们就用它来覆盖数组的值
 *              然后i++；
 */


public class _27_removeElement {
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
        _27_removeElement a27removeElement = new _27_removeElement();
        int a[]={1,2,5,3,2,1,4,5,3,5};
        a27removeElement.removeElement(a,2);
    }
}