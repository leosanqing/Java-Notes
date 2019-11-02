public class StringTest {
    public static void main(String[] args) {
        String str5=new String("abc");
        String str1="abc";
        String str2="abc";
        String str3="abcd";
        String str4="d";


        String str6=new String("abc");

        System.out.println("str1==str2 = " + str1==str2);
        System.out.println("(str1+str4)==str3 = " + (str1+str4)==str3);
        System.out.println("str1==str5 = " + str1 == str5);
        System.out.println("str5==str6 = " + str5==str6);
    }
}
