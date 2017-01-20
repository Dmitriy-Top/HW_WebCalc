package main.java;

/**
 * Created by admin on 19.01.2017.
 */
public class Decorator {
    public static String resultDecorate(String result){
        result = result.replace(".0","");
        return result;
    }
    public static double doubleDecorate(Double dbl){
        return Math.rint(100.0 * dbl) / 100.0;
    }
}
