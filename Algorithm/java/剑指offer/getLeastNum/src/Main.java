import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Main main1=new Main();
        int nums[]={1,2,3,5,7,7,3,3,7,8};
        System.out.println("main1.GetLeastNumbers_Solution(nums,5)= " + main1.GetLeastNumbers_Solution(nums,5).toString());
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input == null || k <= 0 || k > input.length) {
            return list;
        }
        int[] kArray = Arrays.copyOfRange(input,0,k);
        // 创建大根堆
        buildHeap(kArray);

        for(int i = k; i < input.length; i++) {
            if(input[i] < kArray[0]) {
                kArray[0] = input[i];
                maxHeap(kArray, 0);
            }
        }

        for (int i = kArray.length - 1; i >= 0; i--) {
            list.add(kArray[i]);
        }

        return list;
    }

    public void buildHeap(int[] input) {
        for (int i = input.length/2 - 1; i >= 0; i--) {
            maxHeap(input,i);
        }
    }

    private void maxHeap(int[] array,int i) {
        int left=2*i+1;
        int right=left+1;
        int largest=0;

        if(left < array.length && array[left] > array[i])
            largest=left;
        else
            largest=i;

        if(right < array.length && array[right] > array[largest])
            largest = right;

        if(largest != i) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            maxHeap(array, largest);
        }
    }

}
