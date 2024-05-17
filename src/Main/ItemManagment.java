package Main;

import Entity.category;
import Services.ServicesMenu;

import java.util.LinkedList;

import static Main.Main.input;
import static Services.ServicesMenu.*;

public class ItemManagment {
    public static void itemManagment(LinkedList<category> menu) {
        int choice;

        do {
            do {
                System.out.println("1) Add Item ");
                System.out.println("2) Delete Item ");
                System.out.println("3) Modify Item ");
                System.out.println("0) Exit ");

                System.out.print("Put your choice :");
                choice = input.nextInt();
                input.nextLine(); // Consume newline
            } while (choice < 0 || choice > 3);

            switch (choice) {
                case 1:
                    System.out.println("<-> Add Item To Category <->");
                    addItemToCategory(menu);
                    break;
                case 2:
                    System.out.println("<-> Delete Item From Category <->");
                    deleteItemFromCategory(menu);
                    break;
                case 3:
                    System.out.println("<-> Modify Item In Category <->");
                    modifyItemInCategory(menu);
                    break;
                case 0:
                    System.out.println("Exit...");
                    break;
                default:
                    System.out.println("Error, your choice isn't exist ");
            }
        } while (choice != 0);
    }


}
