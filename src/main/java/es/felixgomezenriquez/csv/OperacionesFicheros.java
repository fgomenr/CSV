package es.felixgomezenriquez.csv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javafx.scene.control.Alert;


public class OperacionesFicheros {

    String nombreFichero = "military-expenditure-total.csv";
    
    GastoMilitar gastoMilitar = new GastoMilitar();
    


    
//Metodo que lee un fichero csv y extrae la informacion 
    public void leerFichero(GastoMilitarPaisesXAño listaPaises) {

// Declarar una variable BufferedReader
        BufferedReader br = null;
        try {
            // Crear un objeto BufferedReader al que se le pasa 
            //   un objeto FileReader con el nombre del fichero
            br = new BufferedReader(new FileReader(nombreFichero));
            // Leer la primera línea, guardando en un String

            String texto = br.readLine();

            //Saltamos la linea de la primera fila ya que contiene informacion
            //que no nos interesa guardar
            texto = br.readLine();
            
            //Variable de control usada en una comprobacion para no repetir los paises
            //Es decir solo crea un objeto GastoMilitar por cada Pais.
            String paisAnterior= " ";

            // Repetir mientras no se llegue al final del fichero
            while (texto != null) {

                System.out.println(texto);
                //con el metodo split creamos un array de valores tipo String
                //usando de separador entre esos valores el caracter ","
             
                String[] valores = texto.split(",");
                
                //Colocamos cada valor de el array anterior en una variable que usaremos para crear los
                //objetos de la clase GastoMilitar que guarda la info de cada pais, su codigo, el año y 
                // el gasto militar
                String paisActual= valores[0];
                
                int  añoActual=Integer.parseInt(valores[2]);
                
                long gastoMilitarActual=Long.parseLong(valores[3]);
                
                System.out.println("PaisAnterior:" + paisAnterior);

                System.out.println("PaisActual:" + paisActual);

                //Comprobamos si el PaisAnterior es igual al PaisActual para no crear un nuevo objeto 
                //GastoMilitar y evitar tener varios objetos referenciando al mismo pais
                //Si son iguales si se crea un Objeto de la clase AnnoGastoMilitar, que guarda
                //El año y el gasto militar de ese año, con intencion de manipular los datos de la forma
                //que queramos en un futuro, aunque yo solo saco el gasto militar maximo de un pais
                //y el año correspondiente a ese GastoMilitar
                
                if (paisActual.equals(paisAnterior)) {

                    System.out.println("Los paises son iguales");


                    AnnoGastoMilitar annoGastoMilitar=new AnnoGastoMilitar();
                    annoGastoMilitar.setAnno(añoActual);
                    annoGastoMilitar.setGastoMilitar(gastoMilitarActual);

                    gastoMilitar.getAnnoGastoMilitar().add(annoGastoMilitar);


                //Si no son iguales quiere decir que ha cambiado de pais, entonces si crea un objeto GastoMilitar
                //nuevo que guarde la informacion correspondiente.
                //y se añade a la lista de paises
                }else if(!paisActual.equals(paisAnterior)){
                    
                    System.out.println("Los paises son distintos");
                    
                    this.gastoMilitar=new GastoMilitar();

                    gastoMilitar.setPais(paisActual);
                    gastoMilitar.setCodigo(valores[1]);
                    AnnoGastoMilitar annoGastoMilitar=new AnnoGastoMilitar();
                    annoGastoMilitar.setAnno(añoActual);
                    annoGastoMilitar.setGastoMilitar(gastoMilitarActual);

                    gastoMilitar.getAnnoGastoMilitar().add(annoGastoMilitar);
                    listaPaises.getpaisesXAño().add(gastoMilitar);

                    paisAnterior= paisActual;
                    
                }
                
                // Leer la siguiente línea
                texto = br.readLine();
                
                
            }
        } // Captura de excepción por fichero no encontrado
        catch (FileNotFoundException ex) {
            System.out.println("Error: Fichero no encontrado");
            ex.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("No se ha encontrado el fichero");
            alert.setHeaderText("Comprueba que tienes el fichero en la ruta correspondiente");
            alert.showAndWait();
        } // Captura de cualquier otra excepción
        catch (Exception ex) {
            System.out.println("Error de lectura del fichero");
            ex.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("No se ha podido leer el fichero");
            alert.setHeaderText("Comprueba que tienes el fichero en la ruta correspondiente");
            alert.showAndWait();
        } // Asegurar el cierre del fichero en cualquier caso
        finally {
            try {

                // Cerrar el fichero si se ha podido abrir
                if (br != null) {
                    br.close();
                }
            } catch (Exception ex) {
                System.out.println("Error al cerrar el fichero");
                ex.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("No se ha podido cerrar el fichero");
            alert.setHeaderText("Fallo al intentar cerrar el fichero");
            alert.showAndWait();
            }
        }

    }
    
    
//Metodo que guarda en un fichero .csv el gastomilitar maximo de cada pais
    
    public void guardarFichero(GastoMilitarPaisesXAño listaPaises) throws IOException {

        String nombreFichero = "GastoMilitarMaximo.csv";
        String texto = "Country,Year,Maximum Miitary Spend";
        String pais;
        String año;
        String gastoMilitarMaximo;
        String[] valores=new String[1];
        BufferedWriter bw = new BufferedWriter(new FileWriter(nombreFichero));
        
        bw.write(texto + "\n");
        
        texto="";

        try {
            //Crear un objeto BufferedWriter. Si ya existe el fichero, 
            //  se borra automáticamente su contenido anterior.
            System.out.println("esto contiene el texto antes del bucle: " + texto);
            
            //Escribir en el fichero el texto con un salto de línea
            //En este bucle hacemos una iteracion por cada pais de la lista y usamos el metodo 
            //getannogastomilitar maximo que devuelve un array con 2 valores el año y el gastomilitar
            //de ese año, y formamos un string con un salto de linea alfinal y lo escribimos en el fichero 
            
            for (int i = 0; i < listaPaises.getpaisesXAño().size(); i++) {
            
                System.out.println("Mostrando Nombre del pais: " + i );
                pais= listaPaises.getpaisesXAño().get(i).getPais();
                texto = pais;
                valores=listaPaises.getpaisesXAño().get(i).getAnnoGastoMilitarMaximo();
                año=valores[0];
                gastoMilitarMaximo=valores[1];
                texto = texto +","+año+","+gastoMilitarMaximo;
                System.out.println("texto dentro del bucle vale: " +texto);
                bw.write(texto + "\n");
                texto="";
            }    
                        
        } // Comprobar si se ha producido algún error
        catch (IOException ex) {
            System.out.println("Error de escritura del fichero");
            ex.printStackTrace();
        } // Asegurar el cierre del fichero en cualquier caso
        finally {
            try {
                // Cerrar el fichero si se ha podido abrir
                if (bw != null) {
                    bw.close();
                }
            } catch (Exception ex) {
                System.out.println("Error al cerrar el fichero");
                ex.printStackTrace();
            }
        }

    }

}
