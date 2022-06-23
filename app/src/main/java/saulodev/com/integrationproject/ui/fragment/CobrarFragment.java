package saulodev.com.integrationproject.ui.fragment;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Locale;

import saulodev.com.integrationproject.R;
import saulodev.com.integrationproject.databinding.FragmentAreaPixBinding;
import saulodev.com.integrationproject.databinding.FragmentCobrarBinding;
import saulodev.com.integrationproject.databinding.FragmentConfirmaPixBinding;
import saulodev.com.integrationproject.util.MaskMoney;

public class CobrarFragment extends Fragment {

    private FragmentCobrarBinding binding;
    private Drawable errorIcon;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCobrarBinding.inflate(inflater, container, false);

        maskMoney();
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnConfirmar.setOnClickListener(view1 -> {
            String valor = binding.valorEditText.getText().toString();
            if (valor.equals(null) || valor.equals("") || valor.isEmpty() ||
                valor == "" || valor == null){

                binding.layoutTil.setError(getString(R.string.campo_obrigatorio));
            }else {
                replaceCodigoCobrancaFragment();
            }

        });

    }

    private void replaceCodigoCobrancaFragment(){
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frame, new CodigoCobrancaFragment()).addToBackStack(null).commit();
    }

    private void maskMoney() {
        Locale locale = new Locale("pt", "BR");
        binding.valorEditText.addTextChangedListener(new MaskMoney(binding.valorEditText, locale));
    }
}