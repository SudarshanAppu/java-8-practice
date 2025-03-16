package javaFI.exception;

import java.util.Arrays;

public class MyRuntimeException extends RuntimeException{
    MyRuntimeException(String message){
        super(message);
    }
    public static String exception(String message){

        return message;
    }

    public  static void main(String [] args){
        try{
            int b = 10/0;

        }catch (Exception e){
             System.out.println( MyRuntimeException.exception(" ARithmatic exception by run time exceptioin"+ Arrays.toString(e.getStackTrace())));
        }
    }
}
