package javamobile.anotacoes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import javamobile.anotacoes.bancodedados.BancoDeDados;

public class CriarAnotacao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_anotacao);
    }
    public void voltar(View view){
        Intent startNewActivity = new Intent(this,MainActivity.class);
        startActivity(startNewActivity);
    }

    public void criarAnotacao(View view){
        BancoDeDados bancoDeDados = new BancoDeDados(getBaseContext());
        EditText titulo = (EditText) findViewById(R.id.campoTitulo);
        EditText conteudo = (EditText) findViewById(R.id.campoConteudo);

        boolean resultado = bancoDeDados.criarAnotacao(titulo.getText().toString(), conteudo.getText().toString());
        if (resultado) {
            Toast.makeText(getApplicationContext(),"Anotação Criada com Sucesso!", Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(getApplicationContext(),"Infelizmente ocorreu um ERRO, tente novamente.", Toast.LENGTH_LONG).show();
        }
        voltar(view);
    }
}

