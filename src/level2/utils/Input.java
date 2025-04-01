package level2.utils;

import level2.exceptions.EmptyInputException;
import level2.exceptions.InvalidCharLengthException;
import level2.exceptions.IsNotSOrNException;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Input {

    private static final Scanner SC = new Scanner(System.in);

    public static void numberNotEmpty(String input) throws EmptyInputException {
        if (input.isEmpty()) {
            throw new EmptyInputException("el campo no puede estar vacío");
        }
    }

    public static byte readByte(String message) {
        while (true) {
            System.out.print(message);
            try {
                String input = SC.nextLine();
                numberNotEmpty(input);
                return Byte.parseByte(input);
            } catch (NullPointerException | NumberFormatException e) {
                System.out.println("Error de formato");
            } catch (EmptyInputException | NoSuchElementException | IllegalStateException e) {
                System.out.println("Error, " + e.getMessage());
            }
        }
    }


    public static int readInteger(String message) {
        while (true) {
            System.out.print(message);
            try {
                String input = SC.nextLine();
                numberNotEmpty(input);
                return Integer.parseInt(input);
            } catch (NullPointerException | NumberFormatException e) {
                System.out.println("Error de formato");
            } catch (EmptyInputException | NoSuchElementException | IllegalStateException e) {
                System.out.println("Error, " + e.getMessage());
            }
        }
    }

    public static float readFloat(String message) {
        while (true) {
            System.out.print(message);
            try {
                String input = SC.nextLine();
                numberNotEmpty(input);
                return Float.parseFloat(input);
            } catch (NullPointerException | NumberFormatException e) {
                System.out.println("Error de formato");
            } catch (EmptyInputException | NoSuchElementException | IllegalStateException e) {
                System.out.println("Error, " + e.getMessage());
            }
        }
    }

    public static double readDouble(String message) {
        while (true) {
            System.out.print(message);
            try {
                String input = SC.nextLine();
                numberNotEmpty(input);
                return Double.parseDouble(input);
            } catch (NullPointerException | NumberFormatException e) {
                System.out.println("Error de formato");
            } catch (EmptyInputException | NoSuchElementException | IllegalStateException e) {
                System.out.println("Error, " + e.getMessage());
            }
        }
    }

    public static char readChar(String message) {
        while (true) {
            try {
                return checkChar(message);
            } catch (EmptyInputException | InvalidCharLengthException
                     | NoSuchElementException | IllegalStateException e) {
                System.out.println("Error, " + e.getMessage());
            }
        }
    }

    public static char checkChar(String message) throws EmptyInputException, InvalidCharLengthException {
        System.out.print(message);
        String inputStr = SC.nextLine().trim();
        if (inputStr.isEmpty()) {
            throw new EmptyInputException("el carácter no puede estar vacío");
        } else if (inputStr.length() != 1) {
            throw new InvalidCharLengthException("has de introducir un solo caràcter ");
        } else {
            return inputStr.charAt(0);
        }
    }


    public static String checkString(String message) throws EmptyInputException {
        System.out.print(message);
        String inputStr = SC.nextLine().trim();
        if (inputStr.isEmpty()) {
            throw new EmptyInputException("el String no puede estar vacío");
        } else {
            return inputStr;
        }
    }

    public static String readString(String message) {
        while (true) {
            try {
                return checkString(message);
            } catch (EmptyInputException | NoSuchElementException | IllegalStateException e) {
                System.out.println("Error, " + e.getMessage());
            }
        }
    }

    public static boolean readYesNo(String message) {
        while (true) {
            try {
                return checkBoolean(message);
            } catch (InvalidCharLengthException | EmptyInputException | IsNotSOrNException
                     | NoSuchElementException | IllegalStateException e) {
                System.out.println("Error, " + e.getMessage());
            }
        }
    }

    public static boolean checkBoolean(String message)
            throws EmptyInputException, InvalidCharLengthException, IsNotSOrNException {
        System.out.print(message);
        String inputStr = SC.nextLine();
        if (inputStr.isEmpty()) {
            throw new EmptyInputException("el carácter no puede estar vacío");
        } else if (inputStr.length() != 1) {
            throw new InvalidCharLengthException("has de introducir un solo caràcter");
        } else if (!inputStr.equalsIgnoreCase("s") && !inputStr.equalsIgnoreCase("n")) {
            throw new IsNotSOrNException("has de introducir \"S\" para sí o \"N\" para no");
        }
        return inputStr.equalsIgnoreCase("S");
    }

}
