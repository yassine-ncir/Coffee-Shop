package Main;

import Entity.category;
import Services.ServicesMenu;

import java.util.LinkedList;

import static Main.Main.input;
import static Services.ServicesMenu.deleteItemFromCategory;
import static Services.ServicesMenu.modifyItemInCategory;
import static java.awt.SystemColor.menu;
import static Services.ServicesMenu.*;
public class OrderManager {
    public static void orderManager(LinkedList<category> menu) {
        int choice ;
        do {
            do {
                System.out.println("1) Create Order ");
                System.out.println("2) Display Order ");
                System.out.println("0) Exit ");

                System.out.print("Put your choice :");
                choice = input.nextInt();
                input.nextLine(); // Consume newline
            }while(choice < 0 ||choice > 2);
            switch (choice){
                case 1:
                    System.out.println("<-> Create Order <->");
                    ServicesMenu.initOrder(menu);
                    break;
                case 2:
                    System.out.println("<-> Display Order <->");
                    break;
                case 0:
                    System.out.println("Exit...");
                    break;
                default:
                    System.out.println("Error, your choice isn't exist ");
            }
        }while (choice != 0);

    }
}

