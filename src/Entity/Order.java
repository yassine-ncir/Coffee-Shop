package Entity;

import java.time.LocalDate;
import java.util.Date;

public class Order extends item {
    // Attributes
    private LocalDate date;


    // Parameter constructor
    public Order(LocalDate date) {
        this.date = date;
    }


    // Empty constructor
    public Order() {
    }


    // Getter & Setter
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDataOrder() {
        return this.getType() + " " + this.getPrice() + " " + this.getDate();
    }
}
