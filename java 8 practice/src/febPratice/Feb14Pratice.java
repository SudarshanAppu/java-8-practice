package febPratice;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Feb14Pratice {

    //seperate odd and even numbers from list

    public static void main(String [] args) {
        List<Integer> list = new ArrayList<>();

        list = Arrays.asList(3, 5, 6, 8,2,1,6,10);
// even or odd

      var evenodd =  list.stream().collect(Collectors.partitioningBy(e->e%2==0));
//                var even =

                        evenodd.entrySet().stream().filter(Map.Entry::getKey).forEach(e->System.out.println(" even no"+e.getValue()));
                        evenodd.entrySet().stream().filter(e->!e.getKey()).forEach(e->System.out.println("odd no:"+e.getValue()));

    int[] arr  = {2, 6, 1, 6, 7};

      IntStream.rangeClosed(1,arr.length).map(e->arr[arr.length-e]).forEach(System.out::print);
        String str = "sudarshan";

   System.out.println("\nrev of String "+str);


//   Arrays.stream(str.split("")).map(e->str.charAt(str.charAt((str.length())))).forEach(System.out::print);

        StringBuilder stringBuilder = new StringBuilder() ;
  for(int i =str.length()-1;i>=0;i--){
      stringBuilder.append(str.charAt(i));
  }
  System.out.println(stringBuilder);





//


//        Map<Boolean, List<Integer>> res1 = list.stream().collect(Collectors.partitioningBy(e->e%2==0));
//        System.out.println(list.stream().collect(Collectors.partitioningBy(e->e%2==0)));
//
//        System.out.println("even list is"+res1.get(true));
//        System.out.println("even list is"+res1.get(false));

//        Map<Boolean,List<Integer>> map = list.stream().collect(Collectors.partitioningBy(e->e%2==0));
//
//        System.out.println("even list is:"+map.get(true));
//                System.out.println("odd list is:"+map.get(false));


                //reverse of char array

//       System.out.println( list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
//
//       //without using comparator.revereoOrder
//
//
//
//        Object[] arr= list.toArray();
//     Object[] resarr=  IntStream.range(1,arr.length).mapToObj(e->arr[arr.length-e]).toArray();
//
//     System.out.println(Arrays.asList(resarr));
//
//     String str= "sudarshan";
//     StringBuilder revStr = new StringBuilder();
//     Map<Character,Integer> resMap = new HashMap<>();
//     List<Character> charList = new ArrayList<>();
//        for(int i =0;i<str.length();i++){
//         resMap.put(str.charAt(i),resMap.getOrDefault(str.charAt(i),0)+1);
//         charList.add(str.charAt(i));
//
//     }
//     for(Map.Entry<Character,Integer> i : resMap.entrySet()){
//         if(i.getValue()>1){
//             System.out.println(i);
//         }
//
//     }
//     for(int i =str.length()-1;i>=0;i--){
//         revStr.append(str.charAt(i));
//     }
//
//     System.out.println(revStr);
//
//
//     var res = charList.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
//
//     res.entrySet().stream().filter(e->e.getValue()>1).forEach(System.out::println);
//
//        List<Integer> list2 = Arrays.asList(3, 5, 6, 8,2,1,6,10);
//
//     int max =        list2.stream().max(Comparator.naturalOrder()).get();
//
//     int min =list2.stream().min(Comparator.naturalOrder()).get();
//
//   int secondlarge=     list2.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
//
//
//   System.out.println("max:"+max+"min:"+min+" secondlargest"+secondlarge);
//
//
//         Optional<Integer> mx = list2.stream().reduce((a, b)->a>b?a:b);
//         Optional<Integer> mn=list2.stream().reduce((a, b)->a<b?a:b);
//
//        Optional<Integer> sm = list2.stream().reduce((a, b)->a+b);
//
//
//        System.out.println("max:"+mx.get()+"min:"+mn.get()+" sum"+sm.get());
//
//
//        String str3 = "prashantt";
//
//        var strdupres =Arrays.stream(str3.split("")).collect(Collectors.groupingBy(e->e,Collectors.counting()));
//
//        strdupres.entrySet().stream().filter(e->e.getValue()>1).forEach(e->System.out.println(" key "+e.getKey()+" value"+e.getValue()));
//
//       var revers= Arrays.stream(str3.split("")).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
//
//       StringBuilder stringBuilder= new StringBuilder();
//        for(int i=str3.length()-1; i>0;i--){
//            stringBuilder.append(str.charAt(i));
//        }
//
//    System.out.println(
//            stringBuilder);
//

    }

}
