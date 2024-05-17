package Services;

import Entity.*;
import Entity.category;
import Entity.item;

import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Scanner;

import static java.awt.SystemColor.menu;

public class ServicesMenu {
    public static Scanner input = new Scanner(System.in);

    // Category methods
    public static void addCategory(category c) {
        System.out.print("Category name: ");
        String categoryName = input.nextLine();
        c.setName(categoryName);
    }

    public static void renameCategory(LinkedList<category> menu, String oldName) {
        for (category c : menu) {
            if (c.getName().equals(oldName)) {
                System.out.print("New Name: ");
                c.setName(input.nextLine());
                return;
            }
        }
        System.out.println("Category not found.");
    }

    // Item methods
    static item addItem() {
        System.out.print("Type: ");
        String type = input.nextLine();
        System.out.print("Price: ");
        float price = input.nextFloat();
        input.nextLine(); // Consume newline character
        return new item(type, price);
    }

    public static void addItemToCategory(LinkedList<category> menu) {
        System.out.print("Enter category name: ");
        String categoryName = input.nextLine();

        category c = findCategoryByName(menu, categoryName);
        if (c == null) {
            System.out.println("Category not found.");
            return;
        }
        item newItem = addItem();
        c.getProducts().add(newItem);
    }

    public static void deleteItemFromCategory(LinkedList<category> menu) {
        // read category from user
        System.out.print("Enter category name: ");
        String categoryName = input.nextLine();

        category c = findCategoryByName(menu, categoryName);
        if (c == null) {
            System.out.println("Category not found.");
            return;
        }

        // Display items in the category
        System.out.println("Items in category " + c.getName() + ":");
        int index = 1;
        for (item i : c.getProducts()) {
            System.out.println(index + ") " + i.getType() + " - " + i.getPrice());
            index++;
        }
        input.nextLine();// Consume newline

        // get from user the number of item that removed
        int itemNumber;
        do {
            System.out.print("Enter the number of the item to delete: ");
            itemNumber = input.nextInt();
            input.nextLine(); // Consume newline
        }while (itemNumber < 1 || itemNumber > c.getProducts().size());
        c.getProducts().remove(itemNumber - 1);
    }

    public static void modifyItemInCategory(LinkedList<category> menu) {
        // get category from user
        System.out.print("Enter category name: ");
        String categoryName = input.nextLine();

        // looking for name if exist in category menu
        category category = findCategoryByName(menu, categoryName);
        if (category == null) {
            System.out.println("Category not found.");
            return;
        }

        // Display items in the category
        System.out.println("Items in category " + category.getName() + ":");
        int index = 1;
        for (item item : category.getProducts()) {
            System.out.println(index + ") " + item.getType() + " - " + item.getPrice());
            index++;
        }

        System.out.print("Enter the number of the item to modify: ");
        int itemNumber = input.nextInt();
        input.nextLine(); // Consume newline
        if (itemNumber < 1 || itemNumber > category.getProducts().size()) {
            System.out.println("Invalid item number.");
            return;
        }

        item item = category.getProducts().get(itemNumber - 1);
        System.out.print("Enter new type: ");
        String newType = input.nextLine();
        System.out.print("Enter new price: ");
        float newPrice = input.nextFloat();
        input.nextLine(); // Consume newline

        item.setType(newType);
        item.setPrice(newPrice);

        System.out.println("Item modified successfully.");
    }

    public static void displayMenu(LinkedList<category> menu) {
        if (menu == null || menu.isEmpty()) {
            System.out.println("Invalid or empty menu.");
            return;
        }
        for (category c : menu) {
            System.out.println(c.getName() + ":");
            for (item i : c.getProducts()) {
                System.out.println("  " + i.getType() + " - " + i.getPrice());
            }
        }
    }

    private static category findCategoryByName(LinkedList<category> menu, String categoryName) {
        for (category c : menu) {
            if (c.getName().equals(categoryName)) {
                return c;
            }
        }
        return null;
    }


    // Order methods
    public static void initOrder(LinkedList<category> menu) {
        ArrayList<String> orders = new ArrayList<>(); // Initialize the ArrayList

        // Enter your order choice until 'stop' is entered
        System.out.println("What's your order ?");
        Order o = new Order();
        do {
            System.out.print("Enter Type name (write 'stop' to stop): ");
            o.setType(input.nextLine().toLowerCase(Locale.ROOT));
            if (!o.getType().equals("stop")) {
                orders.add(o.getType());
            }
        } while (!o.getType().equals("stop"));

        // Now, you can use the 'orders' ArrayList containing the user's orders
        System.out.println("Your orders: " + orders);

        // Calculate the total price of the order
        double totalPrice = calculateTotalPrice(orders, menu);
        System.out.println("Total Price: " + totalPrice);

        // Save the order to a file
        saveOrderToFile(orders, totalPrice,"yess",o.getDate());
    }

    private static void saveOrderToFile(ArrayList<String> orders, double totalPrice, String orderType, LocalDate date) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("orders.txt"))) {
            writer.println(", Orders: " + orders + ", Total Price: " + totalPrice + ", Date: " + date );
        } catch (IOException e) {
            System.err.println("Error occurred while saving orders to file: " + e.getMessage());
        }
    }


    private static double calculateTotalPrice(ArrayList<String> orders, LinkedList<category> menu) {
        double totalPrice = 0;
        for (String order : orders) {
            float price = searchForPrice(order, menu);
            totalPrice += price;
        }
        return totalPrice;
    }

    private static float searchForPrice(String order, LinkedList<category> menu) {
        for (category c : menu) {
            for (item i : c.getProducts()) {
                if (i.getType().equals(order)) {
                    return i.getPrice();
                }
            }
        }
        return 0; // Return 0 if price not found for the item
    }


}
