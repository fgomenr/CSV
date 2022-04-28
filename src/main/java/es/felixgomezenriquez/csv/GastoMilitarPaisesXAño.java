package es.felixgomezenriquez.csv;

import java.util.ArrayList;

//Esta clase tiene el arraylist de cada GastoMilitar con sus metodos get and set correspondientes

public class GastoMilitarPaisesXAño {

    private ArrayList<GastoMilitar> paisesXAño = new ArrayList();

    public ArrayList<GastoMilitar> getpaisesXAño() {
        return paisesXAño;
    }

    public void setpaisesXAño(ArrayList<GastoMilitar> paisesXAño) {
        this.paisesXAño = paisesXAño;
    }

}
