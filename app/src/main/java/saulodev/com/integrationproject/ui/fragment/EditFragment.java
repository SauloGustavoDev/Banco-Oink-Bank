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
                if (bind.cpfEdt.isDone())
                    if (!CpfCnpjUtils.isValid(bind.cpfEdt.getUnMasked()))
                        ErrorEditText.setError(bind.cpfEdt, requireContext());
                    else
                        ErrorEditText.resetEditText(bind.cpfEdt, requireContext());
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        bind.dataEdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (bind.dataEdt.isDone()) {
                    String date = bind.dataEdt.getText().toString().trim();
                    if (VerificarDados.dateIsValid(date)) {
                        if (VerificarDados.calculoIdade(date) > 18)
                            ErrorEditText.resetEditText(bind.dataEdt, requireContext());
                        else
                            ErrorEditText.setError(bind.dataEdt, requireContext());
                    } else
                        ErrorEditText.setError(bind.dataEdt, requireContext());
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });

        bind.linearLayout.setOnClickListener(view1 -> {
            requireActivity().onBackPressed();
        });

        bind.confirmarBtn.setOnClickListener(view1 -> {
            requireActivity().onBackPressed();
        });
    }
}