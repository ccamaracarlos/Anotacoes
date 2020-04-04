package javamobile.anotacoes.bancodedados;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BancoDeDados  {

    public SQLiteDatabase banco;
    public GerenciarBanco gerenciarBanco;

    public BancoDeDados(Context context){
        gerenciarBanco = new GerenciarBanco(context);
    }

    public boolean criarAnotacao(String titulo, String conteudo){
        banco = gerenciarBanco.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put("titulo", titulo);
        valores.put("conteudo", conteudo);

        long resultado = banco.insert("anotacoes", null, valores);
        banco.close();
        return resultado > 0;
    }
}
