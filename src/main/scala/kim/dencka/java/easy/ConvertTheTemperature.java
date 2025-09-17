package kim.dencka.java.easy;

import java.util.Arrays;

class ConvertTheTemperature {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(convertTemperature(36.50d))); // [309.65000,97.70000]
    }

    public static double[] convertTemperature(double celsius) {
        double kelvin = celsius + 273.15d;
        double far = celsius * 1.80d + 32.00d;
        return new double[] {kelvin, far};
    }
}
