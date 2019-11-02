public class Main {
    public static int getTranslationCount(int number){
        if(number<0)
            return 0;

        return getTranslationCount(Integer.toString(number));
    }
    //动态规划，从右到左计算。
    //f(r-2) = f(r-1)+g(r-2,r-1)*f(r);
    //如果r-2，r-1能够翻译成字符，则g(r-2,r-1)=1，否则为0
    public static int getTranslationCount(String number) {
        int f1 = 1,f2 = 1,g;
        int temp;
        for(int i=number.length()-2;i>=0;i--){
            if((Integer.parseInt(number.charAt(i)+""+number.charAt(i+1))<26)
                    && (Integer.parseInt(number.charAt(i)+""+number.charAt(i+1))>=10))
                g = 1;
            else
                g = 0;
            temp = f2;
            f2 = f2+g*f1;
            f1 = temp;
        }
        return f2;
    }
    public static void main(String[] args){
        System.out.println(getTranslationCount(-10));  //0
        System.out.println(getTranslationCount(11));  //2
        System.out.println(getTranslationCount(100));  //3
        System.out.println(getTranslationCount(1234));  //3
        System.out.println(getTranslationCount(12258)); //5
        System.out.println(getTranslationCount(12222)); //8
    }
}
