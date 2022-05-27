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


    private int contador = 0;

    public void zerarContador() {
        contador = 0;
    }

    public int getContador() {
        return contador;
    }

    //Formulário Dados Cadastrais
    public boolean setNomeCompleto(String dado) {
        int aux = 0;
        if (verificarDados.verificarPreenchido(dado)) {
            if (verificarDados.verificarCaracterEspecial(dado)) {
                cliente.setNome(dado);
                contador++;
                aux = 1;
            }
        }
        return aux == 1;
    }

    public boolean setCpf(String dado) {
        int aux = 0;
        if (verificarDados.verificarPreenchido(dado)) {
            if (verificarDados.verificaTamanhoCpf(dado)) {
                if (verificarDados.validaCPF(dado)) {
                    cliente.setCpf(dado);
                    contador++;
                    aux = 1;
                }
            }
        }
        return aux == 1;
    }



    public boolean setDataNascimento(String dado) {
        int aux = 0;
        if (verificarDados.verificarPreenchido(dado)) {
            if (verificarDados.verificarDataValida(dado)) {
                if (verificarDados.verificarIdade(dado)) {
                    cliente.setDataNascimento(dado);
                    contador++;
                    aux = 1;
                }
            }
        }
        return aux == 1;
    }


    public boolean setRenda(String dado) {
        int aux = 0;
        if (verificarDados.verificarPreenchido(dado)) {
            if (verificarDados.maiorQueZero(dado.trim())) {
                cliente.setRenda(Double.parseDouble(dado));
                contador++;
                aux = 1;
            }
        }
        return aux == 1;
    }

    public boolean setPatrimonio(String dado) {
        int aux = 0;
        if (verificarDados.verificarPreenchido(dado)) {
            if (verificarDados.maiorQueZero(dado)) {
                cliente.setPatrimonio(Double.parseDouble(dado));
                contador++;
                aux = 1;
            }
        }
        return aux == 1;
    }

    public boolean setEmail(String dado) {//Arrumar
        int aux = 0;
        if (verificarDados.verificarPreenchido(dado)) {
            cliente.setEmail(dado);
            contador++;
            aux = 1;
        }

        return aux == 1;
    }

    public boolean setSenha(String dado, String verificador) {
        int aux = 0;
        if (verificarDados.verificarSenha(dado, verificador)) {
            cliente.setSenha(dado);
            contador++;
            aux = 1;
        }
        return aux == 1;
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
