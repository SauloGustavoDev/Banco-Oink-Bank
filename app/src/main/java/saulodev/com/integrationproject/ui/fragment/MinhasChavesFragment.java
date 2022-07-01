package saulodev.com.integrationproject.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import java.util.ArrayList;

import saulodev.com.integrationproject.R;
import saulodev.com.integrationproject.databinding.FragmentMinhasChavesBinding;
import saulodev.com.integrationproject.model.KeyModel;
import saulodev.com.integrationproject.ui.adapter.ListAdapterCobrar;

public class MinhasChavesFragment extends Fragment {

    private FragmentMinhasChavesBinding bind;
    private ArrayList<KeyModel> keyList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        bind = FragmentMinhasChavesBinding.inflate(inflater, container, false);
        return bind.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // CRIAÇÃO DA LISTA (mock) ///////////////////////////////////////////////////////
        keyList = new ArrayList<KeyModel>();
        for (int i = 0; i < 3; i++) {
            KeyModel keyModel = new KeyModel("Chave CPF", "111.444.777-35");
            keyList.add(keyModel);
        }
        //////////////////////////////////////////////////////////////////////////////////

        recyclerView();

        bind.voltarImg.setOnClickListener(view1 -> {
            requireActivity().onBackPressed();
        });

        bind.cadastrarChaveBtn.setOnClickListener(view1 -> {
            replaceCadastrarChaveFragment();
            bind.frameCadastrarChave.requestFocus();
        });


    }

    private void recyclerView() {
        bind.recyclerViewMinhasChaves.setAdapter(new ListAdapterCobrar(getContext(), keyList));
    }

    private void replaceCadastrarChaveFragment() {
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frame_cadastrar_chave, new CadastrarChavePixFragment()).addToBackStack(null).commit();
    }

}
