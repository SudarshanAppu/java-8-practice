package marchpraticedsa;

public class SearchSortingAlgo {

    public static void main(String[] args){
        int[] arr  = {2,4,1,10,24,7,9,8};
        int target = 7;
        int  res = linearSearch(arr, target);
        if(res<0){
            System.out.println("element not found");
        }
        else{
            System.out.println("element found in position:"+res);
        }

        int [] arr2 = {2,3,4,5,7,10,20};
        int resbinary =binarySearch(arr2,target);
        if(resbinary<0){
            System.out.println("element not found");
        }else{
            System.out.println("found in position: "+resbinary);
        }

        //bubble sort
        int[] arr3 = {5,8,9,1,2,4};

        System.out.println("bubble sort start");

        bubbleSort1(arr3);
        System.out.println("\nbubble sort end");
        System.out.println("selection sort ");
        int[] arr4 = {5,8,9,1,2,4};

        selectionSort1(arr4);
    }

    private static void selectionSort1(int[] arr3){
        for(int i =0;i<arr3.length;i++){
            int min =i;
            for(int j = i+1;j<arr3.length;j++){
                if(arr3[min]>arr3[j]){
                    min =j;
                }

            }
            int temp = arr3[min];
            arr3[min] =arr3[i];
            arr3[i] = temp;

            for(int k: arr3){
                System.out.print(k+",");
            }
            System.out.println();
        }
    }
    private static void bubbleSort1(int[] arr3){
        for(int i =0;i<arr3.length-1;i++){
            for(int j=0;j<arr3.length-i-1;j++){
                if(arr3[j]>arr3[j+1]){
                    int temp = arr3[j];
                    arr3[j]=arr3[j+1];
                    arr3[j+1]=temp;
                }
            }

            for(int k:arr3){
                System.out.print(k+",");
                }
            System.out.println();
        }
        System.out.println("sorted array is:");
        for(int k:arr3){
            System.out.print(k);
        }
    }

    private static int binarySearch(int[] arr2, int target) {
        int left =0;
        int right = arr2.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(arr2[mid]==target){
                return mid;
            }else if(arr2[mid]<target){
                left=mid+1;
            }else{
                right=mid-1;
            }

        }
        return -1;
    }

    private static int linearSearch(int[] arr, int target) {

        for(int i = 0;i<arr.length;i++){
            if(arr[i]==target){
                return i;
            }
        }

        return -1;
    }
}
