package javaFI.corejava;

import javaFI.java8.StudentDto;
import javaFI.newjava8.StudDB;
import javaFI.newjava8.StudentDemoDto;

import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class  MyComparator implements Comparator<StudentDemoDto>{


    @Override
    public int compare(StudentDemoDto o1, StudentDemoDto o2) {
        return 0;
    }

    @Override
    public Comparator<StudentDemoDto> reversed() {
        return Comparator.super.reversed();
    }
}

public class NewDemo {

    public static void  main(String []args){
        List<StudentDemoDto> list = StudDB.studDB();

        Collections.sort(list, new MyComparator());

        System.out.println(list);

        List<Character> charList = new ArrayList<>();

        String str = "sudarshan";

        char[] charArray = new char[str.length()];

        for(int i = 0 ; i<str.length();i++){
            charList.add(str.charAt(i));
        }

 Collections.reverse(charList);

        System.out.println(charList);

Map<String,Long> map = Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

map.entrySet().stream().filter(s->s.getValue()>=2).forEach(s->System.out.println("["+s.getKey()+"] is present : ["+s.getValue()+"] times"));

     String str2 = str;
          int count;
        for(int i = 0; i<str.length();i++){
            count = 1;
            for(int j= 1;j<str.length();j++){
                if(str.charAt(i)==str2.charAt(j));
                {
                    count++;
                }

            }
            if(count>2){
                System.out.println("character ["+str.charAt(i)+"] is present :["+count+"] times");
            }
        }


//        list.stream().sorted();

String str3 = "appu";
        byte[] bytes = str3.getBytes();
        byte[] res = new byte[str3.length()];

        for(int i = str3.length()-1 ;i>=0;i--){
            res[i] = bytes[str3.length()-i-1];
        }

        System.out.println("string is :"+new String(res));



        String str4 = "mohan";

        char[] result = new char[str4.length()];
        for(int i = str4.length()-1; i>=0;i--){

            System.out.println("i is :"+i+" "+(str4.length()-i-1));
            result[i]=str4.charAt(str4.length()-i-1);
        }
        System.out.println(new String(result));

        byte[] bytes1 = str4.getBytes(StandardCharsets.UTF_8);
        byte[] result2 = new byte[str4.length()];

        for(int i = str4.length()-1; i>=0;i--){
            result2[i] = bytes1[str4.length()-i-1];
        }

        System.out.println(new String(result2));




        System.out.println("comparator");


        List<StudentDemoDto> studentDemoDtos =        StudDB.studDB();
        System.out.println("comparatorm before sorting : "+studentDemoDtos);


        List<StudentDemoDto> sortedList =  studentDemoDtos.stream().sorted(Comparator.comparing(StudentDemoDto::getsName)).collect(Collectors.toList());

        List<StudentDemoDto> descorder = sortedList.stream().sorted((s1,s2)->s2.getsName().compareTo(s1.getsName())).collect(Collectors.toList());
        System.out.println("comparatorm before sorting : "+sortedList);

        System.out.println("comparatorm before sorting in desc: "+descorder);

        List<Integer> intList = new ArrayList<>();

        for(int i=0;i<8;i++){
            intList.add(i);
        }

        Optional<Integer> sH = intList.stream().distinct().sorted((n1, n2)-> n2-n1).skip(1).findFirst();

        System.out.println("the second higesh in ["+intList+"] is :["+sH.get()+"]");


        String rev = "sudarshan";

        char[] revarray = rev.toCharArray();
        Map<Character,Integer> map1 = new HashMap<>();

        for(int i = 0;i<rev.length();i++){
//            int count1 = 0;
//
//            for(int j=1;i<rev.length();j++){
//                if(rev.charAt(i)==rev.charAt(j)){
//                    count1++;
///                    map1.put(charArray[i],count1);
//
//                }
//                revarray[i] = str.charAt(i);
//            }
                map1.put(rev.charAt(i),map1.getOrDefault(rev.charAt(i),0)+1);

                map1.put(rev.charAt(i),map1.getOrDefault(rev.charAt(i),0)+1);
        }

        for(Map.Entry<Character,Integer> i :map1.entrySet()){
            if(i.getValue()>=2){
            }
        }
        System.out.println(map1);

        for(Map.Entry<Character,Integer> i: map1.entrySet()){
            if(i.getValue()>=2){
                System.out.println("["+i.getKey()+", "+i.getValue()+"]");
            }

        }
    }





}
