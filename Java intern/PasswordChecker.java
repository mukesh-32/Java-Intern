import java.util.Scanner;

public class PasswordChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your password: ");
        String password = scanner.nextLine();

        int length = password.length();
        boolean hasUppercase = containsUppercase(password);
        boolean hasLowercase = containsLowercase(password);
        boolean hasNumber = containsNumber(password);
        boolean hasSpecialChar = containsSpecialChar(password);

        int strength = calculateStrength(length, hasUppercase, hasLowercase, hasNumber, hasSpecialChar);

        System.out.println("Password Strength: " + getStrengthDescription(strength));

        scanner.close();
    }

    private static boolean containsUppercase(String password) {
        return !password.equals(password.toLowerCase());
    }

    private static boolean containsLowercase(String password) {
        return !password.equals(password.toUpperCase());
    }

    private static boolean containsNumber(String password) {
        return password.matches(".*\\d.*");
    }

    private static boolean containsSpecialChar(String password) {
        return !password.matches("[A-Za-z0-9]*");
    }

    private static int calculateStrength(int length, boolean hasUppercase, boolean hasLowercase, boolean hasNumber, boolean hasSpecialChar) {
        int strength = 0;

        // Check length
        if (length >= 8) {
            strength++;
        }

        // Check for uppercase letters
        if (hasUppercase) {
            strength++;
        }

        // Check for lowercase letters
        if (hasLowercase) {
            strength++;
        }

        // Check for numbers
        if (hasNumber) {
            strength++;
        }

        // Check for special characters
        if (hasSpecialChar) {
            strength++;
        }

        return strength;
    }

    private static String getStrengthDescription(int strength) {
        switch (strength) {
            case 0:
                return "Very Weak";
            case 1:
                return "Weak";
            case 2:
                return "Moderate";
            case 3:
                return "Strong";
            case 4:
                return "Very Strong";
            default:
                return "Invalid Strength";
        }
    }
}
