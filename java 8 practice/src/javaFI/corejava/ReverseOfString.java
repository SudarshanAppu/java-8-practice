package javaFI.corejava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

class Reverse {
    static String m1(String str){
        String res = "";

        for(int i = 0;i<str.length();i++){
            res = str.charAt(i)+res;
        }

        return res;
    }

    static  String m2(String str){

        byte[] bytes = str.getBytes();
        byte[] res = new byte[str.length()];

        for(int i = str.length()-1 ;i>=0;i--){
            res[i] = bytes[str.length()-i-1];
        }

        return  new String(res);
    }

    static  String m3(String str){


        String res = "";
        for(int i = str.length()-1 ;i>=0;i--){
            res = str.charAt(str.length()-i-1)+res;
        }

        return res;
    }

    static  String m4(String str){

        List<Character> list = new ArrayList<>();

        for(int i =0 ; i< str.length(); i++){
            list.add(str.charAt(i));
        }

//         Collections.reverse(list);
        char[] res = new char[str.length()];


        for(int i = list.size()-1; i >= 0 ; i--)
        {
         res[i]   = list.get(list.size()-i-1);
        }


        return new String(res);
    }

    static  String m5(String str){

        Stack<Character> stack = new Stack<>();

        for(int i =0 ; i< str.length(); i++){
            stack.push(str.charAt(i));
        }

//        Collections.reverse(stack);
        char[] res = new char[str.length()];
        int i = 0;
        while(!stack.isEmpty()){
            res[i] = stack.pop();
            i++;
        }

        return new String(res);
    }

        }
public class ReverseOfString {

    public static void main(String args[]){
        String str = "Sudarshan";
        Reverse reverse = new Reverse();
       System.out.println(Reverse.m1(str));
        System.out.println(Reverse.m2(str));
        System.out.println(Reverse.m3(str));
        System.out.println("m4 :"+Reverse.m4(str));
        System.out.println(Reverse.m5(str));


    }
}
