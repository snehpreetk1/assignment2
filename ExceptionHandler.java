import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class ExceptionHandler {

    public static void handleException(Exception e) {
        System.out.println("An error occurred: " + e.getMessage());
    }

    public static void handleInputMismatchException(InputMismatchException e) {
        System.out.println("Invalid input. Please enter the correct type of data.");
    }

    public static void handleNoSuchElementException(NoSuchElementException e) {
        System.out.println("Input error: No such element found.");
    }

    public static void handleIllegalArgumentException(IllegalArgumentException e) {
        System.out.println("Error: " + e.getMessage());
    }
}

