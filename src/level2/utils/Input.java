package level2.utils;

import level2.exceptions.EmptyInputException;
import level2.exceptions.InvalidCharLengthException;
import level2.exceptions.IsNotSOrNException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {

    private static final Scanner SC = new Scanner(System.in);

    public static byte readByte(String message) {
        byte number = 0;
        boolean correct = false;
        do {
            System.out.print(message);
            try {
                number = SC.nextByte();
                correct = true;
            } catch (InputMismatchException e) {
                System.out.println("Error de formato");
            }
            SC.nextLine();
        } while (!correct);
        return number;
    }

    public static int readInteger(String message) {
        int number = 0;
        boolean correct = false;

        do {
            System.out.print(message);
            try {
                number = SC.nextInt();
                correct = true;
            } catch (InputMismatchException e) {
                System.out.println("Error de formato");
            }
            SC.nextLine();
        } while (!correct);
        return number;
    }


    public static float readFloat(String message) {
        float number = 0.0f;
        boolean correct = false;

        do {
            System.out.print(message);
            try {
                number = SC.nextFloat();
                correct = true;
            } catch (InputMismatchException e) {
                System.out.println("Error de formato");
            }
            SC.nextLine();
        } while (!correct);
        return number;
    }

    public static double readDouble(String message) {
        double number = 0.0;
        boolean correct = false;
        do {
            System.out.print(message);
            try {
                number = SC.nextDouble();
                correct = true;
            } catch (InputMismatchException e) {
                System.out.println("Error de formato");
            }
            SC.nextLine();
        } while (!correct);
        return number;
    }

    public static char readChar(String message) {
        String inputStr = "";
        char character = ' ';
        boolean correct = false;
        do {
            System.out.print(message);
            try {
                inputStr = SC.nextLine();
                if (inputStr.isEmpty()) {
                    throw new EmptyInputException("el carácter no puede estar vacío");
                } else if (inputStr.length() != 1) {
                    throw new InvalidCharLengthException("has de introducir un solo caràcter ");
                }
                character = inputStr.charAt(0);
                correct = true;
            } catch (EmptyInputException e) {
                System.out.println("Error, " + e.getMessage());
            } catch (InvalidCharLengthException e) {
                System.out.println("Error, " + e.getMessage());
            }
        } while (!correct);
        return character;
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

    public static boolean readYesNo(String message) {
        boolean awnser = false;
        boolean correct = false;
        String inputStr = "";
        char character = ' ';
        do {
            System.out.print(message);
            try {
                inputStr = SC.nextLine();
                if (inputStr.isEmpty()) {
                    throw new EmptyInputException("el carácter no puede estar vacío");
                } else if (inputStr.length() != 1) {
                    throw new InvalidCharLengthException("has de introducir un solo caràcter, " +
                            "\"S\" para sí o \"N\" para no");
                } else if (!inputStr.equalsIgnoreCase("s") && !inputStr.equalsIgnoreCase("n")) {
                    throw new IsNotSOrNException("has de introducir \"S\" para sí o \"N\" para no");
                }
                if (inputStr.equalsIgnoreCase("S")) {
                    awnser = true;
                    correct = true;
                } else if (inputStr.equalsIgnoreCase("N")) {
                    correct = true;
                }
            } catch (InvalidCharLengthException e) {
                System.out.println("Error, " + e.getMessage());
            } catch (EmptyInputException e) {
                System.out.println("Error, " + e.getMessage());
            } catch (IsNotSOrNException e) {
                System.out.println("Error, " + e.getMessage());
            }
        } while (!correct);
        return awnser;
    }

}
