package prometheus;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Alex on 19.02.2015.
 */
public class Karatsuba
{
    private static Map<BigInteger, Integer> map = new TreeMap<BigInteger, Integer>();

    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String value1 = reader.readLine();
        String value2 = reader.readLine();
        BigInteger karatsuba = Karatsuba(value1, value2);
        System.out.println(karatsuba);
        reader.close();
        for (Map.Entry<BigInteger, Integer> pair:map.entrySet())
            System.out.println(pair.getKey() + ": " + pair.getValue());
    }

    public static BigInteger Karatsuba(String v1, String v2)
    {
        String a, b, c, d;
        if (v1.length()==1&&v2.length()==1)
            return new BigInteger(String.valueOf(Integer.parseInt(v1)*Integer.parseInt(v2)));
        while (v1.length()%2!=0)
            v1 = "0" + v1;
        while (v2.length()%2!=0)
            v2 = "0" + v2;
        if (v1.length()>v2.length())
        {
            while (v1.length()!=v2.length())
                v2 = "0" + v2;
        }
        if (v1.length()<v2.length())
        {
            while (v1.length()!=v2.length())
                v1 = "0" + v1;
        }
        a = v1.substring(0, v1.length()/2);
        b = v1.substring(v1.length()/2, v1.length());
        c = v2.substring(0, v2.length()/2);
        d = v2.substring(v2.length()/2, v2.length());
        BigInteger ac = Karatsuba(a, c);
        BigInteger bd = Karatsuba(b, d);
        BigInteger a1 = new BigInteger(a);
        BigInteger b1 = new BigInteger(b);
        BigInteger c1 = new BigInteger(c);
        BigInteger d1 = new BigInteger(d);
        BigInteger adbc = Karatsuba(String.valueOf(a1.add(b1)), String.valueOf(c1.add(d1)));
        adbc = adbc.subtract(ac).subtract(bd);
        map.put(adbc, map.get(adbc)==null ? 1 : map.get(adbc)+1);
        BigInteger result = BigInteger.ZERO;
        BigInteger st1 = new BigInteger("10").pow(v1.length());
        BigInteger st2 = new BigInteger("10").pow(v1.length()/2);
        result = result.add(st1.multiply(ac));
        result = result.add(st2.multiply(adbc));
        result = result.add(bd);
        return result;
    }
}
