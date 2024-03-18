import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the temperature value: ");
        double temperature = scanner.nextDouble();

        System.out.println("Enter the unit of measurement (C for Celsius, F for Fahrenheit): ");
        char unit = scanner.next().charAt(0);

        double convertedTemperature;
        String convertedUnit;

        if (unit == 'C' || unit == 'c') {
            convertedTemperature = celsiusToFahrenheit(temperature);
            convertedUnit = "Fahrenheit";
        } else if (unit == 'F' || unit == 'f') {
            convertedTemperature = fahrenheitToCelsius(temperature);
            convertedUnit = "Celsius";
        } else {
            System.out.println("Invalid unit of measurement. Please enter 'C' for Celsius or 'F' for Fahrenheit.");
            return;
        }

        System.out.println("Converted temperature: " + convertedTemperature + " " + convertedUnit);

        scanner.close();
    }

    private static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    private static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
}
