package level1;

import level1.model.Sale;

public class MainLevel1 {
    public static void main(String[] args) {
        double totalSales;
        Sale sale1 = new Sale();
        totalSales = sale1.calculateTotal();
        try {
            sale1.getProducts().get(3);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error capturat " + e.getMessage());
        }
        System.out.println("El total de les vendes de \"sale1\" és de " + totalSales + "€");
    }
}
