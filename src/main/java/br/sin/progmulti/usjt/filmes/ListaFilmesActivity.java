package br.sin.progmulti.usjt.filmes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

// Nome: Henrique M. Domingues RA: 816117860

public class ListaFilmesActivity extends Activity {
    public static final String DESCRICAO =
            "br.sin.progmulti.usjt.filmes.descricao";
    ArrayList<String> lista;
    Activity atividade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_filmes);
        atividade = this;
        Intent intent = getIntent();
        String chave = intent.getStringExtra(MainActivity.NOME);
        lista = buscaFilmes(chave);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, lista);
        ListView listView = findViewById(R.id.listview);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view,
                                  int position, long id) {
               // manda para a tela de detalhe
                Intent intent = new Intent(atividade, DetalheFilmeActivity.class);
                intent.putExtra(DESCRICAO, lista.get(position));
                startActivity(intent);
           }
        });
    }
    public ArrayList<String> buscaFilmes(String chave){
        ArrayList<String> lista = geraListaFilmes();
        if (chave == null || chave.length() == 0){
            return lista;
        } else {
            ArrayList<String> subLista = new ArrayList<>();
            for(String nome:lista){
                if(nome.toUpperCase().contains(chave.toUpperCase())){
                    subLista.add(nome);
                }
            }
            return subLista;
        }
    }
    public ArrayList<String> geraListaFilmes(){
        ArrayList<String> lista = new ArrayList<>();

        lista.add("Avatar");
        lista.add("Titanic");
        lista.add("Star Wars: The Force Awakens");
        lista.add("Avengers: Infinity War");
        lista.add("Jurassic World");
        lista.add("Os vingadores");
        lista.add("Velozes e furiosos 7");
        lista.add("Vingadores: A Era de Ultron");
        lista.add("Pantera negra");
        lista.add("Star Wars: The Last Jedi");
        lista.add("Frozen");
        lista.add("Homem de ferro 3");
        return lista;
    }
}
