package saulodev.com.integrationproject.util;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.DialogFragment;

import saulodev.com.integrationproject.R;

public class MyAlertDialog extends DialogFragment implements View.OnClickListener{

    private int mLayout;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialogTheme);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

                View view = inflater.inflate(mLayout,container,false);
                Button fechar = view.findViewById(R.id.sair_btn);
                fechar.setOnClickListener(this);
                return view;
    }

    public MyAlertDialog(int layout){
        this.mLayout = layout;
    }


    @Override
    public void onClick(View view) {
        dismiss();
    }

}
