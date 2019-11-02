public class Main {
    public static void main(String[] args) {
        solution(2);

    }
    public static void solution(int n){
        if(n<=0)
            return ;
        char num[]=new char[n];

        for (int i = 0; i < 10 ; i++) {
            num[0]=(char)('0'+i);
            print1ToMaxNumRecursively(num,n,0);

        }
    }

    private static void print1ToMaxNumRecursively(char[] num, int n, int index) {
        if(index==n-1){
            printNum(num);
            return;
        }
        for (int i = 0; i < 10; i++) {
            num[index+1]=(char)(i+'0');
            print1ToMaxNumRecursively(num,n,index+1);
        }
    }

    private static void printNum(char[] num) {
        boolean isBegin0=true;
        for (int i = 0; i < num.length; i++) {
            if(isBegin0&&num[i]!='0'){
                isBegin0=false;
            }
            if(!isBegin0)
                System.out.print(num[i]);
        }
        System.out.print("\t\t");
    }
}
