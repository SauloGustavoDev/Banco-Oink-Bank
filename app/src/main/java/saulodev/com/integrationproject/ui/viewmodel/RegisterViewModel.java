package saulodev.com.integrationproject.ui.viewmodel;

import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import saulodev.com.integrationproject.client.Methods;
import saulodev.com.integrationproject.client.RetrofitClient;
import saulodev.com.integrationproject.model.Cliente;

public class RegisterViewModel extends ViewModel {

    public boolean validaCPF(String cpf) {
        if (cpf.length() < 11) {
            return false;
        } else {

            int[] digitosFinais = new int[2];
            int[] digitosCpf = new int[10];
            int multiplicacao;
            int soma;
            int restoDivisao;

            for (int x = 0; x < 10; x++) {
                digitosCpf[x] = cpf.charAt(x);
            }

            if (digitosCpf[0] == digitosCpf[1] && digitosCpf[2] == digitosCpf[3] &&
                    digitosCpf[4] == digitosCpf[5] && digitosCpf[6] == digitosCpf[7] &&
                    digitosCpf[8] == digitosCpf[9]) {
                return false;
            } else {
                for (int indiceMultiplicacao = 0; indiceMultiplicacao < 2; indiceMultiplicacao++) {
                    if (indiceMultiplicacao == 0) {
                        multiplicacao = 10;
                    } else {
                        multiplicacao = 11;
                    }
                    soma = 0;

                    for (int indiceSoma = 0; indiceSoma < 9 + indiceMultiplicacao; indiceSoma++) {
                        soma = soma + Integer.parseInt(String.valueOf(cpf.charAt(indiceSoma))) * multiplicacao;
                        multiplicacao = multiplicacao - 1;
                    }

                    restoDivisao = soma % 11;

                    if (restoDivisao < 2) {
                        digitosFinais[indiceMultiplicacao] = 0;

                    } else {
                        digitosFinais[indiceMultiplicacao] = 11 - restoDivisao;

                    }
                }

                if (digitosFinais[0] == Integer.parseInt(String.valueOf(cpf.charAt(9))) &&
                        digitosFinais[1] == Integer.parseInt(String.valueOf(cpf.charAt(10)))) {
                    return true;
                } else {
                    //Inválido
                    return false;
                }
            }

        }
    }

    public void cadastrarUsuario() {

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

    }
}
