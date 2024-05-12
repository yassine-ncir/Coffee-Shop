import java.util.ArrayList;

public class category {

    // Attributes
    private String name;
    private ArrayList<item> products;


    // Parameter constructor
    public category(String name, ArrayList<item> products) {
        this.name = name;
        this.products = products;
    }


    // Empty constructor
    public category() {
    }


    // Getter & setter

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
