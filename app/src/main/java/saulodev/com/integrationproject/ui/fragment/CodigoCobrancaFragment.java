package saulodev.com.integrationproject.ui.fragment;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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

        binding.copiarImg.setOnClickListener(view1 -> {
            ClipboardManager clipboardManager = (ClipboardManager) requireContext()
                    .getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clipData = ClipData.newPlainText("pix_key", getString(R.string.link_cobranca));
            clipboardManager.setPrimaryClip(clipData);
        });

        binding.btnVoltar.setOnClickListener(view1 -> {
            requireActivity().onBackPressed();
        });

        binding.btnConfirmar.setOnClickListener(view1 -> {
            requireActivity().getSupportFragmentManager().popBackStack();
            replaceHomeFragment();
        });

    }

    private void replaceHomeFragment() {
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frame, new HomeFragment()).commit();
    }
}