package Main;

import Entity.category;
import Services.ServicesMenu;

import java.util.LinkedList;
import java.util.Scanner;

import static Main.CategoryManagment.categoryManagment;
import static Main.ItemManagment.itemManagment;
import static Main.OrderManager.orderManager;
import static Services.ServicesMenu.displayMenu;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        // Declare 'menu' linked list that has categories for customer
        LinkedList<category> menu = new LinkedList<>();
        do {
            System.out.println("<-> <-> <-> Menu <-> <-> <->");
            do {
                System.out.println(" 1) Management Category ");
                System.out.println(" 2) Management Item ");
                System.out.println(" 3) Display Menu ");
                System.out.println(" 4) Management Order ");
                System.out.println(" 0) Exit ");

                System.out.print("Enter your choice :");
                choice = input.nextInt();

            }while(choice <0 || choice > 4);
            switch (choice){
                case 1:
                    System.out.println("<-> <-> Management Category <-> <->");
                    categoryManagment(menu);
                    break;
                case 2:
                    System.out.println("<-> <-> Management Item <-> <->");
                    itemManagment(menu);
                    break;
                case 3:
                    System.out.println("<-> <-> Display Menu <-> <->");
                    displayMenu(menu);
                    break;
                case 4:
                    System.out.println("<-> <-> Management Order <-> <->");
                    displayMenu(menu);
                    orderManager(menu);
                    break;
                case 0:
                    System.out.println("Exit.... ");
                    break;
            }
        }while (choice != 0);

    }


}