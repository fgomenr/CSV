package es.felixgomezenriquez.csv;

//Esta clase guarda la informacion del año y el gasto militar
//De estos objetos se crea un arraylist en la clase GastoMilitar
//para guardar cada año con cada gasto militar para posteriores operaciones
//Yo en este caso solo uso el gastomilitar maximo y su año. Obteniendolo
//con un metodo creado por mí.
public class AnnoGastoMilitar {

    private int anno;
    private long gastoMilitar;

    public int getAnno() {
        return this.anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public long getGastoMilitar() {
        return this.gastoMilitar;
    }

    public void setGastoMilitar(long gastoMilitar) {
        this.gastoMilitar = gastoMilitar;
    }

}
