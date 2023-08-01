/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager;

import enity.CD;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author HpEnvy
 */
public class Manager {
    ArrayList<CD> CDs = new ArrayList<>();
    Validation valid = new Validation();
    
    private int checkCDName(String name){
        for (int i = 0; i < CDs.size(); i++) {
            if (CDs.get(i).getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }
    private int checkCDID(String ID) {
        for (int i = 0; i < CDs.size(); i++) {
            if(CDs.get(i).getID().equals(ID))
                return i;
        }
        return -1;
    }
    
    public void addCD(){
        String name, type, title, ID;
        int publishing;
        float unitPrice;
        ID = valid.inputStr("Enter ID: ");
        do {
            if(checkCDID(ID)>=0) {
                System.out.println("Please input again. Data is duplicate!");
                ID = valid.inputPattern("Enter ID:");
            }else {
                break;
            }
        }while(true);
        
        name = valid.inputStr("Enter name: ");
        do{
            if(checkCDName(name)>=0) {
                System.out.println("Please input again. Data is duplicate!");
                name = valid.inputStr("Enter name: ");
            }else {
                break;
            }
        }while(true);
        
        type = valid.inputStr("Enter type: ");
        title = valid.inputStr("Enter title: ");
        publishing = valid.inputInt("Enter year publishing: ", 1000, 2022);
        unitPrice = valid.inputFloat("Enter unit price: ", 0, 10000);
        CDs.add(new CD(ID, name, type, title, publishing, unitPrice));
    }
    
    public void checkCDExist() {
        String name = valid.inputStr("Enter name: ");
        if (name.isEmpty()) {
            System.out.println("The list is empty!");
        }
        if (checkCDName(name) >= 0) {
            System.out.println("CD is exist!");
        }else {
            System.out.println("No CD not found!");
        }
    }
    
    public void searchCD() {
        String name = valid.inputStr("Enter name: "); 
        if (name.isEmpty()) {
            System.out.println("Have no any CD!");
        }else {
            int[] pos = checkCDs(name.toUpperCase());
            if (pos.length == 0) {
                System.out.println("CD does not exist!");
            }else {
                for (int i = 0; i < pos.length; i++) {
                    System.out.println(CDs.get(pos[i]));
                }
            }
        }
    }
    
    public int[] checkCDs(String name) {
        ArrayList<Integer> tmp = new ArrayList<>();
        int[] index;
        for (int i = 0; i < CDs.size(); i++) {
            if(CDs.get(i).getName().contains(name)) {
                tmp.add(i);
            }
        }
        index = new int[tmp.size()];
        for (int i = 0; i < index.length; i++) {
            index[i] = tmp.get(i);
        }
        return index;
    }
    public void deleteCD() {
        if (CDs.isEmpty()) {
            System.out.println("The list is empty. So delete can not performance!");
        } else{
            String ID = valid.inputStr("Enter ID: ");
            for(int i = 0; i < CDs.size(); i++) {
                if(CDs.get(i).getID().contains(ID)) {
                    CDs.remove(i);
                    System.out.println("Delete successfully!");
                    return;
                }
            } System.out.println("ID of CD does not exist!");
        }
    }
    
    public void updateCD(int index) {
        boolean ask;
        if(CDs.isEmpty()) {
            System.out.println("The list is empty!"); 
        }
            ask = valid.check("Do you want to update new ID? (Y/N): ");
            if(ask) {
                String newID = valid.inputPattern("Enter new ID: ");
                CDs.get(index).setID(newID);
            }
            ask = valid.check("Do you want to update new name? (Y/N): ");
            if(ask) {
                do {
                    String newName = valid.inputStr("Enter new name: ");
                    if (checkCDName(newName) == -1 || checkCDName(newName) == index) {
                        CDs.get(index).setName(newName);
                        break;
                    }else{
                        System.out.println("CD name is exist!");
                    }
                }while(true);
            }

            ask = valid.check("Do you want to update new type? (Y/N): ");
            if(ask) {
                String newType = valid.inputStr("Enter new type: ");
                CDs.get(index).setType(newType);
            }
            ask = valid.check("Do you want to update new title? (Y/N): ");
            if(ask) {
                String newTitle = valid.inputStr("Enter new title: ");
                CDs.get(index).setTitle(newTitle);
            }
            ask = valid.check("Do you want to update new publishing? (Y/N): ");
            if(ask) {
                int newPublishing = valid.inputInt("Enter new publishing: ", 1000, 2022);
                CDs.get(index).setPublishing(newPublishing);
            }
            ask = valid.check("Do you want to update new unitprice? (Y/N): ");
            if(ask) {
                float newUnitPrice = valid.inputFloat("Enter new unitprice: ", 0, 10000);
                CDs.get(index).setUnitPrice(newUnitPrice);
            }
        System.out.println("Updated information successfully!");
    }
    public void updateInfor() {
        String checkID = valid.inputStr("Enter ID: ");
        int index = checkCDID(checkID);
        if (checkCDID(checkID) == -1 || CDs.isEmpty()) {
            System.out.println("ID does not exist!");
        }else {
            System.out.println("1. Update CD information");
            System.out.println("2. Delete CD information");
            int choice = valid.inputInt("Input your choice: ", 1, 2);
            if(choice == 1) {
                updateCD(index);
            }
            if(choice == 2) {
                deleteCD();
            }
        }
    }
    public void print() {
        if(CDs.isEmpty()) {
            System.out.println("The list is empty");
        }else {
            for (int i = 0; i < CDs.size(); i++) {
                System.out.println(CDs.get(i));
            }
        }
    }
    public boolean saveToFile() throws IOException {
        File f;
        PrintWriter pw = null;
        FileWriter fw = null;

        if (CDs.isEmpty()) {
            System.out.println("The list empty!");
            return false;
        }
        try {
            f = new File("D:\\PRO192\\Session_Exercise\\Exercise01\\CDHouseProgram\\CD.txt");
            fw = new FileWriter(f);
            pw = new PrintWriter(fw);
            for (int i = 0; i < CDs.size(); i++) {
                pw.println(CDs.get(i).getID() + ", " + 
                CDs.get(i).getName() + ", " + CDs.get(i).getType() +
                ", " + CDs.get(i).getTitle() + ", " + CDs.get(i).getPublishing()
                +", "+ CDs.get(i).getUnitPrice());        
            } System.out.println("Save done!");
        }catch (IOException e) {
            System.out.println(e);
            System.out.println("Save error!");
        }finally {
            pw.close();
            fw.close();
        }return true;
        }
        
    public boolean loadFromFile() throws IOException {
        File f;
        BufferedReader br = null;
        FileReader fr = null;
        try {
            f = new File("D:\\PRO192\\Session_Exercise\\Exercise01\\CDHouseProgram\\CD.txt");
            if (!f.exists()) {
                System.out.println("File does not exist!");
                return false;
            }
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            String line;
            while((line = br.readLine()) != null) {
                StringTokenizer stk = new StringTokenizer(line, ", ");
                String loadID = stk.nextToken();
                String loadName = stk.nextToken();
                String loadType = stk.nextToken();
                String loadTitle = stk.nextToken();
                int loadPublishing = Integer.parseInt(stk.nextToken());
                float loadUnitPrice = Float.parseFloat(stk.nextToken());
                CD p = new CD(loadID, loadName, loadType, loadTitle, loadPublishing, loadUnitPrice);
                CDs.add(p);
            }                        
        }catch (Exception e) {
            System.out.println("Error: " + e);
            return false; 
        }finally{
            br.close();
            fr.close();
        }
        return true;
    }
}
