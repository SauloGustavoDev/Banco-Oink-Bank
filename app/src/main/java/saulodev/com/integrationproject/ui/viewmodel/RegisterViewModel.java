package saulodev.com.integrationproject.ui.viewmodel;

import static java.lang.Double.parseDouble;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import saulodev.com.integrationproject.client.Methods;
import saulodev.com.integrationproject.client.RetrofitClient;
import saulodev.com.integrationproject.model.Cliente;
import saulodev.com.integrationproject.util.VerificarDados;

public class RegisterViewModel extends ViewModel {


    private final static VerificarDados verificarDados = new VerificarDados();
    private static Cliente cliente = new Cliente();


    //SHARED PREFERENCES
    private static SharedPreferences sharedPreferences = null;

    public void iniciarSharedPreferences(){
        //sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
    }

    public String recuperarIdSharedPreferences(){
        return sharedPreferences.getString("armazenamento", null);
    }

    public void deletarIdSharedPreferences(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("armazenamento", null);
        editor.apply();
    }

    public void salvarID(String id){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("armazenamento", id);
        editor.apply();
    }

    public void dessativarSharedPreferences(){
        sharedPreferences = null;
    }


    //Formulário Dados Cadastrais
    public void setNomeCompleto(String dado) {
        cliente.setNome(dado);
    }

    public void setCpf(String dado) {
        cliente.setCpf(dado);
    }

    public void setDataNascimento(String dado) {
        cliente.setDataNascimento(dado);
    }


    public void setRenda(String dado) {
        String dadoFormatado = dado.replaceAll("[^0-9,]", "");
        dadoFormatado = dadoFormatado.replace(",", ".");

        Log.i("Cadastro", "Renda " + dadoFormatado);
        cliente.setRenda(parseDouble(dadoFormatado.trim()));

    }

    public void setPatrimonio(String dado) {
        String dadoFormatado = dado.replaceAll("[^0-9,]", "");
        dadoFormatado = dadoFormatado.replace(",", ".");

        Log.i("Cadastro", "Patrimonio " + dadoFormatado);
        cliente.setPatrimonio(parseDouble(dadoFormatado.trim()));
    }

    public void setEmail(String dado) {//Arrumar
        cliente.setEmail(dado);
    }

    public void setSenha(String dado) {
        cliente.setSenha(dado);
    }

    //CADASTRANDO USUÁRIO
    public void cadastrarUsuario() {

        Methods methods = RetrofitClient.getRETROFIT().create(Methods.class);
        Call<Cliente> call = methods.cadastrarUsuario(cliente);

        call.enqueue(new Callback<Cliente>() {
            @Override
            public void onResponse(Call<Cliente> call, Response<Cliente> response) {
                if (response.isSuccessful()){
                    Log.i("Cadastro", "Cliente " + response.body().getNome() + " Cadastrado!");

                }else {
                    Log.i("Cadastro", "Cliente não cadastrado");
                }
            }

            @Override
            public void onFailure(Call<Cliente> call, Throwable t) {
                Log.i("Cadastro", "Mensagem " + t.getMessage());
            }
        });

    }
}
