package sample.controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author USER
 */
import java.util.ArrayList;
import java.util.Scanner;
import sample.dto.I_Menu;
import sample.utils.Utils;

public class Menu extends ArrayList<String> implements I_Menu {

    public Menu() {
        super();
    }
    // must implement all abstract method of I_Menu interface

    @Override
    public void addItem(String s) {
        this.add(s);
    }

    @Override
    public void showMenu() {
        System.out.println("========== MENU ==========");
        for (String item : this) {
            System.out.println(item);
        }
        System.out.println("==========================");
    }

    @Override
    public boolean confirmYesNo(String welcome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getChoice() {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        try {
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input, please enter a valid number.");
        }

        return choice;
    }

}
