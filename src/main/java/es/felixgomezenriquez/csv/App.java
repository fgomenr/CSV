package es.felixgomezenriquez.csv;

import java.io.IOException;
import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.controlsfx.control.CheckComboBox;

/**
 * JavaFX App
 */
public class App extends Application {

    
    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();
        var scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.show();

        GastoMilitarPaisesXAño listaPaises= new GastoMilitarPaisesXAño();
        
        
        OperacionesFicheros op=new OperacionesFicheros();
        
        LayoutTabla tabla =new LayoutTabla();
        
        
        root.setCenter(tabla);
                
        op.leerFichero( listaPaises);
        
        
        try {
            op.guardarFichero(listaPaises);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        LayoutCheckComboBox checkComboBox = new LayoutCheckComboBox(listaPaises,tabla);
        
        root.setRight(checkComboBox);
        
 

        //INFORMACION DE EL GASTO MILITAR POR AÑO DE CADA PAIS

        for (int i = 0; i < listaPaises.getpaisesXAño().size(); i++) {
            
            System.out.println("Mostrando Nombre del pais: " + i );
            System.out.println(listaPaises.getpaisesXAño().get(i).getPais());
            
            for (int j = 0; j < listaPaises.getpaisesXAño().get(i).getAnnoGastoMilitar().size(); j++) {
                
                System.out.println("Mostrando años y gasto militar:");
                System.out.println(String.valueOf(listaPaises.getpaisesXAño().get(i).getAnnoGastoMilitar().get(j).getAnno()) +" "+
                        String.valueOf(listaPaises.getpaisesXAño().get(i).getAnnoGastoMilitar().get(j).getGastoMilitar()));
                
            }
        }
        
        
        
        
    }

    public static void main(String[] args) {
        launch();
    }

}
