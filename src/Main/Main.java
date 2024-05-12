import jdk.jfr.Category;

import java.util.LinkedList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static Scanner input = new Scanner(System.in);

    public static void categoryManagment(LinkedList<category> menu){
        // Variables
        int choice = 0;

        System.out.println(" <-> <-> Management Category <-> <-> ");
        do {
            do {
                System.out.println("1) Add Category ");
                System.out.println("2) Delete Category ");
                System.out.println("3) Modify Category ");
                System.out.println("0) Exit ");


                System.out.print("Put your choice : ");
                choice = input.nextInt();
            }while(choice < 0 || choice > 3);

            switch (choice){
                case 1:
                    category c = new category();
                    ServicesMenu.addCategory(c);
                    menu.add(c);
                    break;
                case 2:
                    System.out.println("Put the name of category you wanna to remove : ");
                    String rem = input.nextLine();
                    menu.removeFirstOccurrence(rem);
                    break;
                case 3:
                    System.out.println("Put the category name you will change it : ");
                    String x = input.nextLine();
                    menu = ServicesMenu.renameCategory(menu,x);
                    break;
                default:
                    System.out.println("Error, your choice isn't exist ");
            }
        }while(choice != 0);
    }

    public static void itemManagment(LinkedList<category> menu) {
        int choice;

        System.out.println(" <-> <-> Management Item <-> <-> ");
        do {
            do {
                System.out.println("1) Add Item ");
                System.out.println("2) Delete Item ");
                System.out.println("3) Modify Item ");
                System.out.println("0) Exit ");

                System.out.print("Put your choice : ");
                choice = input.nextInt();
                input.nextLine(); // Consume newline
            } while (choice < 0 || choice > 3);

            switch (choice) {
                case 1:
                    ServicesMenu.addItemToCategory(menu);
                    break;
                case 2:
                    //deleteItemFromCategory(menu);
                    break;
                case 3:
                    //modifyItemInCategory(menu);
                    break;
                default:
                    System.out.println("Error, your choice isn't exist ");
            }
        } while (choice != 0);
    }
    public static void main(String[] args) {
        int choice;

        // Declare 'menu' linked list that has categories for customer
        LinkedList<category> menu = new LinkedList<>();
        do {
            do {
                System.out.println(" 1) Management Category ");
                System.out.println(" 2) Management Item ");
                System.out.println(" à) Exit ");

                System.out.print("Enter your choice :  ");
                choice = input.nextInt();

            }while(choice <0 || choice > 3);
            switch (choice){
                case 1:
                    categoryManagment(menu);
                    break;
                case 2:
                    itemManagment(menu);
                    break;
                case 0:
                    System.out.println("Exit.... ");
                    break;
            }
        }while (choice != 0);
        ServicesMenu.displayCategory(menu);

    }
}