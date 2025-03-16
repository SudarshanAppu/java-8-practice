package marchpraticedsa;

public class Sumoftwo {
    public static void main(String[] args){

        int[] arr = { 0, -1, 2, -3, 1 };
        int target = -2;

        if (twoSum(arr, target))
            System.out.println("true");
        else
            System.out.println("false");
    }

    private static boolean twoSum(int[] arr, int target) {
        for(int i = 0;i<arr.length;i++){
            for(int j = i+1;j<arr.length;j++){
                if(arr[i]+arr[j]==target){
                    return true;
                }

            }
        }
        return false;
    }
}
