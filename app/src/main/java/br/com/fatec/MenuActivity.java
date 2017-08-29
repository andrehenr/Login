package br.com.fatec;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by ANDRE on 28/08/2017.
 */

public class MenuActivity extends Activity {

    public static final String EXTRA_NOME_USUARIO =
            "helloandroid.EXTRA_NOME_USUARIO";
    public static final String ACAO_EXIBIR_MENU =
            "helloandroid.ACAO_EXIBIR_MENU";
    public static final String CATEGORIA_MENU =
            "helloandroid.CATEGORIA_MENU";


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);
        TextView saudacaoTextView = (TextView) findViewById(R.id.nome_usuario);
        Intent intent = getIntent();
        String saudacao = getResources().getString(R.string.saudacao_login);
        saudacaoTextView.setText(saudacao + " " + intent.getStringExtra(EXTRA_NOME_USUARIO));
    }


}
