package saulodev.com.integrationproject.ui.fragment;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Locale;

import saulodev.com.integrationproject.R;
import saulodev.com.integrationproject.databinding.FragmentEditBinding;
import saulodev.com.integrationproject.ui.activity.HomeActivity;
import saulodev.com.integrationproject.ui.activity.RegisterActivity;
import saulodev.com.integrationproject.util.CpfCnpjUtils;
import saulodev.com.integrationproject.util.ErrorEditText;
import saulodev.com.integrationproject.util.MaskMoney;
import saulodev.com.integrationproject.util.VerificarDados;

public class EditFragment extends Fragment {

    private FragmentEditBinding bind;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        bind = FragmentEditBinding.inflate(inflater, container, false);
        return bind.getRoot();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        /*
        String nome = bind.nomeEdt.getText().toString().trim();
            String cpf = bind.cpfEdt.getText().toString().trim();
            String dataNascimento = bind.dataEdt.getUnMasked().trim();
            String email = bind.emailEdt.getText().toString().trim();
            String rendaMensal = bind.rendaEdt.getText().toString().trim();
            String patrimonioLiquido = bind.patrimonioEdt.getText().toString().trim();
         */

        maskField();
        btnBack();
        listeners();
        edtWatchers();

    }

    private void maskField() {
        Locale locale = new Locale("pt", "BR");
        bind.patrimonioLiquidoEdt.addTextChangedListener(new MaskMoney(bind.patrimonioLiquidoEdt, locale));
        bind.rendaMensalEdt.addTextChangedListener(new MaskMoney(bind.rendaMensalEdt, locale));
    }

    private void btnBack() {
        bind.voltarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requireActivity().onBackPressed();
            }
        });
    }

    private void edtWatchers() {

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

        bind.rendaMensalEdt.setOnFocusChangeListener((view, hasFocus) -> {
            if (!hasFocus && bind.rendaMensalEdt.getText().toString().trim().isEmpty())
                bind.rendaMensalTil.setError(getString(R.string.campo_obrigatorio));
            else
                bind.rendaMensalTil.setErrorEnabled(false);
        });

        bind.patrimonioLiquidoEdt.setOnFocusChangeListener((view, hasFocus) -> {
            if (!hasFocus && bind.patrimonioLiquidoEdt.getText().toString().trim().isEmpty())
                bind.patrimonioLiquidoTil.setError(getString(R.string.campo_obrigatorio));
            else
                bind.patrimonioLiquidoTil.setErrorEnabled(false);
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void listeners() {
        bind.editarBtn.setOnClickListener(view -> {

            String nome = bind.nomeEdt.getText().toString().trim();
            String cpf = bind.cpfEdt.getText().toString().trim();
            String dataNascimento = bind.dataNascimentoEdt.getText().toString().trim();
            String email = bind.emailEdt.getText().toString().trim();
            String rendaMensal = MaskMoney.noMask(bind.rendaMensalEdt.getText().toString().trim());
            String patrimonioLiquido = MaskMoney.noMask(bind.patrimonioLiquidoEdt.getText().toString().trim());

            if (!nome.isEmpty() && !cpf.isEmpty() && !dataNascimento.isEmpty() &&
                    !email.isEmpty() && !rendaMensal.isEmpty() && !patrimonioLiquido.isEmpty()) {

                if (VerificarDados.validarEmail(email)) {

                    //ENVIAR ALTERAÇÕES PARA API
                    //TODO
                    requireActivity().onBackPressed();

                } else {

                    if (!VerificarDados.validarEmail(email)) {
                        bind.emailTil.setError(getString(R.string.email_invalido));
                        bind.emailTil.setErrorEnabled(true);
                    }
                    if (!VerificarDados.dateIsValid(dataNascimento)) {
                        bind.dataNascimentoTil.setError(getString(R.string.data_invalida_1));
                        bind.dataNascimentoTil.setErrorEnabled(true);
                    }
                    if (!VerificarDados.validaCPF(cpf)) {
                        bind.cpfTil.setError(getString(R.string.cpf_invalido));
                        bind.cpfTil.setErrorEnabled(true);
                    }
                }

            } else {

                if (patrimonioLiquido.isEmpty()) {
                    bind.patrimonioLiquidoTil.setError(getString(R.string.campo_obrigatorio));
                    bind.patrimonioLiquidoTil.setErrorEnabled(true);
                }
                if (rendaMensal.isEmpty()) {
                    bind.rendaMensalTil.setError(getString(R.string.campo_obrigatorio));
                    bind.rendaMensalTil.setErrorEnabled(true);
                }
                if (email.isEmpty()) {
                    bind.emailTil.setError(getString(R.string.campo_obrigatorio));
                    bind.emailTil.setErrorEnabled(true);
                }
                if (dataNascimento.isEmpty()) {
                    bind.dataNascimentoTil.setError(getString(R.string.campo_obrigatorio));
                    bind.dataNascimentoTil.setErrorEnabled(true);
                }
                if (cpf.isEmpty()) {
                    bind.cpfTil.setError(getString(R.string.campo_obrigatorio));
                    bind.cpfTil.setErrorEnabled(true);
                }
                if (nome.isEmpty()) {
                    bind.nomeTil.setError(getString(R.string.campo_obrigatorio));
                    bind.nomeTil.setErrorEnabled(true);
                }
            }
        });
    }
}