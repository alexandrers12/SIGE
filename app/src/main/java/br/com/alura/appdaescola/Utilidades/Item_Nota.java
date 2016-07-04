package br.com.alura.appdaescola.Utilidades;

/**
 * Created by Everton on 28/06/2016.
 */
public class Item_Nota {
    private String periodo;
    private String notaPeriodo;

    public Item_Nota(String Periodo, String Nota){
        this.periodo = Periodo;
        this.notaPeriodo = Nota;
    }

    public String getPeriodo() {
        return periodo;
    }

    public String getNotaPeriodo() {
        return notaPeriodo;
    }
}
