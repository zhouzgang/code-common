package cn.ecomb.Sort;

import org.junit.Test;

import java.util.Random;

/**
 * Created by zhouzg on 2017/2/7.
 */
public class TestSort {

    @Test
    public void testBubbleSort(){
        Sort sort = new Sort();
        sort.bubbleSort(getRandomArray());
    }

    @Test
    public void testBubbleSort_1(){
        Sort sort = new Sort();
        sort.bubbleSort_1(getRandomArray());
    }

    @Test
    public void testQuitSort(){
        Sort sort = new Sort();
        int array[] = getRandomArray();
        sort.quickSort(array, 0, array.length-1);
    }



    private int[] getRandomArray() {
        int arrayLength = 10;
        int array[] = new int[arrayLength];
        Random random = new Random();
        for (int i=0 ; i<arrayLength ; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }
}
