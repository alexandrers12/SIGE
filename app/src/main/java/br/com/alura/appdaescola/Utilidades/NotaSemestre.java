package br.com.alura.appdaescola.Utilidades;

/**
 * Created by Everton on 28/06/2016.
 */
public class NotaSemestre {

    private int periodo;

    private float nota;

    public NotaSemestre(int Periodo, float Nota){
        this.periodo = Periodo;
        this.nota = Nota;
    }

    public int getPeriodo() {
        return periodo;
    }

    public float getNota() {
        return nota;
    }
}
