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
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        errorIcon = ActivityCompat.getDrawable(getActivity(), R.drawable.ic_error);
        if (errorIcon != null) {
            errorIcon.setBounds(new Rect(0, 0, errorIcon.getIntrinsicWidth(), errorIcon.getIntrinsicHeight()));
        }

        maskMoney();

        binding.btnConfirmar.setOnClickListener(view1 -> {
            String valor = binding.nomeEdt.getText().toString().trim();
            if (!valor.equals(null)){
                replaceCodigoCobrancaFragment();
            }else {
                binding.nomeEdt.setError(getString(R.string.texto_erro_cobrar));
            }

        });

    }

    private void replaceCodigoCobrancaFragment(){
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frame, new CodigoCobrancaFragment()).addToBackStack(null).commit();
    }

    private void maskMoney() {
        Locale locale = new Locale("pt", "BR");
        binding.nomeEdt.addTextChangedListener(new MaskMoney(binding.nomeEdt, locale));
    }
}