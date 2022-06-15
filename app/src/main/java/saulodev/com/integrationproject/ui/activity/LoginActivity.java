package saulodev.com.integrationproject.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import saulodev.com.integrationproject.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        btnEntrar();
        btnLogin();
    }


    private void btnEntrar() {
        binding.entrarBtn.setOnClickListener(view -> {
            startActivity(new Intent(LoginActivity.this, HomeActivity.class));
            finish();
        });
    }

    private void btnLogin() {
        binding.cadastrarTxt.setOnClickListener(view -> {
            startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            finish();
        });
    }
}