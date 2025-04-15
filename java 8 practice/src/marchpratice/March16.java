package marchpratice;

import javax.swing.text.html.Option;
import java.awt.desktop.OpenFilesEvent;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class March16 {
    public static void main(String[] args){
        // how to write streams for premetive arrays and nonpremetive or object arrays

        //premetive
        int[] premArr= {1,2,6,8,11,4};

        IntStream stream = Arrays.stream(premArr);
        stream.forEach(System.out::print);

        //non premetives or objects


        Integer[] nonPremArr = {4,3,2,1};
        Arrays.stream(nonPremArr).filter(e->e%2==0).forEach(e->System.out.print(e));
        Stream<Integer> integerStream= Stream.of(nonPremArr);
        integerStream.forEach(System.out::print);

        //filter and map
        System.out.println();
        Stream.of(nonPremArr).filter(e->e%2==0).forEach(System.out::print);
        Arrays.stream(premArr).filter(e->e%2!=0).forEach(System.out::print);
        List<String> list = Arrays.asList("mohan","appu","abhi");


        list.stream().map(String::toUpperCase).forEach(System.out::println);
        String maxelement = list.stream().max(Comparator.comparing(String::length))
                .get();
        System.out.println(" max element "+maxelement);

        //reduce method to find sum , largest and smallest

        int sumarry = Arrays.stream(premArr)
                .sum();
        System.out.println("Sum using sum method"+sumarry);
       int withoutsum= Arrays.stream(premArr)
                .reduce(0, Integer::sum);
        System.out.println("sum of integers without direct sum and using reduce method\n"+withoutsum);

        // min and max with using the min max method

        OptionalInt minelement = Arrays.stream(premArr)
                .min();

        System.out.println("min element witth in function:"+minelement.getAsInt());

        int maxelementq =Arrays.stream(premArr)
                .max().getAsInt();


        System.out.println("the maximum element with max function: "+maxelement);

        //min and max without using min max method - using reduce method

        int maxelement2 =Arrays.stream(premArr)
                .reduce(0,(a,b)->a>b?a:b);

        System.out.println("maximum element witth reduce :"+maxelement2);

        int minelement2 = Arrays.stream(premArr)
                .reduce(0,(a,b)->a<b?a:b);

        System.out.println("min element with reduce :"+minelement2);

        //2nd largest and 3rd largest terminal operation - skip() - limit()


        System.out.println("\n find 3rd largest in an arra :");
        int[] array = Arrays.stream(premArr).sorted().toArray();

//                forEach(e-> System.out.print(e+","));
        for(int i : array){
            System.out.print(i+",");
        }
        System.out.println();
        int largest3rd=IntStream.rangeClosed(1,array.length)
                .map(e->array[array.length-e])
//                .forEach(e-> System.out.print(e+" "));
                .skip(2).findFirst().getAsInt();

        System.out.println(largest3rd);





        System.out.println();
        System.out.println("the 3rd larges is :");

        //2nd largest

       int[] secondsortarr=  Arrays.stream(premArr).sorted().toArray();
        System.out.println(" sorted arra is "+ Arrays.toString(secondsortarr));

       int secondlarge =IntStream.rangeClosed(1,secondsortarr.length)
                       .map(e->secondsortarr[secondsortarr.length-e])
                               .skip(1).findFirst().getAsInt();

        System.out.println("second largest is "+secondlarge);






        //===============================================================================

        //flat map use case

        List<int[]> intList = Arrays.asList(new int[]{2, 3, 4},
                                                    new int[]{3, 2, 3,},
                                                   new int[]{2,3,5,6},
                                                   new int[]{6,8,10});

        //in this intList find the repeated integeres
//        intList





    }
}
