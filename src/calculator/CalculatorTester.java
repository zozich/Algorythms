package calculator;

/**
 * Created by Andrew on 10.03.2015.
 */

public class CalculatorTester {

    public static void main(String[] args) {
        System.out.print(ScientificCalculator.readExpression("123+345"));
        System.out.println(" - " + ScientificCalculator.readExpression("123+345").equals("468"));
        System.out.print(ScientificCalculator.readExpression("123 + 345"));
        System.out.println(" - " + ScientificCalculator.readExpression("123 + 345").equals("468"));
        System.out.print(ScientificCalculator.readExpression("IV(r)+VI(r)"));
        System.out.println(" - " + ScientificCalculator.readExpression("IV(r)+VI(r)").equals("X(r)"));
        System.out.print(ScientificCalculator.readExpression("1010(2)+101(2)"));
        System.out.println(" - " + ScientificCalculator.readExpression("1010(2)+101(2)").equals("1111(2)"));
        System.out.print(ScientificCalculator.readExpression("AB34(16)+1234"));
        System.out.println(" - " + ScientificCalculator.readExpression("AB34(16)+1234").equals("B006(16)"));
        System.out.print(ScientificCalculator.readExpression("IV(r)+12"));
        System.out.println(" - " + ScientificCalculator.readExpression("IV(r)+12").equals("XVI(r)"));
        System.out.print(ScientificCalculator.readExpression("FFFFFFFFFFFFFFFFFFFFF(16)+ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ(36)"));
        System.out.println(" - " + ScientificCalculator.readExpression("FFFFFFFFFFFFFFFFFFFFF(16)+ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ(36)").equals("4F2A04BCC8C649DA825DD6321D65BB5B464FFFFFFFFFFFFFFFFFFFFE(16)"));
        System.out.print(ScientificCalculator.readExpression("CCDMVII(r)+1"));
        System.out.println(" - " + ScientificCalculator.readExpression("CCDMVII(r)+1").equals("The numbers in roman numeral CCDMVII are represented in wrong sequence"));
        System.out.print(ScientificCalculator.readExpression("FF(15)+12"));
        System.out.println(" - " + ScientificCalculator.readExpression("FF(15)+12").equals("Number FF cannot be represented in scale system 15"));
        System.out.print(ScientificCalculator.readExpression("123==12"));
        System.out.println(" - " + ScientificCalculator.readExpression("123==12").equals("Calculator does not support this operation yet"));
        System.out.print(ScientificCalculator.readExpression("12"));
        System.out.println(" - " + ScientificCalculator.readExpression("12").equals("Mistake in entered expression"));
        System.out.print(ScientificCalculator.readExpression("VIJ(r)+123"));
        System.out.println(" - " + ScientificCalculator.readExpression("VIJ(r)+123").equals("Roman numeral VIJ indicated incorrectly (illegal characters)"));
        System.out.print(ScientificCalculator.readExpression("AF12(40)+10(2)"));
        System.out.println(" - " + ScientificCalculator.readExpression("AF12(40)+10(2)").equals("Incorrect scale indication (40)"));
    }
}