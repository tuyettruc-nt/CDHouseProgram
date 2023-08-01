/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enity;

/**
 *
 * @author HpEnvy
 */
public class CD {
    String name;
    String type;
    String title;
    float unitPrice;
    String ID;
    int publishing;

    public CD() {
    }

    public CD(String ID, String name, String type, String title, int publishing, float unitPrice) {
        this.name = name;
        this.ID = ID;
        this.type = type;
        this.title = title;
        this.unitPrice = unitPrice;
        this.publishing = publishing;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getPublishing() {
        return publishing;
    }

    public void setPublishing(int publishing) {
        this.publishing = publishing;
    }

    @Override
    public String toString() {
        return ID + "," + name + ", " + type + ", "+ title + ", " + publishing + ", " + unitPrice;
    }

    
    
    
}
