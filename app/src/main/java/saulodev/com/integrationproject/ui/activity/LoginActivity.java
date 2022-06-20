package saulodev.com.integrationproject.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import saulodev.com.integrationproject.R;
import saulodev.com.integrationproject.databinding.ActivityLoginBinding;
import saulodev.com.integrationproject.util.MyAlertDialog;
import saulodev.com.integrationproject.util.VerificarDados;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        btnEntrar();

        binding.cadastrarTxt.setOnClickListener(view -> {
            startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            finish();
        });
        
    }

    private void btnEntrar() {
        binding.entrarBtn.setOnClickListener(view -> {
            startActivity(new Intent(LoginActivity.this, HomeActivity.class));
            finish();

//
//            DialogFragment dialog = MyAlertDialog.newInstance();
//            dialog.show(getSupportFragmentManager(),"fragment");
        });
    }
}