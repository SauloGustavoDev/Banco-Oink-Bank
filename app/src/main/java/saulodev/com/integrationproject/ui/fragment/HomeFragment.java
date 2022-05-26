package saulodev.com.integrationproject.ui.fragment;

import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import saulodev.com.integrationproject.R;
import saulodev.com.integrationproject.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding bind = null;
    private HomeViewModel mViewModel;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        bind = FragmentHomeBinding.inflate(inflater, container,false);
        return bind.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        bind.btnHide.setOnClickListener(view1 ->{
            int inputType = bind.txtSaldo.getInputType();

            if(inputType == 18){
                bind.txtSaldo.setInputType(16);
            }else {
                bind.txtSaldo.setInputType(18);
            }
        });

        bind.editarDadosImg.setOnClickListener(view1 -> {
            replaceEditarFragment();
            bind.frameEditar.requestFocus();
        });

        bind.pixBtn.setOnClickListener(view1 -> {
            replacePixFragment();
        });
    }

    private void replacePixFragment() {
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frame, new AreaPixFragment()).addToBackStack(null).commit();
    }

    private void replaceEditarFragment() {
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frame_editar, new EditFragment()).addToBackStack(null).commit();
    }
}