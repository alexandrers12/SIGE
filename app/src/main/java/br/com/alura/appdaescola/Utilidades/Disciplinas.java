package br.com.alura.appdaescola.Utilidades;

import java.util.ArrayList;
import java.util.Dictionary;

/**
 * Created by Everton on 26/06/2016.
 */
public class Disciplinas {

    private String nome;

    private ArrayList<Item_Nota> listaNotas;

    private String faltas;

    public Disciplinas(String Nome, ArrayList<Item_Nota> ListaDeNotas, String Falta){
        this.nome = Nome;
        this.listaNotas = ListaDeNotas;
        this.faltas = Falta;
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Item_Nota> getListaNotas() {
        return listaNotas;
    }

    public String getFaltas() {
        return faltas;
    }
}
