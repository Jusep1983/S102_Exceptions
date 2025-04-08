package level1;

import level1.exceptions.EmptySaleException;
import level1.model.Product;
import level1.model.Sale;

public class MainLevel1 {
    public static void main(String[] args) {
            Sale sale1 = new Sale();
        try {
            sale1.getProducts().add(new Product("banana", 10.2));
            sale1.getProducts().add(new Product("Apple", 5.3));
            sale1.calculateTotal();
            sale1.getProducts().get(2);
        } catch (EmptySaleException | IndexOutOfBoundsException e) {
            System.out.println("Error capturat, " + e.getMessage());
        }
    }

}
