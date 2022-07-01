package saulodev.com.integrationproject.ui.fragment;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import saulodev.com.integrationproject.R;
import saulodev.com.integrationproject.databinding.ActivityRegisterBinding;
import saulodev.com.integrationproject.databinding.FragmentCadastrarChavePixBinding;

public class CadastrarChavePixFragment extends Fragment {

    private FragmentCadastrarChavePixBinding bind;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        bind = FragmentCadastrarChavePixBinding.inflate(inflater, container, false);
        return bind.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bind.cadastrarChaveLayout.setBackgroundColor(getThemeBackgroundColor());

        bind.linearBtn.setOnClickListener(view1 -> {
            requireActivity().onBackPressed();
        });

    }


    public int getThemeBackgroundColor() {
        TypedArray array = getActivity().getTheme().obtainStyledAttributes(
                new int[] { android.R.attr.colorBackground });
        int backgroundColor = array.getColor(0, 0xFF00FF);
        array.recycle();
        return backgroundColor;
    }




}