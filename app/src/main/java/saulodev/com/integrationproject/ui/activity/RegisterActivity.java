package saulodev.com.integrationproject.ui.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.Locale;

import saulodev.com.integrationproject.R;
import saulodev.com.integrationproject.databinding.ActivityRegisterBinding;

import saulodev.com.integrationproject.ui.viewmodel.RegisterViewModel;
import saulodev.com.integrationproject.util.VerificarDados;
import saulodev.com.integrationproject.util.mask_money;

public class RegisterActivity extends AppCompatActivity {

    private ActivityRegisterBinding binding;
    private RegisterViewModel viewModel;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        viewModel = new ViewModelProvider(this).get(RegisterViewModel.class);


        btnVoltarMain();

        btnCadastrarCliente();

        initialMaskMoney();

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void btnCadastrarCliente() {
        binding.btnCadastrar.setOnClickListener(view -> {
            boolean verificador = true;
            //NOME
            if (VerificarDados.verificarPreenchido(binding.edtNome.getText().toString())) {
                if (VerificarDados.verificarCaracterEspecial(binding.edtNome.getText().toString())) {
                    binding.edtNome.setTextColor(Color.parseColor("#FF000000"));
                    viewModel.setNomeCompleto(binding.edtNome.getText().toString());
                }
                else{
                    binding.edtNome.setTextColor(Color.parseColor("#FF0000"));
                    verificador = false;
                }
            }
            else{
                binding.edtNome.setTextColor(Color.parseColor("#FF0000"));
                verificador = false;
            }


            //CPF
            if (VerificarDados.verificarPreenchido(binding.edtCpf.getUnMasked())){
                if (VerificarDados.validaCPF(binding.edtCpf.getUnMasked())){
                    binding.edtCpf.setTextColor(Color.parseColor("#FF000000"));
                    viewModel.setCpf(binding.edtCpf.getUnMasked());
                }
            }
            else{
                binding.edtCpf.setTextColor(Color.parseColor("#FF0000"));
                verificador = false;
            }

            //DATA
            if (VerificarDados.verificarPreenchido(binding.edtData.getText().toString())) {
                if (VerificarDados.dateIsValid(binding.edtData.getText().toString())){

                    if(VerificarDados.calculoIdade(binding.edtData.getText().toString())>= 18){
                        binding.edtData.setTextColor(Color.parseColor("#FF000000"));
                        viewModel.setCpf(binding.edtCpf.getText().toString());
                    }
                }
                else{
                    binding.edtData.setTextColor(Color.parseColor("#FF0000"));
                    verificador = false;
                }


            }
            else{
                binding.edtData.setTextColor(Color.parseColor("#FF0000"));
                verificador = false;
            }

            //EMAIL
            if (VerificarDados.verificarPreenchido(binding.edtEmail.getText().toString())) {
                binding.edtEmail.setTextColor(Color.parseColor("#FF000000"));
                viewModel.setCpf(binding.edtEmail.getText().toString());
            }
            else{
                binding.edtEmail.setTextColor(Color.parseColor("#FF0000"));
                verificador = false;
            }

            //RENDA MENSAL
            if (VerificarDados.verificarPreenchido(binding.edtRenda.getText().toString())) {
                binding.edtRenda.setTextColor(Color.parseColor("#FF000000"));
                viewModel.setRenda(binding.edtRenda.getText().toString());
            }
            else{
                binding.edtRenda.setTextColor(Color.parseColor("#FF0000"));
                verificador = false;
            }

            //PATRIMÔNIO LÍQUIDO
            if (VerificarDados.verificarPreenchido(binding.edtPatrimonio.getText().toString())) {
                viewModel.setPatrimonio(binding.edtPatrimonio.getText().toString());
            }


            //SENHA
            if (VerificarDados.verificarSenha(binding.edtSenha.getText().toString(), binding.edtConfirmaSenha.getText().toString())) {
                binding.edtSenha.setTextColor(Color.parseColor("#FF000000"));
                binding.edtConfirmaSenha.setTextColor(Color.parseColor("#FF000000"));
                viewModel.setCpf(binding.edtRenda.getText().toString());
            }
            else{
                binding.edtSenha.setTextColor(Color.parseColor("#FF0000"));
                binding.edtConfirmaSenha.setTextColor(Color.parseColor("#FF0000"));
                verificador = false;
            }

            if(verificador){
                startActivity(new Intent(RegisterActivity.this, HomeActivity.class));
                finish();
            }

        });
    }

    private void btnVoltarMain() {
        binding.btnVoltar.setOnClickListener(view -> {
            startActivity(new Intent(RegisterActivity.this, MainActivity.class));
            finish();
        });
    }

    private void initialMaskMoney() {
        Locale mLocale = new Locale("pt", "BR");
        binding.edtPatrimonio.addTextChangedListener(new mask_money(binding.edtPatrimonio, mLocale));
        binding.edtRenda.addTextChangedListener(new mask_money(binding.edtRenda, mLocale));
    }

}