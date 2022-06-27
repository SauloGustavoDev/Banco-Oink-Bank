package saulodev.com.integrationproject.ui.fragment;

import static android.R.attr.colorBackground;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import saulodev.com.integrationproject.R;
import saulodev.com.integrationproject.databinding.FragmentAreaPixBinding;


public class AreaPixFragment extends Fragment {

    private FragmentAreaPixBinding bind;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        bind = FragmentAreaPixBinding.inflate(inflater, container, false);
        return bind.getRoot();
    }

    @SuppressLint({"ResourceType", "UseCompatLoadingForDrawables"})
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


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

