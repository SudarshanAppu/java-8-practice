package javaFI.java8programs;


import javax.swing.text.html.parser.Entity;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Programs{
    public static void countOfCharOccurance(String str){

Map<String, Long> map =        Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
     System.out.println("number of occurance of chars in string :"+map);

    }

    public static void duplicateChars(String str){

        Map<String, Long> result1 = Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        result1.entrySet().stream().filter(s->s.getValue()>1).forEach(s->System.out.println(" duplicate char is ["+s.getKey()+"] and cound is["+s.getValue()+"]"));


Stream<Map.Entry<String, Long>> result = Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(s->s.getValue()>1);

        //.map(Map.Entry::getKey).collect(Collectors.toList());

//System.out.println("Duplicate chars is :"

//        result.map(s->s).forEach(s->System.out.print("dup char is :["+s.getKey()+"] and count is["+s.getValue()+"]\n"));


//        +" count is :"+result.map(s->s.getValue()));

    }

    public static void duplicatecharswithoutJava8(String str1){
String
        str = "aabbcc";
        Map<Character , Integer > map1  = new HashMap<>();
        for(int i = 0; i < str.length();i++){
            int count =0;

            for(int j = i;j<str.length() ; j++){
                if(str.charAt(i)==str.charAt(j)&&str.charAt(i)!=' '){
                    count++;
                    map1.put(str.charAt(i),count);
                }
            }
            if(count>1&&str.charAt(i)!=' '){
                System.out.println("char ["+str.charAt(i)+"] is occurred ["+count+"]times in string");
            }
        }

        System.out.println(map1);

    }
}


public class Java8Programs {
    public static void main(String []args){

        Programs.countOfCharOccurance("Sudarshanappu");

        Programs.duplicateChars("SudarshanApppuBoss");

        Programs.duplicatecharswithoutJava8("ab c     abc abcc b     a");
    }
}
