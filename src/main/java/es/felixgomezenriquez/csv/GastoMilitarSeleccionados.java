/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.felixgomezenriquez.csv;

/**
 *
 * @author usuario
 */
public class GastoMilitarSeleccionados {
    
    private String pais;
    private String anno;
    private String gastoMilitar;
    
    public GastoMilitarSeleccionados(String pais,String anno,String gastoMilitar){
    
        this.pais=pais;
        this.anno=anno;
        this.gastoMilitar=gastoMilitar;
    
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getAnno() {
        return anno;
    }

    public void setAnno(String anno) {
        this.anno = anno;
    }

    public String getGastoMilitar() {
        return gastoMilitar;
    }

    public void setGastoMilitar(String gastoMilitar) {
        this.gastoMilitar = gastoMilitar;
    }
    
}
