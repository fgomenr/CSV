/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.felixgomezenriquez.csv;

import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class GastoMilitar {
    
    private String pais;
    private String codigo;
    //Arrraylist anno gasto militar
    
    private ArrayList<AnnoGastoMilitar> annoGastoMilitar = new ArrayList();
      
    
    public String getPais(){
        return this.pais;
    }
    public void setPais(String pais){
        this.pais=pais;
    }
    
    public String getCodigo(){
        return this.codigo;
    }
    public void setCodigo(String codigo){
        this.codigo=codigo;
    }
    
    public ArrayList<AnnoGastoMilitar> getAnnoGastoMilitar() {
        return annoGastoMilitar;
    }
    
    public void setAnnoGastoMilitar(ArrayList<AnnoGastoMilitar> annoGastoMilitar) {
        this.annoGastoMilitar = annoGastoMilitar;
    }
    
    
    public String toString(int id) {
        String r = "";
        r += "Pais: " + pais + "\n";
        r += "codigo: " + codigo + "\n";
        r += "Año: " + annoGastoMilitar.get(id).getAnno()+ "\n";
        r += "Gasto Militar: " + annoGastoMilitar.get(id).getGastoMilitar()+ "\n";
        return r;
    }
}
