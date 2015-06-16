package prometheus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.TreeMap;

public class Inversion {
  private static HashMap<Integer, Integer[]> map = new HashMap<Integer, Integer[]>();

  public static void main(String[] args) throws IOException, CorruptedDataException {
    fillArray("D:\\JavaProjects\\Algorythms\\data_examples_02\\task1_1000_5.txt");
    // example from: http://edx.prometheus.org.ua/c4x/KPI/Algorithms101/asset/input_1000_5.txt
    System.out.println("Task1:");
    System.out.println(countInversions(452, 100));
    System.out.println(countInversions(863, 29));
    fillArray("D:\\JavaProjects\\Algorythms\\data_examples_02\\task2_1000_100.txt");
    // example from: http://edx.prometheus.org.ua/c4x/KPI/Algorithms101/asset/input_1000_100.txt
    System.out.println("Task2:");
    System.out.println(countInversions(618, 1));
    System.out.println(countInversions(951, 178));
  }

  public static int countInversions(int user1, int user2)  //Calculating the number of inversions between two users
  {
    int inversions = 0;
    TreeMap<Integer, Integer> tree = new TreeMap<Integer, Integer>();
    for (int i = 0; i < map.get(user1).length; i++)
      tree.put(map.get(user1)[i], map.get(user2)[i]);
    Integer[] array = tree.values().toArray(new Integer[tree.values().size()]);
    for (int i = 0; i < array.length - 1; i++) {
      for (int j = i + 1; j < array.length; j++) {
        if (array[i] > array[j])
          inversions++;
      }
    }
    return inversions;
  }

  public static void fillArray(String filename) throws IOException, CorruptedDataException { //Filling in map from the source file
    map.clear();
    BufferedReader reader = new BufferedReader(new FileReader(filename));
    String[] first = reader.readLine().split(" ");
    int users = Integer.parseInt(first[0]);
    int movies = Integer.parseInt(first[1]);
    try {
      for (int i = 0; i < users; i++) {
        String[] line = reader.readLine().split(" ");
        Integer[] oneUser = new Integer[movies];
        for (int j = 1; j < movies + 1; j++) {
          oneUser[j - 1] = Integer.parseInt(line[j]);
        }
        map.put(Integer.parseInt(line[0]), oneUser);
      }
    } catch (Exception e) {
      System.out.println(e);
      throw new CorruptedDataException();
    }
  }
}
