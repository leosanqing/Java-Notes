import java.util.HashMap;

public class NetherlandFlag {

    public static void main(String[] args) {
        int[] arr = {0,0,1,2,1,2,1,2,0,2,1,2,0,1,2,0,0,2,1,0,2,1,0,2,1,0,2,1,1,2,0,2,1,2,1,0};
        partition(arr,0,arr.length-1,1);
        for(int num : arr){
            System.out.print(num+" ");
        }


    }

    public static void partition(int[] arr,int l,int r,int num){

        int before = l;
        int after = r ;
        int current = l;
        while (current < after){
            if (arr[current] < num){
                swap(arr,before++,current++);
            }
            else if (arr[current] > num){
                swap(arr,after--,current);
            }
            else {
                current++;
            }
        }
    }

    private static void swap(int[] arr, int i, int i1) {
        int temp = arr[i];
        arr[i] = arr[i1];
        arr[i1] = temp;
    }

}