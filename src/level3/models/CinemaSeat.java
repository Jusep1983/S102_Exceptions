package level3.models;

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

    public boolean equals(CinemaSeat seat) {
        boolean equal = false;
        if (this.row == seat.getRow() && this.seatNumber == seat.getSeatNumber()) {
            equal = true;
        }
        return equal;
    }

    @Override
    public String toString() {
        return "Fila:" + this.row + ", Asiento: "
               + this.seatNumber + ", Persona: " + this.person;
    }
}
