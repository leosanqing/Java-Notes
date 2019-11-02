/**
 * 正则符号匹配
 * .请实现一个函数用来匹配包括’.’和’*‘的正则表达式。模式中的字符’.’表示任意一个字符，而’*‘表示它前面的字符可以出现任意次（包含0次）
 */

public class Main {
    public static void main(String[] args) {

        char str[]={'a','b','b','b'};
        char pattern[]={'a','b','*'};
        System.out.println(match(str,pattern));

    }

    public static boolean match(char str[],char pattern[]){
        if(str==null||pattern==null)
            return false;
        

        // 如果字符串长度为一
        if(str.length==1){
            if(pattern.length==1){
                if(str[0]==pattern[0]||pattern[0]=='.')
                    return true;
                return false;
            }
        }


        return matchCore(str,0,pattern,0);
    }

    private static boolean matchCore(char[] str,int sIndex,char[] pattern,int pIndex) {
        // 如果str和pattern 同时达到末尾,则返回true
        if (sIndex==str.length&&pIndex==pattern.length)
            return true;
        if(sIndex!=str.length&&pIndex==pattern.length)
            return false;

        // 第二个字符是 * 的
        if(pIndex+1<pattern.length&&pattern[pIndex+1]=='*'){
            if(sIndex!=str.length&&pattern[pIndex]==str[sIndex]||
                    sIndex!=str.length&&pattern[pIndex]=='.') {

                return matchCore(str,sIndex+1,pattern,pIndex+2)
                        ||matchCore(str,sIndex,pattern,pIndex+2)
                        ||matchCore(str,sIndex+1,pattern,pIndex);

            } else{
                // 忽略 a*
                return matchCore(str,sIndex,pattern,pIndex+2);
            }
        }

        // 若pattern 第二个字符不是 *
        if(sIndex!=str.length&&pattern[pIndex]==str[sIndex]
            ||sIndex!=str.length&&pattern[pIndex]=='.')
            return matchCore(str,sIndex+1,pattern,pIndex+1);
        return false;
    }
}
