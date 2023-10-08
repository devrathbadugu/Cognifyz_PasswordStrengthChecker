import java.util.Scanner;
import java.util.regex.*;

public class PasswordStrengthChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a password: ");
        String password = scanner.nextLine();
        scanner.close();

        if (isStrongPassword(password)) {
            System.out.println("Password is strong.");
        } else {
            System.out.println("Password is weak. Please choose a stronger password.");
        }
    }

    public static boolean isStrongPassword(String password) {
        // Check if the password length is at least 8 characters
        if (password.length() < 8) {
            return false;
        }

        // Check if the password contains at least one uppercase letter
        if (!Pattern.compile("[A-Z]").matcher(password).find()) {
            return false;
        }

        // Check if the password contains at least one lowercase letter
        if (!Pattern.compile("[a-z]").matcher(password).find()) {
            return false;
        }

        // Check if the password contains at least one digit
        if (!Pattern.compile("[0-9]").matcher(password).find()) {
            return false;
        }

        // Check if the password contains at least one special character
        if (!Pattern.compile("[!@#$%^&*()-_+=<>?]").matcher(password).find()) {
            return false;
        }

        // Check for common password patterns (e.g., "password", "123456")
        if (Pattern.compile("(?i)password|123456|qwerty").matcher(password).find()) {
            return false;
        }

        return true;
    }
}
