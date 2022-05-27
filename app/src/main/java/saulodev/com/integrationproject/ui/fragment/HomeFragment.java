package saulodev.com.integrationproject.ui.fragment;

import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import saulodev.com.integrationproject.R;
import saulodev.com.integrationproject.databinding.FragmentHomeBinding;
import saulodev.com.integrationproject.ui.viewmodel.HomeViewModel;

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

        int inputTypePass = bind.txtSaldo.getInputType();
        bind.txtSaldo.setInputType(inputTypePass);


        bind.btnHide.setOnClickListener(view1 ->{
            int inputType = bind.txtSaldo.getInputType();

            if(inputType == inputTypePass){
                bind.btnHide.setBackground(getResources().getDrawable(R.drawable.ic_eye_ios));
                bind.txtSaldo.setInputType(InputType.TYPE_NUMBER_VARIATION_NORMAL);
            }else {
                bind.txtSaldo.setInputType(inputTypePass);
                bind.btnHide.setBackground(getResources().getDrawable(R.drawable.ic_eye_off_ios));

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