/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.felixgomezenriquez.csv;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author usuario
 */
public class LayoutTabla extends TableView<GastoMilitarSeleccionados> {
    
    
    public LayoutTabla(){
    
        this.setEditable(true);  

        this.setColumnResizePolicy (TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn pais = new TableColumn("Country");  
        TableColumn año = new TableColumn("Year");  
        TableColumn gastoMilitarMaximo = new TableColumn("Maximum Miitary Spend");  

        this.getColumns().addAll(pais, año, gastoMilitarMaximo); 
        pais.setMinWidth(100);
        año.setMinWidth(100);
        gastoMilitarMaximo.setMinWidth(100);
        pais.setCellValueFactory(new PropertyValueFactory<GastoMilitarSeleccionados,String>("pais"));
        año.setCellValueFactory(new PropertyValueFactory<GastoMilitarSeleccionados,String>("anno"));
        gastoMilitarMaximo.setCellValueFactory(new PropertyValueFactory<GastoMilitarSeleccionados,String>("gastoMilitar"));
    }
    

    public void ActualizarTabla(ArrayList paisesSeleccionados){
       this.getItems().clear();
       ObservableList<GastoMilitarSeleccionados> oPaisesSeleccionados =
               FXCollections.observableArrayList(paisesSeleccionados);
       
       this.setItems(oPaisesSeleccionados);
        
        
    }
    
}
