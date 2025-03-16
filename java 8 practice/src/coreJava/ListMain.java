package coreJava;

import java.util.ArrayList;
import java.util.List;

public class ListMain {
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        list.add(2);
        addval(list);
        System.out.println(list);
    }

    private static void addval( List<Integer> list) {

        List<Integer> list1 = new ArrayList<>();
        list1.add(4);
        list = list1;
        list.add(3);
    }
}
