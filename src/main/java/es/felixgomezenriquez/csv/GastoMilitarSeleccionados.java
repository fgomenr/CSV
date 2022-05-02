package es.felixgomezenriquez.csv;


//Esta clase solo guarda los datos de los gastos militares de los paises seleccionados.
//Y solo guarda 3 valores, para facilitarnos el trabajo a la hora de crear la tabla
//tiene sus metodos set y gets como todas las clases con atributos privados
public class GastoMilitarSeleccionados {

    private String pais;
    private String anno;
    private String gastoMilitar;

    public GastoMilitarSeleccionados(String pais, String anno, String gastoMilitar) {

        this.pais = pais;
        this.anno = anno;
        this.gastoMilitar = gastoMilitar;

    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getAnno() {
        return anno;
    }

    public void setAnno(String anno) {
        this.anno = anno;
    }

    public String getGastoMilitar() {
        return gastoMilitar;
    }

    public void setGastoMilitar(String gastoMilitar) {
        this.gastoMilitar = gastoMilitar;
    }

}
