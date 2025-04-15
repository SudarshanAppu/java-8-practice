package marchpraticedsa;

import marchpratice.March18;

public class March23_DSA {
    public static void main() {
        System.out.println("simple static main");
    }

    public static void main(String[] args) {
        March23_DSA.main();
        int[] arr = {2, 4, 1, 10, 24, 7, 9, 8};
        int target = 7;
        int [] arr2 = {2,3,4,5,7,10,20};

        int res =March23_DSA.linearSearch1(target, arr2);
        if(res<0){
            System.out.println("not found");
        }else{
            System.out.println("found at position :"+res);
        }
        int bires =SearchSortingAlgo.binarySearch(arr,target);
        System.out.println(bires);
        if(bires<0){
            System.out.println("not found");
        }else
        {
            System.out.println("found at position:"+res);
        }
    }

    private static int binarySearch1(int target, int[] arr) {
        int left =0;
        int right = arr.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(arr[mid]==target){
                return mid;
            }else if(arr[mid]<target){
                left=mid+1;
            }else{
                right=mid-1;
            }

        }
        return -1;
    }

    public static int linearSearch1(int target, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
