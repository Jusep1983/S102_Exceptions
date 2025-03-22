package level1;

import level1.model.Product;
import level1.model.Sale;

public class MainLevel1 {
    public static void main(String[] args) {
        double totalSales;
        Sale sale1 = new Sale();
        sale1.getProducts().add(new Product("banana",10.2));
        sale1.getProducts().add(new Product("Apple",5.3));
        totalSales = sale1.calculateTotal();

        sale1.setTotalPrice(totalSales);
        try {
            sale1.getProducts().get(3);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error capturat " + e.getMessage());
        }
        System.out.println("El total de les vendes de \"sale1\" és de " + totalSales + "€");
    }
}
