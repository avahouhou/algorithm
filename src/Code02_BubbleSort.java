import java.util.Arrays;

/*
* 冒泡排序算法，时间复杂度O(n^2)
* */
public class Code02_BubbleSort {

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //0~N-1
        //0~N-2
        //0~N-3
        for (int e = arr.length - 1; e > 0; e--) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    //交换方法
                    swap(arr,i,i+1);
                }
            }
        }

    }

    /*异或tips
     * 1.交换方法同一个地址不能交换，否则全部归零
     * 2.相同异或归零
     * 3.异或满足交换律和结合律
     *
     *  */
    public static void swap(int[] arr, int i, int j) {
        //通过异或实现交换方法
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    public static int[] copyArray(int[] arr) {
        if (arr.length < 0 || arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    //不熟
    public static int[] generateRandomArray(int maxSize,int maxValue) {
        //Math.random() [0,1)
        //Math.random() * N [0,N)
        int[]arr = new int[(int)(Math.random()*(maxSize+1))];
        for(int i =0;i<arr.length;i++){
            //[-?,+?]
            arr[i] = (int)(Math.random()*(maxSize+1))-(int)(Math.random()*maxSize);
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for(int num:arr){
            System.out.println(num+"");
        }
    }


    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if(arr1.length != arr2.length){
            return false;
        }
        for(int i = 0;i<arr1.length;i++){
            if(arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            bubbleSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "OH GOD!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        bubbleSort(arr);
        printArray(arr);
    }
}
