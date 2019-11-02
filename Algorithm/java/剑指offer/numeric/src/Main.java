public class Main {
    public static void main(String[] args) {

        StringBuffer sb=new StringBuffer();
        sb.append("1E3");
        char[]chars=sb.toString().toCharArray();
        System.out.println(isNumeric(chars));

    }

    public static boolean isNumeric(char str[]){

        int ecount=0;
        int point=0;
        int index=0;
        if (str == null) {
            return false;
        }
        // 如果首字符是 '+' 或者'-'

        if(str[0]=='+'||str[0]=='-')
            index++;


        for (int i = index; i < str.length; i++) {


            // 判断是否为 '+',-..
            // 如果是 那么因为不是第一个+ -，前面必定为 e 或者 E
            if(str[i]=='+'||str[i]=='-'){
                if(str[i-1]!='e'&&str[i-1]!='E'){
                    return false;
                }
                continue;
            }

            // 判断是否为 e 或 E

            if(str[i]=='e'||str[i]=='E'){
                ecount++;
                if(ecount>1)
                    return false;
                if(str[i-1]<(int)'0'||str[i-1]>(int)'9'||i==0||i==str.length-1){
                    return false;
                }

                point++;
                continue;
            }

            // 判断是否为 .
            if(str[i]=='.'){
                point++;
                if(point>1)
                    return false;
                continue;
            }


            if((str[i]<(int)'0'||str[i]>(int)'9')&&(str[i]!='e'||str[i]!='E'))
                return false;
        }

        return true;
    }
}
