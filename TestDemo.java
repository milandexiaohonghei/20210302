import java.util.Arrays;
import java.util.jar.JarOutputStream;



public class TestDemo {


    //插入排序
    public static void arraySort(int[] array){
        for(int i = 1; i <array.length; i++){
            int tmp = array[i];
            int j = i-1;
            while(j >= 0){
                if(tmp < array[j]){
                    array[j+1] = array[j];
                    j--;
                }else{
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }

    //希尔排序
    public static void shell(int[] array,int gap){
        for (int i = gap; i < array.length ; i++) {
            int tmp = array[i];
            int j = i - gap;
            while(j >= 0){
                if(array[j] > tmp){
                    array[j+gap] = array[j];
                    j = j-gap;
                }else{
                    break;
                }
            }
            array[j+gap] = tmp;

        }

    }

    public static void shellSort(int[] array) {
        int[] drr = {5,3,1};//增量数组-->   16   5     3     1
        for (int i = 0; i < drr.length; i++) {
            shell(array,drr[i]);
        }
    }


    //选择排序
    public static void selectSort(int[] array){
        for(int i = 0; i < array.length-1; i++){
            int j = i+1;
            while(j < array.length){
                if(array[j] < array[i]){
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                    j++;
                }else{
                    j++;
                }
            }
        }
    }
    public static void selectSort3(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            for (int j = i+1; j < array.length; j++) {
                if(array[j] < array[i]) {
                    int tmp = array[j];
                    array[j] = array[i];
                    array[i] = tmp;
                }
            }
        }
    }


    //快速排序

    public static int pivot(int[] array,int start,int end){
        int tmp = array[start];//看起始位置，不一定是0
        while(start < end){
            if(start < end && tmp <= array[end]){
                end--;
            }
            array[start] = array[end];
            if(start < end && tmp >= array[start]){
                start++;
            }
            array[end]  = array[start];
        }
        array[start] = tmp;
        return start;

    }

    public static void swap( int[] array,int a,int b){
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    public static void medianOfThree(int[] array,int low,int high){
        int mid = (low + high)/2;
        //array[mid] <= array[low] <= array[end]
        if(array[low] < array[mid]) {
            swap(array,low,mid);
        }//array[mid] <= array[low]
        if(array[low] > array[high]) {
            swap(array,low,high);
        }//array[low] <= array[high]
        if(array[mid] > array[high]) {
            swap(array,mid,high);
        }//array[mid] <= array[high]
    }


    public static void insertSortBount(int[] array,int low,int high) {
        for (int i = low+1; i <= high; i++) {
            int tmp = array[i];
            int j = i-1;
            for (; j >= low ; j--) {
                if(array[j] > tmp) {
                    array[j+1] = array[j];
                }else {
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }

   public static void quick(int[] array,int low,int high){
        if(low >= high){
            return;
        }

       if(high-low + 1 <= 50) {
           //使用插入排序
           insertSortBount(array,low,high);
           return;//记着这里一定要return  这里说明 这个区别范围有序了 直接结束
       }
        medianOfThree(array,low,high);
        int pi = pivot(array,low,high);
        quick(array,low,pi-1);
        quick(array,pi+1,high);
   }



    public static void quicksort(int[] array){
        quick(array,0,array.length-1);

    }


    public static void main(String[] args) {
        int[] array = new int[]{1,7,5,45,23,56,84,65};
        //arraySort(array);
        //shellSort(array);
        //selectSort3(array);
        quicksort(array);
        String a = Arrays.toString(array);
        System.out.println(a);

    }
}
