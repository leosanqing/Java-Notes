/**
 * 题目：在一个旋转数组中，找出最小数
 *
 * 思想：使用二分查找。
 *      设置两个边界指针，一个指向开头，一个指向尾部
 *      如果中间的数字大于左边指针指的数，则将左边的指针替换成中间的
 *      否则替换成右边的
 *
 *      极限数字{1,1,1,1,0,1,1,1,1}
 */
public class Main {
    public static void main(String[] args) {
        int a[]={1,1,1,1,1,1,0,1,1,1,1};
        int b[]={4,5,6,78,79,1,2,3};
        System.out.println("searchMinInTwistArray(a) = " + searchMinInTwistArray(b));

    }



    public static int searchMinInTwistArray(int num[]){
        int start=0;
        int end=num.length-1;
        int middle=0;


        while(num[start]>=num[end]){
            if(end-start==1){
                return num[end];
            }

            middle=((end-start)>>1)+start;


            if(num[start]==num[end] && num[start]==num[middle]){
                return searchMin(num,start,end);
            }
            if(num[start]<=num[middle]){
                start=middle;
            }
            else if(num[start]>num[middle]){
                end=middle;
            }
        }

        return num[middle];
    }

    public static int searchMin(int num[],int start,int end){
        int min=num[start];
        while(start<end){
            start++;
            if(num[start]<min){
                min=num[start];
            }
        }


        return min;
    }
}
