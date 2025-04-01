package level1.model;

import level1.exceptions.EmptySaleException;

import java.util.ArrayList;

public class Sale {
    private ArrayList<Product> products;
    private double totalPrice;

    public Sale() {
        this.products = new ArrayList<>();
        this.totalPrice = 0;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void calculateTotal() throws EmptySaleException {
        if (this.products.isEmpty()) {
            throw new EmptySaleException("per fer una venda primer has d’afegir productes");
        }
        for (Product product : this.products) {
            this.totalPrice += product.getPrice();
        }
        System.out.println("El total de vendes és de " + this.totalPrice + "€");
    }

    @Override
    public String toString() {
        return "Venta| productes: \n" + this.products + ", totalPrice: " + this.totalPrice + "| ";
    }

}
