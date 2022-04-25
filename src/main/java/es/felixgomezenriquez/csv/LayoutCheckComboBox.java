/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.felixgomezenriquez.csv;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.layout.VBox;
import org.controlsfx.control.CheckComboBox;

/**
 *
 * @author usuario
 */
public class LayoutCheckComboBox extends VBox{
    
    public static GastoMilitarPaisesXAño listaPaises= new GastoMilitarPaisesXAño();

    public LayoutCheckComboBox(GastoMilitarPaisesXAño listaPaises ){
        
        this.listaPaises=listaPaises;
        final ObservableList<String> opciones = FXCollections.observableArrayList();
        for (int i = 0; i < this.listaPaises.getpaisesXAño().size(); i++) {
            opciones.add(this.listaPaises.getpaisesXAño().get(i).getPais());
        }

        final CheckComboBox<String> checkComboBox = new CheckComboBox<String>(opciones);
        checkComboBox.getCheckModel().getCheckedItems().addListener( new ListChangeListener<String>() {
            public void onChanged(ListChangeListener.Change<? extends String> c) {
                
                ObservableList<Integer> selectedIndices = checkComboBox.getCheckModel().getCheckedIndices();
                
                
                for (int i = 0; i < LayoutCheckComboBox.listaPaises.getpaisesXAño().size(); i++) {
                    
                    String pais= listaPaises.getpaisesXAño().get(i).getPais();
                    String[] valores = listaPaises.getpaisesXAño().get(i).getAnnoGastoMilitarMaximo();
                    String anno = valores[0];
                    String gastoMilitarMaximo= valores[1];
                    
                    LayoutTabla.ActualizarTabla(pais,anno,gastoMilitarMaximo);
                    
                }
                
                System.out.println(checkComboBox.getCheckModel().getCheckedIndices());
                
                
                
            }
        });
        
        
    
        this.getChildren().add(checkComboBox);
    
    
    }
    
    
}
