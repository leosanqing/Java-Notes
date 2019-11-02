import java.util.ArrayList;
import java.util.TreeSet;

/**
 * 题目：打印字符串的全排列
 * 输入： "ABC"
 * 输出： ABC ACB BAC BCA CAB CBA
 *
 * 思路：依次交换第一个和后面的字符串，后面字符串全排列
 *
 */
public class Main {
    public static void main(String[] args) {
        String str="abca";
        System.out.println(Permutation(str));

    }

    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<String>() ;
        if(str == null || str.length() == 0)
            return result;
        char[] chars = str.toCharArray() ;
        TreeSet<String> temp = new TreeSet<>() ;
        Permutation(chars, 0, temp);
        result.addAll(temp) ;
        return result ;
    }

    public static void Permutation(char[] chars, int index, TreeSet<String> result) {
        if(chars == null || chars.length == 0 )
            return ;
        if (index < 0 || index > chars.length - 1)
            return;
        if(index == chars.length-1) {
            result.add(String.valueOf(chars)) ;
        }else {
            for(int i=index ; i<=chars.length-1 ; i++) {
                swap(chars, index, i) ;
                Permutation(chars, index+1, result);
                // 回退
                swap(chars, index, i) ;
            }
        }
    }

    public static void swap(char[] c, int a,int b) {
        char temp = c[a];
        c[a] = c[b];
        c[b] = temp;
    }


    public static void permutation(char[] chars,int index,TreeSet<String> set){
        if(chars == null || chars.length == 0)
            return;
        if(index<0 || index > chars.length-1)
            return;
        if( index == chars.length-1)
            set.add((String.valueOf(chars)));
        else{
            for (int i=index;i<chars.length;i++){
                swap(chars,index,i);
                permutation(chars,index+1,set);
                swap(chars,index,i);
            }
        }
    }

}
