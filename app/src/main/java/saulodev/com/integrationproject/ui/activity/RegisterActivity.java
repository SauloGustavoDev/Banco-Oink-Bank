package saulodev.com.integrationproject.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.Locale;

import saulodev.com.integrationproject.R;
import saulodev.com.integrationproject.databinding.ActivityRegisterBinding;

import saulodev.com.integrationproject.ui.viewmodel.RegisterViewModel;
import saulodev.com.integrationproject.util.mask_money;

public class RegisterActivity extends AppCompatActivity {

    private ActivityRegisterBinding binding;
    private RegisterViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityRegisterBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        viewModel = new ViewModelProvider(this).get(RegisterViewModel.class);


        btnVoltarMain();

        btnCadastrarCliente();

        initialMaskMoney();

    }

    private void btnCadastrarCliente() {
        binding.btnCadastrar.setOnClickListener(view -> {
            startActivity(new Intent(RegisterActivity.this, HomeActivity.class));
            finish();
        });
    }

    private void btnVoltarMain() {
        binding.btnVoltar.setOnClickListener(view -> {
            startActivity(new Intent(RegisterActivity.this, MainActivity.class));
            finish();
        });
    }

    private void initialMaskMoney(){
        Locale mLocale = new Locale("pt", "BR");
        binding.edtPatrimonio.addTextChangedListener(new mask_money(binding.edtPatrimonio, mLocale));
        binding.edtRenda.addTextChangedListener(new mask_money(binding.edtRenda, mLocale));
    }

}