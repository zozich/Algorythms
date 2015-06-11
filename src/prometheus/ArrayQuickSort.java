package prometheus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class ArrayQuickSort {
  public static void main(String[] args) throws IOException, CorruptedDataException {
    int[] testArray = readFromFile("D:\\JavaProjects\\Algorythms\\data_examples_03\\input__10.txt");
    System.out.println(Arrays.toString(quickSort(testArray, 3)));
    System.out.println(count + " comparison(s)");

    testArray = readFromFile("D:\\JavaProjects\\Algorythms\\data_examples_03\\input__100.txt");
    System.out.println(Arrays.toString(quickSort(testArray, 3)));
    System.out.println(count + " comparison(s)");

    testArray = readFromFile("D:\\JavaProjects\\Algorythms\\data_examples_03\\input__1000.txt");
    System.out.println(Arrays.toString(quickSort(testArray, 3)));
    System.out.println(count + " comparison(s)");

    testArray = readFromFile("D:\\JavaProjects\\Algorythms\\Sort_10000.txt");
    //Example from http://edx.prometheus.org.ua/c4x/KPI/Algorithms101/asset/input__10000.txt
    System.out.println(Arrays.toString(quickSort(testArray, 3)));
    System.out.println(count + " comparison(s)");
  }

  private static Random random = new Random();
  private static int count = 0;

  public static int[] quickSort(int[] array, int method) throws InvalidArgumentException {
    count = 0;
    return quickSortStart(array, 0, array.length - 1, method); //to insert partition mechanism
  }

  private static int[] quickSortStart(int[] array, int p, int r, int method) throws InvalidArgumentException {
    if (p == r)
      return array;
    int comp_index = getCompIndex(array, p, r, method);
    int comparison = array[comp_index];                     //Getting the value of an array item to be compared
    if (comp_index < r)
      switchItemsInArray(array, comp_index, r);
    int i = p, j = p;
    for (int z = p; z < r; z++)                      //Comparing the array values with the selected item
    {
      count++;
      if (array[z] <= comparison) {
        if (z > i)
          switchItemsInArray(array, i, j);
        i++;
        j++;
      } else
        j++;
    }
    if (i < r)                                   //Putting the comparison item after all the values that are lower than it
      switchItemsInArray(array, r, i);
    if (i > p)
      quickSortStart(array, p, i - 1, method);    //Recursive call for the left part
    if (j > i)
      quickSortStart(array, i + 1, r, method);    //Recursive call for the right part
    return array;
  }

  private static void switchItemsInArray(int[] array, int x, int y) {
    int temp;
    temp = array[x];
    array[x] = array[y];
    array[y] = temp;
  }

  private static int getCompIndex(int[] array, int p, int r, int method) throws InvalidArgumentException {
    switch (method) {
      case 1:
        return r;
      case 2:
        return p;
      case 3: {
        if (r - p < 2)
          return p;
        int a = array[p], b = array[r], c = array[(r + p) / 2];
        if (a >= b && a <= c || a <= b && a >= c)
          return p;
        else if (b >= a && b <= c || b <= a && b >= c)
          return r;
        else if (c >= a && c <= b || c <= a && c >= b)
          return (r + p) / 2;
      }
      case 4:
        return random.nextInt(r - p + 1);
      default:
        throw new InvalidArgumentException();
    }
  }

  public static int[] readFromFile(String filename) throws IOException, CorruptedDataException {
    int n = 0;
    BufferedReader reader = new BufferedReader(new FileReader(filename));
    int full = Integer.parseInt(reader.readLine());
    int[] array = new int[full];
    while (reader.ready()) {
      array[n] = Integer.parseInt(reader.readLine());
      n++;
    }
    if (n != full) {
      System.err.println("The array should contain " + full + " elements");
      System.err.println("Imported from file " + n + " elements");
      throw new CorruptedDataException();
    }
    return array;
  }
}
