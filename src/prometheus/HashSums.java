package prometheus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by Alex on 11.03.2015.
 */
public class HashSums {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("D:\\JavaProjects\\Algorythms\\input_06.txt"));
        HashMap<Long, Long> map = new HashMap<Long, Long>();
        HashSet<Long> listPlus = new HashSet<Long>();
        HashSet<Long> listMinus = new HashSet<Long>();
        while (reader.ready()) {
            String s = reader.readLine();
            Long l = Long.parseLong(s);
            if (l<0) {
                listMinus.add(l);
            } else {
                listPlus.add(l);
            }
        }
        System.out.println(listPlus.size());
        System.out.println(listMinus.size());
        for (Long l1:listPlus) {
            for (Long i=-1000l;i<=1000l;i++) {
                Long temp = i - l1;
                if (listMinus.contains(temp)) {
                    map.put(i, 1l);
                }
            }
        }
        System.out.println(map.size());
        for (Map.Entry pair : map.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }
}
