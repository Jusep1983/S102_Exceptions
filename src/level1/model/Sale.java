package level1.model;

import level1.exceptions.VendaBuidaException;

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

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double calculateTotal() {
        double totalCalculation = 0;
        try {
            if (this.products.isEmpty()) {
                throw new VendaBuidaException("Per fer una venda primer has d’afegir productes");
            }
            for (Product product : this.products) {
                totalCalculation += product.getPrice();
            }
        } catch (VendaBuidaException e) {
            System.out.println("Error capturat: " + e.getMessage());
        }
        return totalCalculation;
    }


    @Override
    public String toString() {
        return "Sale{" +
                "products=" + this.products +
                ", totalPrice=" + this.totalPrice +
                '}';
    }
}
