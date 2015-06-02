package prometheus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Alex on 22.02.2015.
 */
public class PasswordRecovery
{
    public static void main(String[] args) throws IOException, CorruptedDataException
    {
        String[] testArray = readFromFile("D:\\JavaProjects\\Algorythms\\Password_10.txt", 10);
        System.out.println(recoverPassword(testArray));

        String[] testArray2 = readFromFile("D:\\JavaProjects\\Algorythms\\Password_1000.txt", 1000);
        System.out.println(recoverPassword(testArray2));
    }

    private static char[] symbols = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public static String recoverPassword(String[] array)
    {
        //Arrays.sort(array);
        array = RadixSort.radixSort(array, 3);
        String firstPart = array[0];
        String middlePart = returnMaxOccurencedLetter(array);
        String lastPart = array[array.length-1];
        return firstPart + middlePart + lastPart;
    }

    private static String returnMaxOccurencedLetter(String[] array)
    {
        int[] temp = new int[symbols.length];
        int max = 0;
        int indexOfMax = 0;
        for (String str:array)
        {
            for (char c:str.toCharArray())
            {
                for (int i = 0; i < symbols.length; i++)
                {
                    if (c==symbols[i])
                        temp[i]++;
                }
            }
        }
        for (int i=0;i<temp.length;i++)
        {
            if (temp[i] > max) {
                max = temp[i];
                indexOfMax = i;}
        }
        return String.valueOf(symbols[indexOfMax]);
    }

    private static String[] readFromFile(String filename, int numberOfElements) throws IOException, CorruptedDataException
    {
        int n = 0;
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String[] array = new String[numberOfElements];
        while (reader.ready())
        {
            array[n] = reader.readLine();
            n++;
        }
        if (n!=numberOfElements)
        {
            System.err.println("The array should contain " + numberOfElements + " elements");
            System.err.println("Imported from file " + n + " elements");
            throw new CorruptedDataException();
        }
        return array;
    }
}
