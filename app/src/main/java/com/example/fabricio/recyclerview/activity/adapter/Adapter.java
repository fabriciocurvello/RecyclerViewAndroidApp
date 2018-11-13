package com.example.fabricio.recyclerview.activity.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fabricio.recyclerview.R;
import com.example.fabricio.recyclerview.activity.model.Filme;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Filme> listaFilmes;

    public Adapter(List<Filme> lista) {
        this.listaFilmes = lista;
    }

    /*
    1 - Inserir acima: extends RecyclerView.Adapter<>
    2 - Criar a classe interna: public class MyViewHolder extends RecyclerView.ViewHolder {
    3 - implementar construtor da classe interna pela ferramenta lâmpada vermelha
    4 - Voltar acima e colocar o gênero: <Adapter.MyViewHolder>
    5 - implementar métodos (acima) clicando na ferramenta lâmpada vermelha
     */

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        //Cria o item da lista
        View itemLista = LayoutInflater.from(
                viewGroup.getContext()).inflate(R.layout.adapter_lista,
                viewGroup,
                false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
//        myViewHolder.titulo.setText("Título de teste");
//        myViewHolder.ano.setText("1500");
//        myViewHolder.genero.setText("Gênero de teste");

        Filme filme = listaFilmes.get(i);
        myViewHolder.titulo.setText(filme.getTituloFilme());
        myViewHolder.ano.setText(filme.getAno());
        myViewHolder.genero.setText(filme.getGenero());
    }

    @Override
    public int getItemCount() {
        return listaFilmes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView titulo;
        TextView ano;
        TextView genero;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            titulo = itemView.findViewById(R.id.textTitulo);
            ano = itemView.findViewById(R.id.textAno);
            genero = itemView.findViewById(R.id.textGenero);
        }
    }
}
