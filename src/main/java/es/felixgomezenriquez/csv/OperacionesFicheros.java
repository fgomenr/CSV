/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.felixgomezenriquez.csv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author usuario
 */
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

            //SALTAR LAS LINEAS DE LA PRIMERA FILAA
            String texto = br.readLine();

            texto = br.readLine();
            
            String paisAnterior= " ";

            // Repetir mientras no se llegue al final del fichero
            while (texto != null) {

                System.out.println(texto);
                                
                String[] valores = texto.split(",");
                
                String paisActual= valores[0];
                
                int  añoActual=Integer.parseInt(valores[2]);
                
                long gastoMilitarActual=Long.parseLong(valores[3]);
                
                System.out.println(valores.length);
                System.out.println("PaisAnterior:" + paisAnterior);

                System.out.println("PaisActual:" + paisActual);

                
                if (paisActual.equals(paisAnterior)) {

                    System.out.println("Los paises son iguales");


                    AnnoGastoMilitar annoGastoMilitar=new AnnoGastoMilitar();
                    annoGastoMilitar.setAnno(añoActual);
                    annoGastoMilitar.setGastoMilitar(gastoMilitarActual);

                    gastoMilitar.getAnnoGastoMilitar().add(annoGastoMilitar);


                    
                }else if(!paisActual.equals(paisAnterior)){
                    
                    System.out.println("Los paises son distintos");
                    
                    this.gastoMilitar=new GastoMilitar();

                    gastoMilitar.setPais(valores[0]);
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
        } // Captura de cualquier otra excepción
        catch (Exception ex) {
            System.out.println("Error de lectura del fichero");
            ex.printStackTrace();
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
