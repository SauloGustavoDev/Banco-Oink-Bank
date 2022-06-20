package saulodev.com.integrationproject.util;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import org.xmlpull.v1.XmlPullParser;

import saulodev.com.integrationproject.R;

public class MyAlertDialog extends DialogFragment implements View.OnClickListener{



    public static MyAlertDialog newInstance(){
        return new MyAlertDialog();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialogTheme);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


                View view = inflater.inflate(R.layout.fragment_erro_404,container,false);
                Button fechar = view.findViewById(R.id.sair_btn);
                fechar.setOnClickListener(this);
                return view;

    }

    @Override
    public void onClick(View view) {
        dismiss();
    }

}
