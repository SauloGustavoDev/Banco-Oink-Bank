package saulodev.com.integrationproject.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import java.util.ArrayList;
import java.util.Locale;

import saulodev.com.integrationproject.databinding.FragmentCobrarChavesBinding;
import saulodev.com.integrationproject.model.KeyModel;
import saulodev.com.integrationproject.ui.adapter.ListAdapterCobrar;
import saulodev.com.integrationproject.util.MaskMoney;

public class CobrarChavesFragment extends Fragment {

    private FragmentCobrarChavesBinding binding = null;
    private ArrayList<KeyModel> keyList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentCobrarChavesBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // CRIAÇÃO DA LISTA (mock) ///////////////////////////////////////////////////////
        keyList = new ArrayList<KeyModel>();
        for (int i = 0; i < 5; i++) {
            KeyModel keyModel = new KeyModel("Chave CPF", "111.444.777-35");
            keyList.add(keyModel);
        }
        //////////////////////////////////////////////////////////////////////////////////

        recyclerView();

        maskMoney();
        replacePixFragment();
    }

    private void recyclerView() {
        binding.recyclerView.setAdapter(new ListAdapterCobrar(getContext(), keyList));
    }

    private void maskMoney() {
//        Locale locale = new Locale("pt", "BR");
//        binding.valorEditText.addTextChangedListener(new MaskMoney(binding.valorEditText, locale));
    }

    private void replacePixFragment(){

    }
}
