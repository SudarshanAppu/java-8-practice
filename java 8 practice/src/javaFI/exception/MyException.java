package javaFI.exception;

public class MyException extends Exception {

    MyException(String message) {
        super(message);
    }

    public static void main(String[] args) throws MyException {
        try {
            int i = 0;
            int b = 10 / 0;
        } catch (Exception e) {
            throw new MyException(" Arithmatic excpetion in java ");
        }

    }
}


