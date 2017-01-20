package main.java;

import main.java.strategys.*;
import main.java.strategys.Error;

import static main.java.Decorator.resultDecorate;

/**
 * Created by admin on 19.01.2017.
 */
public class Calculator {
    private double a;
    private double b;
    private String operator;
    private String result;

    public Calculator(String input) {
        String[] args = input.split("\\s");
        if (args.length == 3) {
            this.operator = args[1];
            try {
                this.a = Double.parseDouble(args[0]);
                this.b = Double.parseDouble(args[2]);
                if (this.b == 0 & operator.equals("/"))
                    throw new ArithmeticException();
                this.result = this.calc();
            } catch (NumberFormatException e) {
                this.result = "Неверные аргументы";
            } catch (ArithmeticException e) {
                this.result = "Деление на ноль запрещенно";
            }
        }
    }

    private String calc() {
        Strategy strategy;
        switch (operator){
            case "+":
                strategy = new Plus();
                break;
            case "-":
                strategy = new Minus();
                break;
            case "*":
                strategy = new Multiplication();
                break;
            case "/":
                strategy = new Division();
                break;
            default:
                strategy = new Error();
        }
        result = strategy.execute(a,b);
        return resultDecorate(result);

    }


    public String getResult() {
        if(this.result==null) this.result = "Неверные аргументы";
        try{
            new ResultDAO("jdbc:postgresql://127.0.0.1:5432/webcalc", "root", "12345").putResult(result);
        } catch (Exception e){
            for(StackTraceElement ste :e.getStackTrace()){
                result+=ste.toString();
            }
        }
        return result;
    }
}
