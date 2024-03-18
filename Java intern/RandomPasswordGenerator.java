import java.util.Random;
import java.util.Scanner;

public class RandomPasswordGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the desired length of the password: ");
        int length = scanner.nextInt();

        System.out.println("Include numbers? (yes/y or no/n): ");
        boolean includeNumbers = isYesResponse(scanner.next());

        System.out.println("Include lowercase letters? (yes/y or no/n): ");
        boolean includeLowercase = isYesResponse(scanner.next());

        System.out.println("Include uppercase letters? (yes/y or no/n): ");
        boolean includeUppercase = isYesResponse(scanner.next());

        System.out.println("Include special characters? (yes/y or no/n): ");
        boolean includeSpecialChars = isYesResponse(scanner.next());

        String password = generatePassword(length, includeNumbers, includeLowercase, includeUppercase, includeSpecialChars);
        System.out.println("Generated Password: " + password);

        scanner.close();
    }

    private static boolean isYesResponse(String response) {
        return response.equalsIgnoreCase("yes") || response.equalsIgnoreCase("y");
    }

    private static String generatePassword(int length, boolean includeNumbers, boolean includeLowercase, boolean includeUppercase, boolean includeSpecialChars) {
        StringBuilder password = new StringBuilder();
        Random random = new Random();

        String lowercaseChars = "abcdefghijklmnopqrstuvwxyz";
        String uppercaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";
        String specialChars = "!@#$%^&*()_+-=[]{}|;:,.<>?";

        String availableChars = "";

        if (includeLowercase) {
            availableChars += lowercaseChars;
        }
        if (includeUppercase) {
            availableChars += uppercaseChars;
        }
        if (includeNumbers) {
            availableChars += numbers;
        }
        if (includeSpecialChars) {
            availableChars += specialChars;
        }

        if (availableChars.isEmpty()) {
            System.out.println("Error: No character set selected.");
            return "";
        }

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(availableChars.length());
            password.append(availableChars.charAt(randomIndex));
        }

        return password.toString();
    }
}
