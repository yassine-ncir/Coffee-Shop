package Entity;

public class item {

    // Attributes
    private String type;
    private float price;


    // Parameter constructor
    public item(String type, float price) {
        this.type = type;
        this.price = price;
    }


    // Empty constructor
    public item() {
    }


    // Getter & Setter
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
