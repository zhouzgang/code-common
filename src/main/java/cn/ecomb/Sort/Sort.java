package cn.ecomb.Sort;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by zhouzg on 2017/2/7.
 */
public class Sort {

    /**
     * 交换排序-冒泡排序
     */
    public void bubbleSort(int array[]){
        System.out.println("排序前：" + Arrays.toString(array));
        for (int i=0,length=array.length-1 ; i<length ; i++) {
            for (int j=0 ; j<length-i ; j++) {
                if (array[j] > array[j+1]) {
                    swap(array, j, j+1);
                }
            }
        }
        System.out.println("排序后：" + Arrays.toString(array));
    }

    /**
     *  交换排序-冒泡排序 （改进版本）
     *  从列表的两边同时冒泡
     * @param array
     */
    public void bubbleSort_1(int array[]){
        System.out.println("排序前：" + Arrays.toString(array));
        int high = array.length-1;
        int low = 0;
        while (low<high) {
            for (int j=low ; j<high ; j++) {
                if (array[j] > array[j+1]) {
                    swap(array, j, j+1);
                }
            }
            high--;
            for (int j=high ; j>low ; j--) {
                if (array[j] < array[j-1]) {
                    swap(array, j, j-1);
                }
            }
            low++;
        }
        System.out.println("排序后：" + Arrays.toString(array));
    }

    /**
     * 交换排序 - 快速排序 (还有一个改进版本)
     * @param array
     */
    public void quickSort(int array[], int low, int high){
        System.out.println("排序前：" + Arrays.toString(array));
        //跳出递归
        if(low < high) {
            int privotLoc = partition(array, low, high);
            System.out.println("privotLoc:" + array[privotLoc]);
            quickSort(array, privotLoc + 1, high);
            quickSort(array, low, privotLoc - 1);
        }
        System.out.println("排序后：" + Arrays.toString(array));
    }

    private int partition(int array[], int low, int high){
        int privotKey = array[low];
        while (low < high) {
            while (low < high && array[high] >= privotKey)
                --high;
            swap(array, low, high);
            while (low < high && array[low] <= privotKey)
                ++low;
            swap(array, low, high);
        }
        return low;
    }

    private void swap(int[] array, int low, int high) {
        int tmp = array[low];
        array[low] = array[high];
        array[high] = tmp;
    }





}
