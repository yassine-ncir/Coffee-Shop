import java.util.LinkedList;
import java.util.Locale;
import java.util.Scanner;

public class ServicesMenu {
    public static Scanner input = new Scanner(System.in);

    // Category methods
    static void addCategory(category c) {
        System.out.print("Category name: ");
        String categoryName = input.nextLine();
        c.setName(categoryName);
    }

    static LinkedList<category> renameCategory(LinkedList<category> menu, String x) {
        for (category c : menu){
            if (c.getName().equals(x)){
                System.out.println("New Name : ");
                c.setName(input.nextLine());
                return menu;
            }
        }
        return menu;
    }
    static void displayCategory(LinkedList<category> menu){
        System.out.println("<<<< Display Category >>>> ");
        for (category s : menu){
            System.out.print(s.getName()+" | ");
            System.out.println(s.getProducts()+" | ");
        }
    }


    // Category methods
    private static category findCategoryByName(LinkedList<category> menu, String categoryName) {
        for (category c : menu ){
            if (c.getName().equals(categoryName)){
                return c;
            }
        }
        return null;
    }
    static item addItem() {
        System.out.print("Type: ");
        String type = input.nextLine();
        System.out.print("Price: ");
        float price = input.nextFloat();
        input.nextLine(); // Consume newline character
        return new item(type, price);
    }

    static void addItemToCategory(LinkedList<category> menu){
        // get from user the category name
        System.out.println("Enter category name: ");
        String categoryName = input.nextLine();

        // find category name
        category c = findCategoryByName(menu, categoryName);
        if (c == null){
            System.out.println("Category not found.");
            return;
        }
        // add item to category
        item i = addItem();
        c.getProducts().add(i);
    }


}
