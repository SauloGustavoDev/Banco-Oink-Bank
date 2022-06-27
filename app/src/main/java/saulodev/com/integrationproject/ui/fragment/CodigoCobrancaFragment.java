package saulodev.com.integrationproject.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import saulodev.com.integrationproject.R;
import saulodev.com.integrationproject.databinding.FragmentCodigoCobrancaBinding;

public class CodigoCobrancaFragment extends Fragment {

    private FragmentCodigoCobrancaBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCodigoCobrancaBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnVoltar.setOnClickListener(view1 -> {
            requireActivity().onBackPressed();
        });

        binding.btnConfirmar.setOnClickListener(view1 -> {
            getFragmentManager().popBackStack();
            replaceHomeFragment();
        });

    }

    private void replaceHomeFragment() {
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frame, new HomeFragment()).addToBackStack(null).commit();
    }
}