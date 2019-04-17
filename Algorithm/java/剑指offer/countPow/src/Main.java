/**
 * 计算一个数的乘方
 */

public class Main {

    public static void main(String[] args) {
        System.out.println(solution(3,3));

    }


    public static int solution(int base,int exponent){

        int result=0;
        if(exponent==0)
            return 1;
        if (exponent==1)
            return base;

        result=solution(base,exponent>>1);
        result*=result;
        if(exponent%2==1){
            result*=base;
        }
        return result;
    }
}
