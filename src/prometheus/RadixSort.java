package prometheus;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Alex on 22.02.2015.
 */
public class RadixSort
{
    public static String[] radixSort(String[] array, int rank)
    {
        for (int i=0;i<rank;i++)
        {
            array = countingRadixSort(array, rank - i, 26);
            System.out.println("After iteration " + (i+1) + " first string in array is:");
            System.out.println(array[0]);
        }
        return array;
    }

    private static String symbols = "abcdefghijklmnopqrstuvwxyz";

    public static String[] countingRadixSort(String[] array, int rank, int number_of_symbols)
    {
        int[] temp = new int[number_of_symbols];
        for (String str:array)
            temp[symbols.indexOf(str.substring(rank-1, rank))]++;
        for (int i=1;i<temp.length;i++)
            temp[i] += temp[i-1];
        String[] result = new String[array.length];
        for (int i=result.length-1;i>=0;i--)
        {
            result[temp[symbols.indexOf(array[i].substring(rank - 1, rank))]-1] = array[i];
            temp[symbols.indexOf(array[i].substring(rank - 1, rank))]--;
        }
        return result;
    }
}
