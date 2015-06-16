package calculator;

import java.math.BigInteger;

public abstract class Calculation {

    public static String calculate(Number number1, Number number2, String operand) {
        String result = "";
        BigInteger bigNumber1 = new BigInteger(number1.getScale10Value());
        BigInteger bigNumber2 = new BigInteger(number2.getScale10Value());

        if (operand.equals("+")) {
            result = addition(bigNumber1, bigNumber2);
        } else if (operand.equals("-")) {
            result = substraction(bigNumber1, bigNumber2);
        } else if (operand.equals("*")) {
            result = multiplication(bigNumber1, bigNumber2);
        } else if (operand.equals("/")) {
            result = division(bigNumber1, bigNumber2);
        } else if (operand.equals("%")) {
            result = remainderFromDivision(bigNumber1, bigNumber2);
        } else {                                                        //else if... add leetcode operands in future
            return "Calculator does not support this operation yet";
        }

        result = number1.getConvertedValue(result);
        if (!number1.getScale().equals("10")) {
            result += "(" + number1.getScale() + ")";
        }
        return result;
    }

    private static String addition(BigInteger number1, BigInteger number2) {
        return String.valueOf(number1.add(number2));
    }

    private static String substraction(BigInteger number1, BigInteger number2) {
        return String.valueOf(number1.subtract(number2));
    }

    private static String multiplication(BigInteger number1, BigInteger number2) {
        return String.valueOf(number1.multiply(number2));
    }

    private static String division(BigInteger number1, BigInteger number2) {
        return String.valueOf(number1.divide(number2));
    }

    private static String remainderFromDivision(BigInteger number1, BigInteger number2) {
        return String.valueOf(number1.remainder(number2));
    }
    //implement leetcode arithmetic operations in future
}
