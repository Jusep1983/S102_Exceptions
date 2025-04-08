package level2;

import level2.exceptions.EmptyInputException;
import level2.exceptions.InvalidCharLengthException;
import level2.utils.Input;

public class MainLevel2 {
    public static void main(String[] args) throws InvalidCharLengthException, EmptyInputException {
        System.out.println("Solo para programadores: ");
        byte myByte = Input.getByte("Introduce un número en rango byte: ");
        int myInt = Input.getInteger("Introduce un Integer: ");
        float myFloat = Input.getFloat("Introduce un float:");
        double myDouble = Input.getDouble("Introduce un double: ");
        char myChar = Input.getChar("Introduce un char: ");
        String myStr = Input.getString("Introduce un String: ");
        boolean myBoolean = Input.getBoolean("Introduce 'S' para si 'N' para no: ");

        System.out.println("Datos introducidos: "
                           + "\n\tbyte = " + myByte + "\n\tint = " + myInt + "\n\tfloat = " + myFloat
                           + "\n\tdouble = " + myDouble + "\n\tchar = " + myChar
                           + "\n\tString = " + myStr + "\n\tboolean = " + myBoolean
        );
    }

}
