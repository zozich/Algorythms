package prometheus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Alex on 25.02.2015.
 */
public class HeapMedianSearch
{
    public static void main(String[] args) throws IOException, CorruptedDataException
    {
        int[] testArray = ArrayQuickSort.readFromFile("D:\\JavaProjects\\Algorythms\\Heap_Median_10000.txt");
        getMedians(testArray);
        //printCorrectAnswer("D:\\JavaProjects\\Algorythms\\data_examples_05\\ext_output_04_10.txt");
    }

    public static void getMedians(int[] testArray)
    {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) {
                    return -1;
                }
                if (o1 < o2) {
                    return 1;
                }
                return 0;
            }
        };

        PriorityQueue<Integer> queue_high = new PriorityQueue<Integer>();
        PriorityQueue<Integer> queue_low = new PriorityQueue<Integer>(); //comparator);
        for (int i=0;i<testArray.length;i++)
        {
            if (queue_high.peek()==null)
            {
                queue_high.offer(testArray[i]);
                System.out.println("Median(s): " + queue_high.peek() + ", Queue_Low=" + queue_low.toString() + ", Queue_High=" + queue_high.toString());
                continue;
            }
            if (testArray[i]<queue_high.peek())
                queue_low.offer(testArray[i]);
            else
                queue_high.offer(testArray[i]);
            if (queue_high.size()>queue_low.size()+1)
            {
                int relocated = queue_high.remove();
                queue_low.offer(relocated);
            }
            if (queue_low.size()>queue_high.size()+1)
            {
                int relocated = queue_low.remove();
                queue_high.offer(relocated);
            }
            if (i==2014)//||i==9875)
            {
                if (queue_high.size() > queue_low.size())
                    System.out.println(i + 1 + ":Median(s): " + queue_high.peek() + ", Queue_Low=" + queue_low.toString() + ", Queue_High=" + queue_high.toString());
                if (queue_high.size() < queue_low.size())
                    System.out.println(i + 1 + ":Median(s): " + queue_low.peek() + ", Queue_Low=" + queue_low.toString() + ", Queue_High=" + queue_high.toString());
                if (queue_high.size() == queue_low.size())
                    System.out.println(i + 1 + ":Median(s): " + queue_low.peek() + ", " + queue_high.peek() + ", Queue_Low=" + queue_low.toString() + ", Queue_High=" + queue_high.toString());
            }
        }
    }

    public static void printCorrectAnswer(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        int n=0;
        while (reader.ready())
        {
            System.out.print(reader.readLine() + " ");
            if (n==4) {
                System.out.println();
                n=0;
            }
            n++;
        }
    }
}
