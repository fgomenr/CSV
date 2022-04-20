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
public class AnnoGastoMilitar {
    
    private int anno;
    private long gastoMilitar;
    
    public int getAnno(){
        return this.anno;
    }
    public void setAnno(int anno){
        this.anno=anno;
    }
    
    public long getGastoMilitar(){
        return this.gastoMilitar;
    }
    public void setGastoMilitar(long gastoMilitar){
        this.gastoMilitar=gastoMilitar;
    }
    
    
//    Collections.sort(personas, new Comparator<Persona>() {
//	@Override
//	public int compare(Persona p1, Persona p2) {
//		return new Integer(p1.getEdad()).compareTo(new Integer(p2.getEdad()));
//	}
//});
//     
    
}
