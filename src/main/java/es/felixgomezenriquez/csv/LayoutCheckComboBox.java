package es.felixgomezenriquez.csv;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.layout.VBox;
import org.controlsfx.control.CheckComboBox;

//Clase que engloba todo lo correspondiente al checkcombobox
public class LayoutCheckComboBox extends VBox {
    
    //Este objeto tiene los datos de todos los paises con su correspondiente arraylist para
    //los años y los gastos militares
    private GastoMilitarPaisesXAño listaPaises = new GastoMilitarPaisesXAño();

    //Este arraylist solo tiene la informacion que queremos pasar a la tabla.
    //Pais, año, gastoMilitarMaximo
    private ArrayList<GastoMilitarSeleccionados> paisesSeleccion = new ArrayList();

    //Metodo constructor 
    public LayoutCheckComboBox(GastoMilitarPaisesXAño listaPaises, LayoutTabla tabla) {

        this.listaPaises = listaPaises;
        //Se crea un OL donde se le pasan los nombres de todos los paises de la lista
        //es decir este OL tiene tiene todas las posibles opciones
        final ObservableList<String> opciones = FXCollections.observableArrayList();
        for (int i = 0; i < this.listaPaises.getpaisesXAño().size(); i++) {
            opciones.add(this.listaPaises.getpaisesXAño().get(i).getPais());
        }

        //Se crea el objeto CheckComboBox y se le pasa por parametros la lista de opciones creadas anteriormente
        final CheckComboBox<String> checkComboBox = new CheckComboBox<String>(opciones);
        checkComboBox.setTitle("List of countries");
        
        //Añadimos un listener al checkcombobox que este continuamente viendo si ha cambiado y en funcion
        //del cambio cambiamos lo que muestra la tabla
        checkComboBox.getCheckModel().getCheckedItems().addListener(new ListChangeListener<String>() {
            public void onChanged(ListChangeListener.Change<? extends String> c) {

                //Creamos una OL con las posiciones seleccionadas de las opciones
                ObservableList<Integer> selectedIndices = checkComboBox.getCheckModel().getCheckedIndices();

                //Limpiamos la lista de los paises seleccionados
                paisesSeleccion.clear();

                //Bucle for que por cada posicion de la lista selectedIndices, te
                //da el valor en la variable selectedIndice
                for (Integer selectedIndice : selectedIndices) {

                    System.out.println(selectedIndice);

                    String pais = listaPaises.getpaisesXAño().get(selectedIndice).getPais();

                    String anno = String.valueOf(listaPaises.getpaisesXAño().
                            get(selectedIndice).getAnnoGastoMilitarMaximo()[0]);

                    String gastoMilitar = String.valueOf(listaPaises.getpaisesXAño().
                            get(selectedIndice).getAnnoGastoMilitarMaximo()[1]+" $");

                    //Con las variables anteriores creamos un objeto de gastoMilitarSeleccionados
                    GastoMilitarSeleccionados gastoMilitarSeleccionados = new GastoMilitarSeleccionados(pais, anno, gastoMilitar);
                    //Y lo añadimos a la lista de seleccionados
                    paisesSeleccion.add(gastoMilitarSeleccionados);

                }
                //Mostramos por consola los datos de los paises seleccionados
                for (int i = 0; i < paisesSeleccion.size(); i++) {
                    System.out.println("");
                    System.out.println(paisesSeleccion.get(i).getPais());
                    System.out.println(paisesSeleccion.get(i).getAnno());
                    System.out.println(paisesSeleccion.get(i).getGastoMilitar());
                    System.out.println("");
                }

                //Por ultimo actualizamos la tabla
                tabla.ActualizarTabla(paisesSeleccion);

            }
        });

        //Añadimos el checkcombobox a el layout
        this.getChildren().add(checkComboBox);

    }

}
