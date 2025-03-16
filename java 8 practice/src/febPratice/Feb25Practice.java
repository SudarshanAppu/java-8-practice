package febPratice;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Feb25Practice {

    public static  void main(String [] args) {

        Integer[] arr = {1, 20, 3, 40, 2, 3};
        Integer[] arr2 = {1, 2, 5, 1, 4, 10, 3};

        //compare and add same elements from arrays

       List<Integer> arrlst=        Arrays.stream(arr).collect(Collectors.toList());

       Arrays.stream(arr2).filter(arrlst::contains).distinct().forEach(e->System.out.print(","+e));

      var res= IntStream.rangeClosed(1,arr.length).map(e->arr[arr.length-e]).toArray();
      System.out.println("\n reverse of an array");
           Arrays.stream(res).forEach(System.out::print);

//        Set<Integer> setarr = Arrays.stream(arr).collect(Collectors.toSet());
//
//        var result = Arrays.stream(arr2).filter(setarr::contains).distinct().collect(Collectors.toList());
//
//         System.out.println(result);
//  Arrays.stream(arr2).sorted(Comparator.reverseOrder()).forEach(System.out::print)
//
//  ;
//        IntStream.rangeClosed(1,arr2.length).map(i->arr2[arr2.length-i]).forEach(System.out::print);



//        Set<Integer> collect = Arrays.stream(arr).collect(Collectors.toSet());
//
//      var collect1 =  Arrays.stream(arr2).filter(collect::contains).distinct().collect(Collectors.toList());
//
//        System.out.println(collect1);

//        //reverser of an array
//
//    var res=        IntStream.range(1,arr.length).map(i->arr[arr.length-i]).toArray();
//
//    Arrays.stream(res).forEach(System.out::print);
//    IntStream.rangeClosed(1,arr.length).map(i->arr[arr.length-i]).forEach(System.out::print);
//
        String str = "abcdbcacbacababc";

//        Map<String,Integer> map = new HashMap<>();
//
//        for(int i =0;i<str.length()-3;i++){
//            String substring = str.substring(i,i+3);
//            if(substring.matches("[abc]+") && repeated(substring)){
//                map.put(substring,map.getOrDefault(substring,0)+1);
//            }
//        }
//        map.entrySet().forEach(System.out::println);


//

        System.out.println("\n\n");
        Map<String,Integer> substringmap = new HashMap<>();

        for(int i =0; i<=str.length()-3;i++){
            String substring = str.substring(i,i+3);
            if(substring.matches("[abc]+") &&
                    (repeated(substring))) {
                substringmap.put(substring, substringmap.getOrDefault(substring, 0) + 1);
            }
        }

        substringmap.entrySet().forEach(System.out::println);

//




    }
    public static boolean repeated(String str){
        return (str.charAt(0)!=str.charAt(1) && str.charAt(0)!=str.charAt(2) && str.charAt(1)!=str.charAt(2));
    }

}
