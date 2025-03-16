package level3.utils;

import level3.exceptions.EmptyInputException;
import level3.exceptions.ExceptionValueOutOfRange;

import java.util.InputMismatchException;
import java.util.Scanner;

public class KeyboardInput {
    private static final Scanner SC = new Scanner(System.in);

    public static int readInteger(String message) {
        int number = 0;
        boolean correct = false;

        do {
            System.out.print(message);
            try {
                number = SC.nextInt();
                correct = true;
            } catch (InputMismatchException ex) {
                System.out.println("Error de formato");
            }
            SC.nextLine();
        } while (!correct);
        return number;
    }

    public static String readString(String message) {
        String inputStr = "";
        boolean correct = false;
        do {
            System.out.print(message);
            try {
                inputStr = SC.nextLine().trim();
                if (inputStr.isEmpty()) {
                    throw new EmptyInputException("el String no puede estar vacío");
                }
                correct = true;
            } catch (EmptyInputException e) {
                System.out.println("Error, " + e.getMessage());
            }
        } while (!correct);
        return inputStr;
    }

    public static int readIntegerBetweenOnRange(String message, int minimum, int maximum) {
        int number = 0;
        boolean correct = false;
        do {
            System.out.print(message);
            try {
                number = SC.nextInt();
                if (number < minimum || number > maximum) {
                    throw new ExceptionValueOutOfRange(
                            "el valor introducido ha de estar entre " + minimum + " y " + maximum + ". "
                    );
                } else {
                    correct = true;
                }
            } catch (ExceptionValueOutOfRange e) {
                System.out.println("Error, " + e.getMessage());
            } catch (InputMismatchException ex) {
                System.out.println("Error de formato");
            }
            SC.nextLine();
        } while (!correct);
        return number;
    }


}
