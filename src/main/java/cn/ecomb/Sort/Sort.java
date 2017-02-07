package cn.ecomb.Sort;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by zhouzg on 2017/2/7.
 */
public class Sort {

    /**
     * 冒泡排序
     */
    public void bubbleSort(){
        int array[] = getRandomArray();
        System.out.println(Arrays.toString(array));
        for (int i=0,length=array.length ; i<length ; i++) {
            for (int j=0 ; j<length-i ; j--) {
                if (array[i] > array[i+1]) {
                   int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }

    private int[] getRandomArray() {
        int arrayLength = 10;
        int array[] = new int[arrayLength];
        Random random = new Random(100);
        for (int i=0 ; i<arrayLength ; i++) {
            array[i] = random.nextInt();
        }
        return array;
    }
}
