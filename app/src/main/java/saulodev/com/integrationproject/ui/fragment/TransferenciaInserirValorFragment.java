package saulodev.com.integrationproject.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Locale;

import saulodev.com.integrationproject.R;
import saulodev.com.integrationproject.databinding.FragmentPixCopiaColaBinding;
import saulodev.com.integrationproject.databinding.FragmentTransferenciaInserirValorBinding;
import saulodev.com.integrationproject.util.MaskMoney;

public class TransferenciaInserirValorFragment extends Fragment {

    private FragmentTransferenciaInserirValorBinding bind;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        maskMoney();

        bind = FragmentTransferenciaInserirValorBinding.inflate(inflater, container, false);
        return bind.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bind.contiunarBtn.setOnClickListener(view1 -> {
            String valor = bind.valorEdt.getText().toString().trim();
            String mensagem = bind.valorEdt.getText().toString().trim();

            if (!valor.isEmpty() )
                replaceConfirmaPix();
            else
                bind.valorEdt.setError(getString(R.string.campo_obrigatorio));
        });

        bind.setaVoltarImg.setOnClickListener(view1 -> {
            requireActivity().onBackPressed();
        });

        bind.valorEdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!bind.valorEdt.getText().toString().trim().isEmpty())
                    bind.valorTil.setErrorEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void replaceConfirmaPix() {
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frame, new ConfirmaPixFragment()).addToBackStack(null).commit();
    }

    private void maskMoney() {
        Locale locale = new Locale("pt", "BR");
        bind.valorEdt.addTextChangedListener(new MaskMoney(bind.valorEdt, locale));
    }



}