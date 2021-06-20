/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author hp
 */
public class capteur {
     String mac_label,Type,imm,dis;
     int id ;

    public capteur(int i,String mac_label, String Type, String imm,String dis) {
        this.mac_label = mac_label;
        this.Type = Type;
        this.imm = imm;
        this.id=i;
        this.dis=dis;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
     
     

    public String getMac_label() {
        return mac_label;
    }

    public void setMac_label(String mac_label) {
        this.mac_label = mac_label;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getImm() {
        return imm;
    }

    public void setImm(String imm) {
        this.imm = imm;
    }
     
}
