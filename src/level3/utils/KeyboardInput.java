package level3.utils;

import level3.exceptions.EmptyInputException;
import level3.exceptions.ExceptionValueOutOfRange;
import level3.exceptions.IncorrectNameException;

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
                if (inputStr.matches(".*\\d.*")) {
                    throw new IncorrectNameException("el nombre no puede contener números");
                }
                if (inputStr.isEmpty()) {
                    throw new EmptyInputException("el nombre no puede estar vacío");
                }
                correct = true;
            } catch (EmptyInputException | IncorrectNameException e) {
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

    public static int menuOption() {
        int option = readIntegerBetweenOnRange(""" 
                
                MENÚ PRINCIPAL CINE
                1.- Mostrar todos los asientos reservados
                2.- Mostrar los asientos reservados por una persona
                3.- Reservar un asiento
                4.- Anular la reserva de un asiento
                5.- Anular todas las reservas de una persona
                0.- Salir
                """, 0, 5);
        return option;
    }

}
