package prometheus;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Andrew on 03.03.2015.
 */
public class TempStorage
{
    public static void main(String[] args)
    {
        System.out.println("Start!");
        double a = 0.001;
        double min = 100;
        double mina = 0;
        while (a<=1) {
            double result = a/((1-a)*Math.log(1/(1-a)));
            if (Math.abs(result - 2) < min) {
                min = Math.abs(result - 2);
                mina = a;
            }
            a += 0.001;
        }
        System.out.println(min);
        System.out.println(mina);

        System.out.println(1/0.5*Math.log(1/(1-0.5)));

    }
}
