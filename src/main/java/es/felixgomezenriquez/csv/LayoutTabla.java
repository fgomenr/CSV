/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.felixgomezenriquez.csv;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 *
 * @author usuario
 */
public class LayoutTabla extends TableView {
    
    
    public LayoutTabla(){
    
        this.setEditable(true);  

        this.setColumnResizePolicy (TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn pais = new TableColumn("Country");  
        TableColumn año = new TableColumn("Year");  
        TableColumn gastoMilitarMaximo = new TableColumn("Maximum Miitary Spend");  

        this.getColumns().addAll(pais, año, gastoMilitarMaximo);  
    }
    
    
    
    
}
