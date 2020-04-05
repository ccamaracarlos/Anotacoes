package javamobile.anotacoes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import javamobile.anotacoes.bancodedados.BancoDeDados;

public class EditarAnotacao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_anotacao);

        BancoDeDados bancoDeDados = new BancoDeDados( (getBaseContext()));
        final Cursor cursor = bancoDeDados.consultarAnotacaoPeloId(this.getIntent().getIntExtra("id", 0));

        EditText titulo = (EditText) findViewById(R.id.campoTitulo);
        EditText  conteudo = (EditText) findViewById(R.id.campoConteudo);

        titulo.setText(cursor.getString(cursor.getColumnIndexOrThrow("titulo")));
        conteudo.setText(cursor.getString(cursor.getColumnIndexOrThrow("conteudo")));
    }

    public void voltar(View view) {
        Intent startNewActivity = new Intent(this, MainActivity.class);
        startActivity(startNewActivity);
    }

    public void atualizarAnotacao(View view){
        BancoDeDados bancoDeDados = new BancoDeDados(getBaseContext());
        EditText titulo = (EditText)findViewById(R.id.campoTitulo);
        EditText conteudo = (EditText)findViewById(R.id.campoConteudo);

        try {
            bancoDeDados.atualizarAnotacao(this.getIntent().getIntExtra("id", 0), titulo.getText().toString(), conteudo.getText().toString());
            Toast.makeText(getApplicationContext(),"Anotação Atualizada com Sucesso!", Toast.LENGTH_LONG).show();
        }catch (Exception ex) {
            Toast.makeText(getApplicationContext(),"Não foi possivel Atualizar a Anotação, tente novament!", Toast.LENGTH_LONG).show();
        }
        voltar(view);
    }
    public void excluirAnotacao(View view){
        BancoDeDados bancoDeDados = new BancoDeDados(getBaseContext());
        EditText titulo = (EditText)findViewById(R.id.campoTitulo);
        EditText conteudo = (EditText)findViewById(R.id.campoConteudo);

        try {
            bancoDeDados.excluirAnotacao(this.getIntent().getIntExtra("id", 0));
            Toast.makeText(getApplicationContext(),"Anotação Excluida com Sucesso!", Toast.LENGTH_LONG).show();
        }catch (Exception ex) {
            Toast.makeText(getApplicationContext(),"Não foi possivel Excluir a Anotação, tente novament!", Toast.LENGTH_LONG).show();
        }
        voltar(view);
    }
}
