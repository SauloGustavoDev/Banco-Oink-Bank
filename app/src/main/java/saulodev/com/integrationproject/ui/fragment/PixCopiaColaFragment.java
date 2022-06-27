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

import saulodev.com.integrationproject.R;
import saulodev.com.integrationproject.databinding.FragmentPixCopiaColaBinding;

public class PixCopiaColaFragment extends Fragment {

    private FragmentPixCopiaColaBinding bind;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        bind = FragmentPixCopiaColaBinding.inflate(inflater, container, false);
        return bind.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bind.continuarPixCopiaEColaBtn.setOnClickListener(view1 -> {
            String pix = bind.pixEdt.getText().toString().trim();

            if (!pix.isEmpty())
                replaceConfirmaPix();
            else
                bind.pixTil.setError(getString(R.string.campo_obrigatorio));
        });

        bind.setaVoltarImg.setOnClickListener(view1 -> {
            requireActivity().onBackPressed();
        });

        bind.pixEdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!bind.pixEdt.getText().toString().trim().isEmpty())
                    bind.pixTil.setErrorEnabled(false);
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
}