package saulodev.com.integrationproject.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import saulodev.com.integrationproject.R;
import saulodev.com.integrationproject.databinding.FragmentBuscarTransferenciaBinding;
import saulodev.com.integrationproject.databinding.FragmentCadastrarChavePixBinding;
import saulodev.com.integrationproject.model.Contato;
import saulodev.com.integrationproject.ui.adapter.ContatosPixAdapter;


public class BuscarTransferenciaFragment extends Fragment {

    FragmentBuscarTransferenciaBinding binding;
    private List<Contato> listaContato = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       binding = FragmentBuscarTransferenciaBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.voltarImgBtn.setOnClickListener(view1 -> {
            requireActivity().onBackPressed();
        });

        binding.cadastrarChaveBtn.setOnClickListener(view1 -> {
            //replaceTransferenciaValorFragment();
        });

        criarContato();
        ContatosPixAdapter adapter = new ContatosPixAdapter(listaContato);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        binding.recyclerView.setLayoutManager(layoutManager);
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setHasFixedSize(true);

    }
    public void criarContato(){
        Contato contato = new Contato("Marcos da silva", "111.444.333-76");
        this.listaContato.add(contato);
        contato = new Contato("Fernando oliveira", "123.321.456-65");
        this.listaContato.add(contato);
    }


}