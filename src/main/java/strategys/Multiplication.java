package main.java.strategys;

import static main.java.Decorator.doubleDecorate;

/**
 * Created by admin on 19.01.2017.
 */
public class Multiplication implements Strategy{
    public String execute(double a, double b) {
        String result = (a+" * "+b+" = "+ doubleDecorate(a*b));
        return result;
    }
}
