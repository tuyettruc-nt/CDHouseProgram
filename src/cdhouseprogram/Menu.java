/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cdhouseprogram;

import java.io.IOException;
import java.util.Scanner;
import manager.Manager;
import manager.Validation;

/**
 *
 * @author HpEnvy
 */
public class Menu {
    Validation valid = new Validation();
    
    private final String[] ops = {
        "Add CD.",
        "Search CD.",
        "Display information.",
        "Update CD.",
        "Save to file.",
        "Print all list CD."};
    
    private int getChoice() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < ops.length; i++) {
            System.out.println((i+1)+", "+ ops[i]);
        }
        return valid.inputInt("Input your choice: ", 1, 6);
    }
    
    public void display() throws IOException {
        Manager m = new Manager();
        m.loadFromFile();
        int choice;
        boolean ask = false;
        do{
            System.out.println("=================================");
            choice = getChoice();
            switch(choice) {
                case 1:
                    m.addCD();
                    ask = valid.check("Do you want to continue? (Y/N): ");
                    break;
                case 2:
                    m.searchCD();
                    ask = valid.check("Do you want to continue? (Y/N): ");
                    break;
                case 3:
                    break;
                case 4:
                    m.updateInfor();
                    ask = valid.check("Do you want to continue? (Y/N): ");
                    break;
                case 5:
                    m.saveToFile();
                    ask= valid.check("Do you want to continue? (Y/N): ");
                    break;
                case 6:
                    m.print();
                    ask= valid.check("Do you want to continue? (Y/N): ");
                    break;
                default:
                    System.out.println("Invalid. Try input to again!");
                    break;
            }
        }while(choice != 7 && ask == true);
    }
    
}
