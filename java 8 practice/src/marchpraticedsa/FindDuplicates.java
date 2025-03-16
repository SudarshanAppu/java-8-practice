package marchpraticedsa;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindDuplicates {
    public static void main(String[] args) {

        Integer[] arr = { 1, 6, 5, 2, 3, 3, 2 };
        List<Integer> duplicates = findDuplicates(arr);

        Arrays.stream(arr).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream().filter(e->e.getValue()>=2).forEach(e->System.out.print(e+" "));

        System.out.println();

        for (int element : duplicates) {
            System.out.print(element + " ");
        }
        System.out.println();
        List<Integer> duplicates1 = findDuplicatesusingHashmap(arr);

        for (int element : duplicates) {
            System.out.print(element + " ");
        }
    }

    private static List<Integer> findDuplicates(Integer[] arr) {

        Set<Integer> set = new HashSet<>();
        return Arrays.stream(arr).filter(e->!set.add(e)).toList();
    }

    private static List<Integer> findDuplicatesusingHashmap(Integer[] arr) {

      Map<Integer,Integer> map = new HashMap<>();
      List<Integer> list = new ArrayList<>();
      for(int i: arr) {
          map.put(arr[i],map.getOrDefault(arr[i],0)+1);
      }

      for(Map.Entry<Integer,Integer> i: map.entrySet()){
          if(i.getValue()>=2){
              list.add(i.getKey());
              System.out.println("duplicate is :"+i);
          }
      }

        return list;
    }
}
