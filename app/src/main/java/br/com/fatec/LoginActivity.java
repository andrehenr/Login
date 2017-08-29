package br.com.fatec;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.fatec.bean.Usuario;

public class LoginActivity extends Activity {

    ArrayList<Usuario> usuarios;
    EditText usuario;
    EditText senha;
    TextView erroUsuario ;
    TextView erroSenha ;
    TextView msg ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usuarios = new ArrayList<>();
        usuario = (EditText) findViewById(R.id.txt_username);
        senha = (EditText) findViewById(R.id.txt_password);
        erroUsuario = (TextView) findViewById(R.id.txtErrorUser);
        erroSenha = (TextView) findViewById(R.id.txtErrorSenha);
        msg = (TextView) findViewById(R.id.txtMensagem);
    }
    public void adicionarUsuario(View view){
        Editable strUsuario = usuario.getText();
        Editable strSenha = senha.getText();
        if(strUsuario.toString().isEmpty() || strUsuario.toString().equals("")) {
            erroUsuario.setText("O usuário não pode estar em branco");
        }
        else if (strSenha.toString().isEmpty() || strSenha.toString().equals("")) {
            erroSenha.setText("A senha não pode estar em branco");
        }
        else {
            erroUsuario.setText("");
            erroSenha.setText("");
            boolean usuarioExistente = false;
            for(int i=0;i<usuarios.size();i++){
                Usuario usuarioAtual = usuarios.get(i);
                if(usuarioAtual.getUsername().equals(strUsuario.toString())){
                    usuarioExistente = true;
                }
            }
            if(usuarioExistente){
                msg.setText("Usuario "+strUsuario.toString()+" já existe");
            }
            else{
                Usuario us = new Usuario();
                us.setPassword(strSenha.toString());
                us.setUsername(strUsuario.toString());
                usuarios.add(us);
                msg.setText("Usuario "+us.getUsername()+ " add com sucesso");
                usuario.setText("");
                senha.setText("");
            }
        }
    }
    public void login(View view){
        Editable strUsuario = usuario.getText();
        Editable strSenha = senha.getText();
        if(strUsuario.toString().isEmpty() || strUsuario.toString().equals("")) {
            erroUsuario.setText("O usuário não pode estar em branco");
        }
        else if (strSenha.toString().isEmpty() || strSenha.toString().equals("")) {
            erroSenha.setText("A senha não pode estar em branco");
        }
        else {
            erroUsuario.setText("");
            erroSenha.setText("");
            usuario.setText("");
            senha.setText("");
            boolean logado = false;
            for(Usuario usuario: usuarios){
                if(strUsuario.toString().equals(usuario.getUsername())){
                    if(strSenha.toString().equals(usuario.getPassword())){
                        logado = true;
                    }
                }
            }
            if(logado){
                Intent intent = new Intent(MenuActivity.ACAO_EXIBIR_MENU);
                intent.addCategory(MenuActivity.CATEGORIA_MENU);
                intent.putExtra(MenuActivity.EXTRA_NOME_USUARIO, strUsuario.toString());
                startActivity(intent);
            }
            else {
                msg.setText("Não foi possivel realizar o login");
            }
        }
    }
}
