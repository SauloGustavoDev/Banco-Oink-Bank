package saulodev.com.integrationproject.ui.fragment;

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

import saulodev.com.integrationproject.R;
import saulodev.com.integrationproject.databinding.FragmentEditBinding;
import saulodev.com.integrationproject.util.CpfCnpjUtils;
import saulodev.com.integrationproject.util.ErrorEditText;
import saulodev.com.integrationproject.util.VerificarDados;

public class EditFragment extends Fragment {

    private FragmentEditBinding bind;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        bind = FragmentEditBinding.inflate(inflater, container, false);
        return bind.getRoot();
    }

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

        bind.cpfEdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(bind.cpfEdt.getText().toString().trim().isEmpty())
                    bind.cpfTil.setErrorEnabled(false);

                if (bind.cpfEdt.isDone())
                    if (!CpfCnpjUtils.isValid(bind.cpfEdt.getUnMasked())) {
                        bind.cpfTil.setError(getString(R.string.cpf_invalido));
                        bind.cpfTil.setErrorEnabled(true);
                    }
                    else
                        bind.cpfTil.setErrorEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });

        bind.emailEdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(bind.emailEdt.getText().toString().trim().isEmpty())
                    bind.emailTil.setErrorEnabled(false);

                if(!VerificarDados.validarEmail(bind.emailEdt.getText().toString().trim())) {
                    bind.emailTil.setError(getString(R.string.email_invalido));
                    bind.emailTil.setErrorEnabled(true);
                } else
                    bind.emailTil.setErrorEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });

        bind.dataEdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(bind.dataEdt.getText().toString().trim().isEmpty())
                    bind.dataTil.setErrorEnabled(false);

                if (bind.dataEdt.isDone()) {
                    String date = bind.dataEdt.getText().toString().trim();
                    if (VerificarDados.dateIsValid(date)) {
                        if (!(VerificarDados.calculoIdade(date) > 18)) {
                            bind.dataTil.setError(getString(R.string.data_invalida_2));
                            bind.dataTil.setErrorEnabled(true);
                        } else
                            bind.dataTil.setErrorEnabled(false);
                    } else {
                        bind.dataTil.setError(getString(R.string.data_invalida_1));
                        bind.dataTil.setErrorEnabled(true);
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        bind.confirmarBtn.setOnClickListener(view1 -> {
            requireActivity().onBackPressed();
        });
    }
}