package es.felixgomezenriquez.csv;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

//Esta clase extiende de Tableview y contiene una tabla
public class LayoutTabla extends TableView<GastoMilitarSeleccionados> {

    public LayoutTabla() {

        this.setEditable(true);
        this.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        //Creamos una columna por cada dato
        TableColumn pais = new TableColumn("Country");
        TableColumn año = new TableColumn("Year");
        TableColumn gastoMilitarMaximo = new TableColumn("Maximum Miitary Spend");

        //Añadimos las columnas a tabla
        this.getColumns().addAll(pais, año, gastoMilitarMaximo);
        pais.setMinWidth(100);
        año.setMinWidth(100);
        gastoMilitarMaximo.setMinWidth(100);

        pais.setMinWidth(100);
        //Definimos el tipo de dato que va a contener cada columna
        pais.setCellValueFactory(new PropertyValueFactory<GastoMilitarSeleccionados, String>("pais"));
        año.setCellValueFactory(new PropertyValueFactory<GastoMilitarSeleccionados, String>("anno"));
        gastoMilitarMaximo.setCellValueFactory(new PropertyValueFactory<GastoMilitarSeleccionados, String>("gastoMilitar"));
    }

    //Metodo que actualiza la tabla
    public void ActualizarTabla(ArrayList paisesSeleccionados) {
        //Borramos lo que hubiera
        this.getItems().clear();
        //Creamos un OL con el Arraylist que nos pasan por parametros
        ObservableList<GastoMilitarSeleccionados> oPaisesSeleccionados
                = FXCollections.observableArrayList(paisesSeleccionados);
        //Y lo añadimos a la tabla
        this.setItems(oPaisesSeleccionados);

    }

}
