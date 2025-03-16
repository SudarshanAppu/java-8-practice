package febPratice;


import java.util.*;
import java.util.stream.Collectors;

public class Example {
    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();

        map.put("California", "USA");
        map.put("Florida", "USA");
        map.put("Texas", "USA");
        map.put("Nevada", "USA");
        map.put("Baja California", "Mexico");
        map.put("Oaxaca", "Mexico");
        map.put("Sinaloa", "Mexico");
        map.put("Alberta", "Canada");
        map.put("British Columbia", "Canada");
        map.put("UP", "India");
        map.put("MP", "India");
        map.put("Bihar", "India");
        map.put("Rajasthan", "India");
        map.put("Assam", "India");
//  o/p : India : 5
        map.entrySet().stream().collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.counting()))
                .entrySet().forEach(e->System.out.println(e));

        map.entrySet().stream().map(Map.Entry::getKey).collect(Collectors.groupingBy(e->e.charAt(0), Collectors.joining("_")))
                .entrySet().forEach(System.out::println);


//        var result = map.entrySet().stream().collect(Collectors.groupingBy(Map.Entry::getValue,Collectors.counting()));
//
//        var result2 =map.keySet().stream().collect(Collectors.groupingBy(e->e.charAt(0), Collectors.joining("_")));
//
//        System.out.println(result2);


        List<String> lst = Arrays.asList("prsh10","sud2","pru5","lok1");
        lst.stream().sorted(Comparator.comparing(Example::extractNumber))
                .forEach(e->System.out.println(" "+e+" "));


    }


    public static int extractNumber(String str) {
        String resString = str.replaceAll("\\D+","");

        return  resString.isEmpty()?0:Integer.parseInt(resString);

    }






//    private static int extractNumber(String str) {
//        String num = str.replaceAll("\\D+","");
//        return num.isEmpty() ? 0:Integer.parseInt(num);

//    }



}
