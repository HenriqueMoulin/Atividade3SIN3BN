package br.sin.progmulti.usjt.filmes;

import android.app.Activity;
import android.os.Bundle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

// Nome: Henrique M. Domingues RA: 816117860


public class DetalheFilmeActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_filme);
        TextView nome = findViewById(R.id.filme_selecionado);
        Intent intent = getIntent();

        nome.setText(intent.getStringExtra(ListaFilmesActivity.DESCRICAO));
    }

}