package calculator;

/**
 * Created by Andrew on 02.03.2015.
 */
public abstract class Number {
    protected String value;
    protected String scale;

    public String getValue() {
        return value;
    }

    public String getScale() {
        return scale;
    }

    protected abstract void checkNumber();

    public abstract String getScale10Value();

    public abstract String getConvertedValue(String expression);
}