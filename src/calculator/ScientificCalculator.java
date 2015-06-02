package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * Created by Andrew on 02.03.2015.
 */
public abstract class ScientificCalculator {
    private static Number number1;
    private static Number number2;
    private static String operand;

    public static String readExpressionFromConsole() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s = "";
            while (s.isEmpty()) {
                s = reader.readLine();
            }
            return startCalculation(s);
        } catch (IOException e) {
            return "Mistake in entered expression";
        }
    }

    public static String readExpression(String expression) {
        return startCalculation(expression);
    }

    //add leetcode input methods in future

    private static String startCalculation(String expression) {
        try {
            getNumbers(expression);
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        } catch (Exception e) {
             return "Mistake in entered expression";
        }
        return Calculation.calculate(number1, number2, operand);
    }

    private static void getNumbers(String expression) {
        expression = expression.replaceAll(" ", "");
        LinkedList<Character> chars = convertToListOfChars(expression);

        String number1Value = getNumberValue(chars);
        String number1Scale = getScale(chars);
        operand = getOperand(chars);
        String number2Value = getNumberValue(chars);
        String number2Scale = getScale(chars);

        number1 = NumberFactory.createNumber(number1Value, number1Scale);
        number2 = NumberFactory.createNumber(number2Value, number2Scale);
    }

    private static LinkedList<Character> convertToListOfChars(String expression) {
        LinkedList<Character> list = new LinkedList<Character>();
        for (char c:expression.toCharArray()) {
            list.add(c);
        }
        return list;
    }

    private static String getNumberValue(LinkedList<Character> list) {
        String result = "";
        if (list.peek()=='-') {
            result += list.poll();
        }
        while (list.peek()!=null && (Character.isDigit(list.peek()) || Character.isLetter(list.peek()))) {
            result += list.poll();
        }
        return result;
    }

    private static String getScale(LinkedList<Character> list) {
        String result = "";
        if (list.peek()!=null && list.peek()=='(') {
            list.poll();
            while (list.peek() != ')') {
                result += list.poll();
            }
            list.poll();
        }
        return result;
    }

    private static String getOperand(LinkedList<Character> list) {
        String result = "";
        while (!Character.isDigit(list.peek()) && !Character.isLetter(list.peek())) {
            result += list.poll();
        }
        return result;
    }
}