package br.com.alura.appdaescola;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Everton on 26/06/2016.
 */
public class ListaItemFrequencia extends ArrayAdapter<Item_Frequencia> {

    private Context contexto;
    private ArrayList<Item_Frequencia> listaDeItens;

    public ListaItemFrequencia(Context Contexto, ArrayList<Item_Frequencia> ListaDeItens){
        super(Contexto, 0, ListaDeItens);
        this.contexto = Contexto;
        this.listaDeItens = ListaDeItens;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Item_Frequencia item = this.listaDeItens.get(position);

        convertView = LayoutInflater.from(this.contexto).inflate(R.layout.item_frequencia, null);

        TextView nome = (TextView) convertView.findViewById(R.id.textView2);
        nome.setText(item.getNome());

        TextView disciplina = (TextView) convertView.findViewById(R.id.textView3);
        disciplina.setText(item.getDisciplaina());

        TextView faltas = (TextView) convertView.findViewById(R.id.textView4);
        faltas.setText(item.getFaltas());

        return convertView;
    }
}
