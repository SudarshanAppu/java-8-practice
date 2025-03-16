package taxpayersexample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class JavaDemo {
    public String reverStringUsingChar(String str) {
        String str2 = "";
        char ch;
        for (int i = 0; i < str.length(); i++) {
            ch=str.charAt(i);
            str2=ch+str2;

        }
        return str2;
    }


    public  String reversStringusingcharArray(String str){
        byte[] charArray = str.getBytes();
        byte[] result = new byte[str.length()];

        for(int i = 0 ;i<str.length();i++){
            result[i]= charArray[str.length()-i-1];
        }

        return new String(result);
    }
    public  String reversStringusingcharArrays(String str){
        byte[] charArray = str.getBytes();
        char[] result = new char[str.length()];



//        int j=0;
//        for(int i = str.length()-1 ;i>=0;i--){
//            result[j]= str.charAt(i);
//            j++;
//        }


        for(int i = 0; i < str.length();i++){
            result[i]=str.charAt(str.length()-i-1);
        }
        return new String(result);
    }

    public  String reversStringusingcharCollection(String str){

        List<Character> list = new ArrayList<>();

        for(int i = 0;i<str.length();i++){
            list.add(str.charAt(i));
        }
        Collections.reverse(list);

        return list.toString();
    }


    public  String reversStringusingcharStack(String str){

        Stack<Character> list = new Stack<>();

        for(int i = 0;i<str.length();i++){
            list.push(str.charAt(i));
        }
//        Collections.reverse(list);
        char[] str2 = new char[str.length()];
        int i=0;
        while(!list.isEmpty()){
            str2[i]=list.pop();
            i++;
        }

        return new String(str2);
    }







    public static void main(String[] args) {

        JavaDemo j = new JavaDemo();

        String str = "Sudarshan";

        System.out.println("Reverse of a String :"+j.reverStringUsingChar(str));

        System.out.println(("reverse of string using byte type array: "+j.reversStringusingcharArray(str)));
        System.out.println(("reverse of string using byte type array: "+j.reversStringusingcharArrays(str)));

        System.out.println("reverse of string using byte type array: "+j.reversStringusingcharCollection(str));

        System.out.println("reverse of string using byte type array: "+j.reversStringusingcharStack(str));
    }
}
