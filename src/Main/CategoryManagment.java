package Main;

import Entity.category;
import Services.ServicesMenu;

import java.util.LinkedList;

import static Main.Main.input;

public class CategoryManagment {
    public static void categoryManagment(LinkedList<category> menu){
        // Variables
        int choice = 0;

        do {
            do {
                System.out.println("1) Add Category ");
                System.out.println("2) Delete Category ");
                System.out.println("3) Modify Category ");
                System.out.println("0) Exit ");


                System.out.print("Put your choice :");
                choice = input.nextInt();
            }while(choice < 0 || choice > 3);

            switch (choice){
                case 1:
                    System.out.println("<-> Add Category <->");
                    category c = new category();
                    ServicesMenu.addCategory(c);
                    menu.add(c);
                    break;
                case 2:
                    System.out.println("<-> Delete Category <->");
                    System.out.print("Put the name of category you wanna to remove :");
                    String rem = input.nextLine();
                    menu.removeFirstOccurrence(rem);
                    break;
                case 3:
                    System.out.println("<-> Modify Category <->");
                    System.out.print("Put the category name you will change it :");
                    String x = input.nextLine();
                    ServicesMenu.renameCategory(menu, x);
                    break;
                case 0:
                    System.out.println("Exit...");
                    break;
                default:
                    System.out.println("Error, your choice isn't exist ");
            }
        }while(choice != 0);
    }
}
