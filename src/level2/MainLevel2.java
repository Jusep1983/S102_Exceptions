package level2;

import level2.utils.Input;

public class MainLevel2 {
    public static void main(String[] args) {
        String myStr;
        byte myByte;
        int myInt;
        float myFloat;
        double myDouble;
        char myChar = ' ';
        boolean myBoolean;
        System.out.println("Solo para programadores: ");
        myByte = Input.readByte("Introduce un número en rango byte: ");
        myInt = Input.readInteger("Introduce un Integer: ");
        myFloat = Input.readFloat("Introduce un float:");
        myDouble = Input.readDouble("Introduce un double: ");
        myChar = Input.readChar("Introduce un char: ");
        myStr = Input.readString("Introduce un String: ");
        myBoolean = Input.readYesNo("Introduce 'S' para si 'N' para no: ");

        System.out.println("Datos introducidos: "
                           + "\n\tbyte = " + myByte + "\n\tint = " + myInt + "\n\tfloat = " + myFloat
                           + "\n\tdouble = " + myDouble + "\n\tchar = " + myChar
                           + "\n\tString = " + myStr + "\n\tboolean = " + myBoolean
        );
    }

}
