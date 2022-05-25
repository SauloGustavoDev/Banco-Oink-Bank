package saulodev.com.integrationproject.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import java.util.Locale;

import saulodev.com.integrationproject.R;
import saulodev.com.integrationproject.databinding.ActivityRegisterBinding;
import saulodev.com.integrationproject.ui.util.mask_money;

public class RegisterActivity extends AppCompatActivity {

    private ActivityRegisterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityRegisterBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        initialMaskMoney();

    }

    private void initialMaskMoney(){
        Locale mLocale = new Locale("pt", "BR");
        binding.edtPatrimonio.addTextChangedListener(new mask_money(binding.edtPatrimonio, mLocale));
        binding.edtRenda.addTextChangedListener(new mask_money(binding.edtRenda, mLocale));
    }

}