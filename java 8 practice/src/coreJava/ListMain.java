package coreJava;

import java.util.ArrayList;
import java.util.List;

public class ListMain {
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        List<Integer> res = addval(list);
        System.out.println(res);
    }

    private static List<Integer> addval( final List<Integer> list) {

        List<Integer> list1 = new ArrayList<>(list);
        list1.add(4);
//        list = list1;
        list.add(3);
        return list;
    }
}
