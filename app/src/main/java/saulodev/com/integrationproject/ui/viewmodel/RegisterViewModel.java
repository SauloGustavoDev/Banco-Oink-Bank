package saulodev.com.integrationproject.ui.viewmodel;

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
        String dadoFormatado = dado.replace("R", "");
        dadoFormatado = dadoFormatado.replace("$", "");
        dadoFormatado = dadoFormatado.replace(".", "");
        dadoFormatado = dadoFormatado.replace(",", ".");
        cliente.setRenda(Double.parseDouble(dadoFormatado));
    }

    public void setPatrimonio(String dado) {
        String dadoFormatado = dado.replace("R", "");
        dadoFormatado = dadoFormatado.replace("$", "");
        dadoFormatado = dadoFormatado.replace(".", "");
        dadoFormatado = dadoFormatado.replace(",", ".");
        cliente.setPatrimonio(Double.parseDouble(dadoFormatado));
    }

    public void setEmail(String dado) {//Arrumar
        cliente.setEmail(dado);
    }

    public void setSenha(String dado, String verificador) {
        cliente.setSenha(dado);
    }

    //CADASTRANDO USUÁRIO
    public void cadastrarUsuario() {
/*
        Cliente cliente = new Cliente();


        Methods methods = RetrofitClient.getRETROFIT().create(Methods.class);
        Call<Cliente> call = methods.cadastrarUsuario(cliente);

        call.enqueue(new Callback<Cliente>() {
            @Override
            public void onResponse(Call<Cliente> call, Response<Cliente> response) {

            }

            @Override
            public void onFailure(Call<Cliente> call, Throwable t) {

            }
        });


 */
    }
}
