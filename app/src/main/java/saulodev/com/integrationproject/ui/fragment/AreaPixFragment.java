package saulodev.com.integrationproject.ui.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import saulodev.com.integrationproject.R;
import saulodev.com.integrationproject.databinding.FragmentAreaPixBinding;
import saulodev.com.integrationproject.ui.fragment.CobrarFragment;
import saulodev.com.integrationproject.ui.fragment.MinhasChavesFragment;
import saulodev.com.integrationproject.ui.fragment.PixCopiaColaFragment;
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

        bind.btnVisibility.setOnClickListener(view1 -> {
            Animation animation_baixo = AnimationUtils.loadAnimation(getActivity(), R.anim.animation_baixo);
            Animation animation_cima = AnimationUtils.loadAnimation(getActivity(), R.anim.animation_cima);
            Animation animation_btn = AnimationUtils.loadAnimation(getActivity(), R.anim.animation_btn);

            if (bind.layoutGone.getVisibility() == View.GONE){
                bind.layoutGone.setVisibility(View.VISIBLE);
                bind.layoutGone.startAnimation(animation_baixo);
                bind.btnVisibility.startAnimation(animation_btn);
                bind.btnVisibility.setImageResource(R.drawable.ic_seta_cima);
            }else {
                bind.layoutGone.startAnimation(animation_cima);
                bind.layoutGone.setVisibility(View.GONE);
                bind.btnVisibility.startAnimation(animation_btn);
                bind.btnVisibility.setImageResource(R.drawable.ic_seta_baixo);
            }

        });

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

        bind.btnVoltar.setOnClickListener(view1 -> {
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