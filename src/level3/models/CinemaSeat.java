package level3.models;

import java.util.Objects;

public class CinemaSeat {
    private int row;
    private int seatNumber;
    private String person;

    public CinemaSeat(int row, int seatNumber, String reservedBy) {
        this.row = row;
        this.seatNumber = seatNumber;
        this.person = reservedBy;
    }

    public int getRow() {
        return row;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public String getPerson() {
        return person;
    }

    public boolean equalsSeat(int row, int seatNumber) {
        return this.row == row && this.seatNumber == seatNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof CinemaSeat that)) return false;
        return row == that.row && seatNumber == that.seatNumber && Objects.equals(person, that.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, seatNumber, person);
    }

    @Override
    public String toString() {
        return "Fila:" + this.row + ", Asiento: "
               + this.seatNumber + ", Persona: " + this.person;
    }
    
}
