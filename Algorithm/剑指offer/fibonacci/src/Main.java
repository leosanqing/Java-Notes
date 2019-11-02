public class Main {

    public static void main(String[] args) {
        System.out.println("fib(50),(String)fib1(50) = " + fib(10)+"fib1 = "+fib1(10));
        System.out.println(fib(10)==fib1(10));
    }




    public static long fib1(int n){
        if(n<=0)
            return 0;
        if (n==1)
            return 1;
        return fib1(n-1)+fib1(n-2);
    }

    public static long fib(int n){
        int result[]={0,1};
        if(n<2){
            return result[n];
        }


        long fibN=0;
        long fibOne=1;
        long fibTwo=0;

        for (int i = 2; i <=n; ++i) {
            fibN=fibOne+fibTwo;
            fibTwo=fibOne;
            fibOne=fibN;

        }
        return fibN;
    }
}
