package saulodev.com.integrationproject.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import saulodev.com.integrationproject.R;
import saulodev.com.integrationproject.databinding.ActivityLoginBinding;
import saulodev.com.integrationproject.util.MyAlertDialog;
import saulodev.com.integrationproject.util.VerificarDados;

public class LoginActivity extends AppCompatActivity {




    ActivityLoginBinding binding = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        btnEntrar();
        btnRegister();
        edtWatchers();

        /*MyAlertDialog myAlertDialog = new MyAlertDialog(R.layout.fragment_erro_inesperado);
        DialogFragment dialog = myAlertDialog;
        dialog.show(getSupportFragmentManager(),"fragment");*/

    }

    private void btnEntrar() {
        binding.entrarBtn.setOnClickListener(view -> {
            String conta = binding.contaComDigitoEdt.getText().toString().trim();
            String agencia = binding.numeroAgenciaEdt.getText().toString().trim();
            String senha = binding.passwordEdt.getText().toString().trim();

            if (!conta.isEmpty() && !agencia.isEmpty() &&
                    !senha.isEmpty()) {

                    if (agencia.length() != 5) {
                        binding.numeroAgenciaFil.setError("agencia incorreta");

                    } else {
                        binding.numeroAgenciaFil.setErrorEnabled(false);
                    }

                    if (conta.length() != 8) {
                        binding.numeroContaFil.setError("conta invalida");

                    } else {
                        binding.numeroContaFil.setErrorEnabled(false);
                    }

                    if (senha.length() != 6) {
                        binding.numeroSenhaFil.setError("senha_incorreta");

                    } else {
                        binding.numeroSenhaFil.setErrorEnabled(false);
                    }

                    if (agencia.length() == 5 && conta.length() == 8 && senha.length() == 6) {
                    finish();
                    startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                }

            }else {

                    if (conta.isEmpty()) {
                        binding.numeroContaFil.setError("Digite o numero da sua conta");

                    } else {
                        binding.numeroContaFil.setErrorEnabled(false);
                    }

                    if (agencia.isEmpty()) {
                        binding.numeroAgenciaFil.setError("Digite o numero da sua agencia");

                    } else {
                        binding.numeroAgenciaFil.setErrorEnabled(false);
                    }

                    if (senha.isEmpty()) {
                        binding.numeroSenhaFil.setError("Digite sua senha");

                    } else {
                        binding.numeroSenhaFil.setErrorEnabled(false);
                    }
                }
        });

        }

    private void btnRegister(){
        binding.cadastrarTxt.setOnClickListener(View -> {
            startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
        });
    }

    private void edtWatchers() {

        binding.numeroAgenciaEdt.setOnFocusChangeListener((view, hasFocus) ->{

            if (!hasFocus)
                binding.numeroAgenciaFil.setErrorEnabled(false);
        });

        binding.contaComDigitoEdt.setOnFocusChangeListener((view2, hasFocus) ->{

            if (!hasFocus)
                binding.numeroContaFil.setErrorEnabled(false);
        });

        binding.passwordEdt.setOnFocusChangeListener((view3, hasFocus) ->{

            if (!hasFocus )
                binding.numeroSenhaFil.setErrorEnabled(false);

        });


    }
}