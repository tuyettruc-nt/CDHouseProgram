/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager;

import java.util.Scanner;

/**
 *
 * @author HpEnvy
 */
public class Validation {
    private static final Scanner in = new Scanner(System.in);
    private Scanner sc = new Scanner(System.in);
    
    public String inputPattern(String msg) {
        System.out.println(msg);
        while(true){
            try{
                String input = "^CD[0-9]\\d[0-9]";
                if (input != null && input.length()>=5) {
                    return input;
                }else {
                    System.out.println("Please follow to format!(CD...)");
                }
            }catch(Exception e) {
                System.err.println("Wrong format!");
            }
        }
    }
    
    public String inputStr(String msg) {
        String data;
        do {
            System.out.println(msg);
            data = sc.nextLine().trim().toUpperCase().replace(" ", "_");
        } while(data.length()==0);
        return data;
    }
    
    public int inputInt(String msg, int min, int max) {
        System.out.println(msg);
        while(true) {
            String input = sc.nextLine();
            try{
                int number = Integer.parseInt(input);
                if(number < min || number > max) {
                    System.out.println("Please input between "+min+" and "+max);
                    continue;
                }
                return number;
            }catch(Exception e) {
                System.err.println("Please input integer number!");
            }
        }
    }
    
    public float inputFloat(String msg, float min, float max) {
        System.out.println(msg);
        while(true) {
            String input = sc.nextLine();
            try{
                float number = Float.parseFloat(input);
                if(number < min || number > max) {
                    System.out.println("Please input between "+min+" and "+max);
                    continue;
                }
                return number;
            }catch(Exception e){
                System.err.println("Please input float number!");
            }
        }
    }
    
    public boolean check(String msg){
        System.out.println(msg);
        while(true) {
            String result = sc.nextLine();
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            if (result.equalsIgnoreCase("N")) {
                System.out.println("Exit program!");
                return false;
            }
            System.out.println("Please input n/N or Y/y!");
            System.out.println("Input again: ");
        }
    }
}
