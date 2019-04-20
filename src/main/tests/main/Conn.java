package main;

public class Conn {
    public static void main(String[] args) {
        char[] c = new char[]{'c','h','a','r'} ;
        if (c[0] >= 97 && c[0] <= 122){
            c[0] -= 32 ;
        }
        System.out.println(String.valueOf(c));
    }


}
