package es.felixgomezenriquez.csv;

import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

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

        //Creamos los objetos necesarios para el proyecto
        GastoMilitarPaisesXAño listaPaises = new GastoMilitarPaisesXAño();

        OperacionesFicheros op = new OperacionesFicheros();

        LayoutTabla tabla = new LayoutTabla();

        op.leerFichero(listaPaises);

        //Se crea bloque try/catch para capturar las excepciones de la generacion del fichero
        try {
            op.guardarFichero(listaPaises);
        } catch (IOException ex) {
            ex.printStackTrace();
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("No se ha podido guardar el fichero .csv");
            alert.setHeaderText("Comprueba que tienes el fichero en la ruta correspondiente");
            alert.showAndWait();
        }

        LayoutCheckComboBox checkComboBox = new LayoutCheckComboBox(listaPaises, tabla);

        //Se añade a la pantalla la tabla y el checkcombobox
        root.setCenter(tabla);
        root.setRight(checkComboBox);

        
        //INFORMACION DE EL GASTO MILITAR POR AÑO DE CADA PAIS 
        //para comprobar que se han guardado correctamente los datos en los 2
        //arraylist
        for (int i = 0; i < listaPaises.getpaisesXAño().size(); i++) {

            System.out.println("Mostrando Nombre del pais: " + i);
            System.out.println(listaPaises.getpaisesXAño().get(i).getPais());
            System.out.println("");

            for (int j = 0; j < listaPaises.getpaisesXAño().get(i).getAnnoGastoMilitar().size(); j++) {

                System.out.println("Mostrando años y gasto militar:");
                System.out.println(String.valueOf(listaPaises.getpaisesXAño().get(i).getAnnoGastoMilitar().get(j).getAnno()) + " "
                        + String.valueOf(listaPaises.getpaisesXAño().get(i).getAnnoGastoMilitar().get(j).getGastoMilitar()));

            }
            System.out.println("");
        }
        
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("ELIGE UN PAIS");
        alert.setHeaderText("Elige un pais para ver en que año tuvo su gasto militar máximo");
        alert.showAndWait();

    }

    public static void main(String[] args) {
        launch();
    }

}
