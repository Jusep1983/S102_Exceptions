package level3.utils;
import level3.exceptions.EmptyInputException;
import level3.exceptions.ValueOutOfRangeException;
import level3.exceptions.IncorrectNameException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class KeyboardInput {
    private static final Scanner SC = new Scanner(System.in);

    public static void numberNotEmpty(String input) throws EmptyInputException {
        if (input.isEmpty()) {
            throw new EmptyInputException("el campo no puede estar vacío");
        }
    }

    public static String readInput() {
        return SC.nextLine().trim();
    }

    public static int readInteger(String message) {
        while (true) {
            System.out.print(message);
            try {
                String input = readInput();
                numberNotEmpty(input);
                return Integer.parseInt(input);
            } catch (NullPointerException | NumberFormatException e) {
                System.out.println("Error de formato");
            } catch (EmptyInputException | NoSuchElementException | IllegalStateException e) {
                System.out.println("Error, " + e.getMessage());
            }
        }
    }

    public static String checkString() throws EmptyInputException {
        String inputStr = readInput();
        if (inputStr.isEmpty()) {
            throw new EmptyInputException("el String no puede estar vacío");
        } else if (inputStr.matches(".*\\d.*")) {
            throw new IncorrectNameException("el nombre no puede contener números");
        } else {
            return inputStr;
        }
    }

    public static String readString(String message) {
        while (true) {
            try {
                System.out.print(message);
                return checkString();
            } catch (EmptyInputException | IncorrectNameException | NoSuchElementException | IllegalStateException e) {
                System.out.println("Error, " + e.getMessage());
            }
        }
    }

    public static void checkRangeNumber(String input,int minimum, int maximum) throws ValueOutOfRangeException {
        int number = Integer.parseInt(input);
        if (number < minimum || number > maximum) {
            throw new ValueOutOfRangeException(
                    "el valor introducido ha de estar entre " + minimum + " y " + maximum + ". "
            );
        }
    }

    public static int readIntegerBetweenOnRange(String message, int minimum, int maximum) {
        while (true) {
            try {
                System.out.print(message);
                String input = readInput();
                numberNotEmpty(input);
                checkRangeNumber(input,minimum,maximum);
                return Integer.parseInt(input);
            } catch (NullPointerException | NumberFormatException e) {
                System.out.println("Error de formato");
            } catch (EmptyInputException | NoSuchElementException | IllegalStateException | ValueOutOfRangeException e) {
                System.out.println("Error, " + e.getMessage());
            }
        }
    }

    public static int menuOption() {
        return readIntegerBetweenOnRange(""" 
                
                MENÚ PRINCIPAL CINE
                1.- Mostrar todos los asientos reservados
                2.- Mostrar los asientos reservados por una persona
                3.- Reservar un asiento
                4.- Anular la reserva de un asiento
                5.- Anular todas las reservas de una persona
                0.- Salir
                """, 0, 5);
    }

}
