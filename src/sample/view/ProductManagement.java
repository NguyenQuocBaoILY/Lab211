package sample.view;

import sample.dto.I_List;
import sample.dto.I_Menu;
import sample.controllers.Menu;
import sample.controllers.ProductList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hoa Doan
 */
public class ProductManagement {

    public static void main(String args[]) {
        I_Menu menu = new Menu();
        menu.addItem("1. Create new product");
        menu.addItem("2. Search Product information by name");
        menu.addItem("3. Update a product");
        menu.addItem("4. Delete Product information");
        menu.addItem("5: Save to file");
        menu.addItem("6: Print all lists from files");
        int choice;
        boolean cont = true;
        I_List list = new ProductList();
        do {
            menu.showMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    list.add();
                    break;
                case 2:
                    list.search();
                    break;
                case 3:
                    list.update();
                    break;
                case 4:
                    list.remove();
                    break;
                case 5:
                    cont = menu.confirmYesNo("Do you want to quit?(Y/N)");
                    break;
            }
        } while (choice >= 0 && choice <= 5 && !cont);
    }
}
