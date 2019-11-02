/**
 * 题目： 输入一个数字，写出从1到这个数字中，1出现的个数
 *       比如输入 11，那么出现 1的数字有  1，10，11，  1出现的个数为4
 *
 *
 * 思路：递归的找数字，当前位为0，那么1出现的次数仅受他高位影响，
 *      如果当前位为1，那么受到高位以及低位的影响
 *      如果当前位大于 1 ，那么受到高位的影响
 */

public class Main {
    public static void main(String[] args) {
        System.out.println(CountOne2(21));
    }
    public static long CountOne2(long n) {
        long  before=0,after=0,current=0;
        long count=0;
        long i=1;

        while (n/(i)!=0){
            before = n/(i * 10); // 高位
            current = (n/i) % 10; // 当前位
            after = n - (n/i) * i; //低位

            // 如果当前位为0，那么仅受 最高位影响
            if(count==0)
                count=current+before * i;
            // 如果当前位为1，那受最高位和低位的影响
            else if (count == 1) {
                count = count + before * i + after + 1;
            }

            // 如果当前位大于 1，那么受最高位的影响
            else if(count > 1)
                count = count + (before+1)*i;

            i = i*10;


        }

       return count;
    }
}
