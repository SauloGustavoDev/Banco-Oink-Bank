package saulodev.com.integrationproject.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import saulodev.com.integrationproject.R;
import saulodev.com.integrationproject.databinding.FragmentMinhasChavesBinding;

public class MinhasChavesFragment extends Fragment {

    private FragmentMinhasChavesBinding bind;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        bind = FragmentMinhasChavesBinding.inflate(inflater, container, false);
        return bind.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bind.voltarImg.setOnClickListener(view1 -> {
            requireActivity().onBackPressed();
        });

        bind.cadastrarChaveBtn.setOnClickListener(view1 -> {
            replaceCadastrarChaveFragment();
            //bind.frameCadastrarChave.requestFocus();
        });


    }

    private void replaceCadastrarChaveFragment() {
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frame_cadastrar_chave, new CadastrarChavePixFragment()).addToBackStack(null).commit();
    }
}
