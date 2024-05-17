package Entity;

import java.util.ArrayList;

public class category {

    // Attributes
    private String name;
    private ArrayList<item> products;

    // Parameterized constructor
    public category(String name) {
        this.name = name;
        this.products = new ArrayList<>(); // Initialize the products list
    }

    // Empty constructor
    public category() {
        this.products = new ArrayList<>(); // Initialize the products list
    }

    // Getter & setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<item> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<item> products) {
        this.products = products;
    }
}
