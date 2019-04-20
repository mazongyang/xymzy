package zz.xy.util;

public class WordCase {
    public static String toLowerFirst(String data){
        char[] chars = data.toCharArray() ;
        if (chars[0] >= 65 && chars[0] <= 90){
            chars[0] += 32 ;
        }
        return String.valueOf(chars) ;
    }

    public static String toUpperFirst(String data){
        char[] chars = data.toCharArray() ;
        if (chars[0] >= 97 && chars[0] <= 122){
            chars[0] -= 32 ;
        }
        return String.valueOf(chars) ;
    }
}
