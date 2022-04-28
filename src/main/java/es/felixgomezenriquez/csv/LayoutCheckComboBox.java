package es.felixgomezenriquez.csv;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.layout.VBox;
import org.controlsfx.control.CheckComboBox;

public class LayoutCheckComboBox extends VBox {

    private GastoMilitarPaisesXAño listaPaises = new GastoMilitarPaisesXAño();

    private ArrayList<GastoMilitarSeleccionados> paisesSeleccion = new ArrayList();

    public LayoutCheckComboBox(GastoMilitarPaisesXAño listaPaises, LayoutTabla tabla) {

        this.listaPaises = listaPaises;
        final ObservableList<String> opciones = FXCollections.observableArrayList();
        for (int i = 0; i < this.listaPaises.getpaisesXAño().size(); i++) {
            opciones.add(this.listaPaises.getpaisesXAño().get(i).getPais());
        }

        final CheckComboBox<String> checkComboBox = new CheckComboBox<String>(opciones);
        checkComboBox.getCheckModel().getCheckedItems().addListener(new ListChangeListener<String>() {
            public void onChanged(ListChangeListener.Change<? extends String> c) {

                ObservableList<Integer> selectedIndices = checkComboBox.getCheckModel().getCheckedIndices();

                paisesSeleccion.clear();

                for (Integer selectedIndice : selectedIndices) {

                    System.out.println(selectedIndice);

                    String pais = listaPaises.getpaisesXAño().get(selectedIndice).getPais();

                    String anno = String.valueOf(listaPaises.getpaisesXAño().
                            get(selectedIndice).getAnnoGastoMilitarMaximo()[0]);

                    String gastoMilitar = String.valueOf(listaPaises.getpaisesXAño().
                            get(selectedIndice).getAnnoGastoMilitarMaximo()[1]);

                    GastoMilitarSeleccionados gastoMilitarSeleccionados = new GastoMilitarSeleccionados(pais, anno, gastoMilitar);

                    paisesSeleccion.add(gastoMilitarSeleccionados);

                }
                for (int i = 0; i < paisesSeleccion.size(); i++) {
                    System.out.println("");
                    System.out.println(paisesSeleccion.get(i).getPais());
                    System.out.println(paisesSeleccion.get(i).getAnno());
                    System.out.println(paisesSeleccion.get(i).getGastoMilitar());
                    System.out.println("");
                }

                tabla.ActualizarTabla(paisesSeleccion);

            }
        });

        checkComboBox.setTitle("List of countries");
        checkComboBox.maxHeight(100);
        this.maxHeight(100);
        this.maxWidth(100);
        this.getChildren().add(checkComboBox);

    }

}
