package febPratice;

public class DataStructures {

    public  static void main(String[] args){
        int[] arr  = {2,4,1,10,24,7,9,8};
        int target = 7;
        int  res = linearSearch(arr, target);

        if(res<0){
            System.out.println("target not found ");
        }
        else {
            System.out.println("found at :"+res+" Index in array");
        }

        int [] arr2 = {2,3,4,5,7,10,20};
        int resbinary =binarySearch(arr2,target);
        if(resbinary<0){
            System.out.println("target not found ");
        }
        else {
            System.out.println("found at :"+resbinary+" Index in array");
        }

//bubble sort
        int[] arr3 = {5,8,9,1,2,4};

        System.out.println("bubble sort start");

        bubbleSort1(arr3);
        System.out.println("\nbubble sort end");

        selectionSort1(arr3);


    }
    public  static int linearSearch(int[] arr,int target){
        for(int i = 0;i<arr.length;i++){
            if(arr[i]==target){
                return i;
            }

        }
        return -1;
    }

    public  static int binarySearch(int[] arr,int target){
        int left = 0;
        int right = arr.length-1;


        while(left<=right){
            int mid = (left+right)/2;

            if(arr[mid]==target){
                return mid;
            } else if (arr[mid]<target) {
                left=mid+1;
            }
            else {
                right =mid-1;
            }
        }
        return -1;
    }

    public static void bubbleSort1(int[] arr){
        int temp =0;
        for(int i =0;i<arr.length;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    temp =arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            System.out.println();
            for(int j = 1;j<arr.length;j++){
                System.out.print(arr[j]+" ");

            }
        }
        System.out.println();

        for(int i =0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void selectionSort1(int [] arr){
        int min = 0;
        for(int i = 0;i<arr.length;i++){
            min = i;

            for(int j=i+1;j<arr.length;j++){
                if(arr[min]>arr[j]){
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;

        }
        System.out.println("\n selection sort");
        for(int i =0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

}
