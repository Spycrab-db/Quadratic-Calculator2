package application;

public class MyMath {
    public static double round(double number, int precision){
        double accuracy = (Math.pow(10, precision));
        return Math.round(number * accuracy) / accuracy;
    }
}
