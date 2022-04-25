/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.felixgomezenriquez.csv;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author usuario
 */
public class LayoutTabla extends TableView<String> {
    
    
    public LayoutTabla(){
    
        this.setEditable(true);  

        this.setColumnResizePolicy (TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn pais = new TableColumn("Country");  
        TableColumn año = new TableColumn("Year");  
        TableColumn gastoMilitarMaximo = new TableColumn("Maximum Miitary Spend");  

        this.getColumns().addAll(pais, año, gastoMilitarMaximo); 
        
        pais.setCellValueFactory(new PropertyValueFactory<>("pais"));
        año.setCellValueFactory(new PropertyValueFactory<>("AnnoGastoMilitar"));
        pais.setCellValueFactory(new PropertyValueFactory<>("AnnoGastoMilitar"));
    }
    

    static public void ActualizarTabla(String pais,String anno, String gastoMilitarMaximo){
        
        //Da problemas metodo statico de layoutCHeck box ese maricon
        
          LayoutTabla.getItems().add(0,pais);
    
    }
    
}
