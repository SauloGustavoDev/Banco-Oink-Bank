package saulodev.com.integrationproject.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import saulodev.com.integrationproject.R;
import saulodev.com.integrationproject.databinding.FragmentEditBinding;
import saulodev.com.integrationproject.databinding.FragmentErroInesperadoBinding;

public class ErroInesperadoFragment extends Fragment {

    private FragmentErroInesperadoBinding bind;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        bind = FragmentErroInesperadoBinding.inflate(inflater, container, false);
        return bind.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}