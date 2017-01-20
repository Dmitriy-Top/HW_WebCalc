package main.java.strategys;

/**
 * Created by admin on 19.01.2017.
 */
public class Error implements Strategy {
    public String execute(double a, double b) {
        return "Не известный аргумент";
    }
}
