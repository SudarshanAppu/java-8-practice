package javaFI.newjava8;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class JavaStringReverse {

    public static String STRreverse1(String str){

        String str2 = "";
        for(int i = 0 ; i<str.length();i++)
        {
            str2 = str.charAt(i)+str2;
        }

        return str2;
    }

    public  static String STRreverse2(String str){
        byte[] result = new byte[str.length()];
        byte[] bytesString = str.getBytes();

        for(int i = 0; i <str.length();i++){
            result[i]=bytesString[str.length()-i-1];
        }

        return new String(result);

    }

    public static String STRreverse3(String str){
        char[] arr1 = str.toCharArray();

        char[] result = new char[str.length()];
        String result2 ="";
                for(int i = str.length()-1;i>=0;i--){
                    result2=result2+arr1[i];
                }

                return result2;

    }

    public  static  String STRreverse4(String str){
        char[] dataarray = str.toCharArray();
        char[] resultArray = new char[str.length()];

        for(int i = 0;i<str.length();i++){
            resultArray[i]=dataarray[str.length()-i-1];

        }

        return new String(resultArray);
    }

    public static  String STRreverse5(String str){
        List<Character> list = new ArrayList<>();

        for(int i = 0 ;i<str.length();i++){
            list.add(str.charAt(i));
        }
        Collections.reverse(list);

        return list.toString();

    }

    public static String STRreverse6(String str){
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i <str.length();i++){
            stack.push(str.charAt(i));
        }

        Stack<Character>  stack1 = new Stack<>();
        while(!stack.isEmpty()){
        stack1.push(stack.pop());}

        return stack1.toString();
    }

    public static String STRreverse7(String str){
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i <str.length();i++){
            stack.push(str.charAt(i));
        }

//        Stack<Character>  stack1 = new Stack<>();
        char[] stack1 = new char[str.length()];
        int i = 0;
        while(!stack.isEmpty()){
            stack1[i]=stack.pop();
        i++;
        }

        return new String(stack1);
    }

    public static void main(String args[]){

        String str= "Sudarshan";
        System.out.println("Reverse Of a String with storing in another approach is :"+JavaStringReverse.STRreverse1(str));
        System.out.println("Reverse Of a String with byte codes in another approach is :"+JavaStringReverse.STRreverse2(str));
        System.out.println("Reverse Of a String with char array in another approach is :"+JavaStringReverse.STRreverse3(str));
        System.out.println("Reverse Of a String with 2 char array in another approach is :"+JavaStringReverse.STRreverse4(str));
        System.out.println("Reverse Of a String with list and collection  in another approach is :"+JavaStringReverse.STRreverse5(str));
        System.out.println("Reverse Of a String with stack and stack  in another approach is :"+JavaStringReverse.STRreverse6(str));
        System.out.println("Reverse Of a String with stack and char array  in another approach is :"+JavaStringReverse.STRreverse7(str));



    }

}
