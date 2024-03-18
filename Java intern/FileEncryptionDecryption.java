import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileEncryptionDecryption {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose operation: ");
        System.out.println("1. Encrypt");
        System.out.println("2. Decrypt");

        int choice = scanner.nextInt();

        System.out.println("Enter the file name or path: ");
        scanner.nextLine();
        String fileName = scanner.nextLine();

        System.out.println("Enter the key (an integer value): ");
        int key = scanner.nextInt();

        switch (choice) {
            case 1:
                encryptFile(fileName, key);
                System.out.println("File encrypted successfully!");
                break;
            case 2:
                decryptFile(fileName, key);
                System.out.println("File decrypted successfully!");
                break;
            default:
                System.out.println("Invalid choice. Please choose 1 for encryption or 2 for decryption.");
        }

        scanner.close();
    }

    private static void encryptFile(String fileName, int key) {
        processFile(fileName, key, true);
    }

    private static void decryptFile(String fileName, int key) {
        processFile(fileName, key, false);
    }

    private static void processFile(String fileName, int key, boolean encrypt) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter(getOutputFileName(fileName, encrypt)))) {

            int currentChar;
            while ((currentChar = reader.read()) != -1) {
                char processedChar = encrypt ? (char) (currentChar + key) : (char) (currentChar - key);
                writer.write(processedChar);
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error processing the file.");
        }
    }

    private static String getOutputFileName(String fileName, boolean encrypt) {
        String prefix = encrypt ? "encrypted_" : "decrypted_";
        int lastDotIndex = fileName.lastIndexOf('.');
        if (lastDotIndex != -1) {
            return fileName.substring(0, lastDotIndex) + "_" + prefix + fileName.substring(lastDotIndex + 1);
        } else {
            return fileName + "_" + prefix;
        }
    }
}
