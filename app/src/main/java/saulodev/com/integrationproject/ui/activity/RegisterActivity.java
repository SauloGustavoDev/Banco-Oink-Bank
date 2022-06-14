package saulodev.com.integrationproject.ui.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import java.util.Locale;

import saulodev.com.integrationproject.R;
import saulodev.com.integrationproject.databinding.ActivityRegisterBinding;

import saulodev.com.integrationproject.ui.viewmodel.RegisterViewModel;
import saulodev.com.integrationproject.util.CpfCnpjUtils;
import saulodev.com.integrationproject.util.ErrorEditText;
import saulodev.com.integrationproject.util.VerificarDados;
import saulodev.com.integrationproject.util.MaskMoney;

public class RegisterActivity extends AppCompatActivity {

    private ActivityRegisterBinding bind;
    private RegisterViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());

        viewModel = new ViewModelProvider(this).get(RegisterViewModel.class);

        bind.continuarBtn.setOnClickListener(view -> {

        });

        edtWatchers();
    }

    private void edtWatchers() {
        bind.cpfEdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (bind.cpfEdt.getText().toString().trim().isEmpty())
                    bind.cpfTil.setErrorEnabled(false);

                if (bind.cpfEdt.isDone())
                    if (!CpfCnpjUtils.isValid(bind.cpfEdt.getUnMasked())) {
                        bind.cpfTil.setError(getString(R.string.cpf_invalido));
                        bind.cpfTil.setErrorEnabled(true);
                    } else
                        bind.cpfTil.setErrorEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        bind.emailEdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (bind.emailEdt.getText().toString().trim().isEmpty())
                    bind.emailTil.setErrorEnabled(false);

                if (!VerificarDados.validarEmail(bind.emailEdt.getText().toString().trim())) {
                    bind.emailTil.setError(getString(R.string.email_invalido));
                    bind.emailTil.setErrorEnabled(true);
                } else
                    bind.emailTil.setErrorEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        bind.dataNascimentoEdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(bind.dataNascimentoEdt.getText().toString().trim().isEmpty())
                    bind.dataNascimentoTil.setErrorEnabled(false);

                if (bind.dataNascimentoEdt.isDone()) {
                    String date = bind.dataNascimentoEdt.getText().toString().trim();
                    if (VerificarDados.dateIsValid(date)) {
                        if (!(VerificarDados.calculoIdade(date) > 18)) {
                            bind.dataNascimentoTil.setError(getString(R.string.data_invalida_2));
                            bind.dataNascimentoTil.setErrorEnabled(true);
                        } else
                            bind.dataNascimentoTil.setErrorEnabled(false);
                    } else {
                        bind.dataNascimentoTil.setError(getString(R.string.data_invalida_1));
                        bind.dataNascimentoTil.setErrorEnabled(true);
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }
}