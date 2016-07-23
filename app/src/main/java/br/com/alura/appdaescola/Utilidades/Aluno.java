package br.com.alura.appdaescola.Utilidades;

import java.util.ArrayList;

/**
 * Created by Everton on 26/06/2016.
 */
public class Aluno {

    private String nome;

    private String idade;

    private String serie;

    private ArrayList<Disciplinas> listaDeDisciplinas;

    public Aluno(String Nome, String Idade, String Serie){
        this.nome = Nome;
        this.idade = Idade;
        this.serie = Serie;
    }

    public String getNome() {
        return nome;
    }

    public void setListaDeDisciplinas(ArrayList<Disciplinas> listaDeDisciplinas) {
        this.listaDeDisciplinas = listaDeDisciplinas;
    }

    public String getIdade() {
        return idade;
    }

    public String getSerie() {
        return serie;
    }

    public ArrayList<Disciplinas> getListaDeDisciplinas() {
        return listaDeDisciplinas;
    }
}
