package br.com.alura.appdaescola;

import java.util.Dictionary;

/**
 * Created by Everton on 26/06/2016.
 */
public class Item_Frequencia {
    private String nome;
    private String disciplina;
    private String faltas;
    //Dicionário guarda o nome da disciplina e a quantidade de faltas.
    //private Dictionary<String, String> disciplinasEFaltas;

    public Item_Frequencia(String Nome, String Disciplina, String Faltas){
        this.nome = Nome;
        this.disciplina = Disciplina;
        this.faltas = Faltas;
    }

    public String getNome() {
        return nome;
    }

    public String getDisciplaina() {
        return disciplina;
    }

    public String getFaltas() {
        return faltas;
    }
}
