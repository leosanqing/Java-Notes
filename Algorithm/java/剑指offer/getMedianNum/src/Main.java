import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    int count = 0;
    public static void main(String[] args) {
        Main main1 = new Main();
        main1.Insert(1);
        main1.Insert(2);
        main1.Insert(5);
        main1.Insert(6);
        main1.Insert(9);
        main1.Insert(7);
        //main1.Insert(10);
        main1.Insert(15);
        System.out.println("main1.GetMedian() = " + main1.GetMedian());
    }
    
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(16, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });

    public void Insert(Integer num) {
        count++;
        // 当数据的个数为奇数时，进入大根堆
        if ((count & 1) == 1) {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        } else {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }
    }

    public Double GetMedian() {
        if (count == 0)
            return null;

        // 当数据个数是奇数时，中位数就是大根堆的顶点
        if ((count & 1) == 1) {
            return Double.valueOf(maxHeap.peek());
        } else {
            return Double.valueOf((minHeap.peek() + maxHeap.peek())) / 2;
        }
    }
}
