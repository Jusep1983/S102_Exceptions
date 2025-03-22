package level2;

import level2.utils.Input;

public class MainLevel2 {
    public static void main(String[] args) {
        System.out.println("Solo para programadores: ");
        byte myByte = Input.readByte("Introduce un número en rango byte: ");
        int myInt = Input.readInteger("Introduce un Integer: ");
        float myFloat = Input.readFloat("Introduce un float:");
        double myDouble = Input.readDouble("Introduce un double: ");
        char myChar = Input.readChar("Introduce un char: ");
        String myStr = Input.readString("Introduce un String: ");
        boolean myBoolean = Input.readYesNo("Introduce 'S' para si 'N' para no: ");

        System.out.println("Datos introducidos: "
                           + "\n\tbyte = " + myByte + "\n\tint = " + myInt + "\n\tfloat = " + myFloat
                           + "\n\tdouble = " + myDouble + "\n\tchar = " + myChar
                           + "\n\tString = " + myStr + "\n\tboolean = " + myBoolean
        );
    }

}
