package saulodev.com.integrationproject.ui.fragment;

import static android.R.attr.backgroundStacked;
import static android.R.attr.colorBackground;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import saulodev.com.integrationproject.R;
import saulodev.com.integrationproject.databinding.FragmentAreaPixBinding;
import saulodev.com.integrationproject.util.MyAlertDialog;


public class AreaPixFragment extends Fragment {

    private FragmentAreaPixBinding bind;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        bind = FragmentAreaPixBinding.inflate(inflater, container, false);
        View view = bind.getRoot();
        return view;
    }

    @SuppressLint({"ResourceType", "UseCompatLoadingForDrawables"})
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bind.pixQrcodeLinearBtn.setOnClickListener(view1 ->{
            MyAlertDialog myAlertDialog = new MyAlertDialog(R.layout.fragment_erro_inesperado);
        DialogFragment dialog = myAlertDialog;
        dialog.show(requireActivity().getSupportFragmentManager(),"fragment");

        });

        bind.linearPixCelular.setOnClickListener(view1 ->{
            MyAlertDialog myAlertDialog = new MyAlertDialog(R.layout.fragment_erro_404);
            DialogFragment dialog = myAlertDialog;
            dialog.show(requireActivity().getSupportFragmentManager(),"fragment");

        });

        bind.pixCpfLinearBtn.setOnClickListener(view1 ->{
            MyAlertDialog myAlertDialog = new MyAlertDialog(R.layout.fragment_erro_transacao);
            DialogFragment dialog = myAlertDialog;
            dialog.show(requireActivity().getSupportFragmentManager(),"fragment");

        }); bind.pixEmailLinearBtn.setOnClickListener(view1 ->{
            MyAlertDialog myAlertDialog = new MyAlertDialog(R.layout.fragment_transferencia_recebida);
            DialogFragment dialog = myAlertDialog;
            dialog.show(requireActivity().getSupportFragmentManager(),"fragment");

        });

        bind.minhasChavesBtn.setOnClickListener(view1 -> {
            replaceMinhasChavesFragment();
        });

        bind.pixCopiaColaLinearBtn.setOnClickListener(view1 -> {
            replacePixCopiaColaFragment();
        });

        bind.pixReceberLinearBtn.setOnClickListener(view1 -> {
            replaceCobrarFragment();
        });

        bind.voltarImgBtn.setOnClickListener(view1 -> {
            requireActivity().onBackPressed();
        });

    }


    private void replaceMinhasChavesFragment() {
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frame, new MinhasChavesFragment()).addToBackStack(null).commit();
    }

    private void replacePixCopiaColaFragment(){
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frame, new PixCopiaColaFragment()).addToBackStack(null).commit();
    }

    private void replaceCobrarFragment(){
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frame, new CobrarFragment()).addToBackStack(null).commit();
    }


}

