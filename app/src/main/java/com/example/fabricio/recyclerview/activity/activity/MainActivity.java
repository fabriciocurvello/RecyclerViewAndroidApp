package com.example.fabricio.recyclerview.activity.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.example.fabricio.recyclerview.R;
import com.example.fabricio.recyclerview.activity.adapter.Adapter;
import com.example.fabricio.recyclerview.activity.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Filme> listaFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        //Listagem de Filmes
        this.criarFilmes();

        //1 - Configurar Adapter
        //1.1 - Necessário já ter criado a classe Adapter e o XML adapter
        Adapter adapter = new Adapter( listaFilmes );

        //2 - Configurar RecyclerView:
        //2.1 - Informando o gerenciador de layout para o RecyclerView. Neste caso o LinearLayoutManager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        //2.2 - Informando que o RecyclerView terá tamanho fixo (aumenta o desempenho)
        recyclerView.setHasFixedSize(true);

        //Coloca uma linha divisória abaixo de cada item
        recyclerView.addItemDecoration( new DividerItemDecoration( this, LinearLayout.VERTICAL) );

        //2.3 - Setando o adapter ao RecyclerView
        recyclerView.setAdapter( adapter );
    }

    public void criarFilmes() {

        Filme filme = new Filme("Rambo", "Ação", "1985");
        this.listaFilmes.add( filme );

        filme = new Filme("De Volta Para O Futuro", "Ficção", "1985");
        this.listaFilmes.add( filme );

        filme = new Filme("Matrix", "Ficcção/Ação", "2001");
        this.listaFilmes.add( filme );

        filme = new Filme("Ghost", "Ficção/Romance", "1988");
        this.listaFilmes.add( filme );

        filme = new Filme("Exterminador do Futuro", "Ficcção/Ação", "1987");
        this.listaFilmes.add( filme );

    }
}
