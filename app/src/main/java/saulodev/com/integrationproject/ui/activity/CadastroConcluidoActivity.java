package saulodev.com.integrationproject.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import saulodev.com.integrationproject.databinding.ActivityCadastroConcluidoBinding;

public class CadastroConcluidoActivity extends AppCompatActivity {

    private ActivityCadastroConcluidoBinding binding = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCadastroConcluidoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.entrarBtn.setOnClickListener(view -> {
            concluirCadastro();
        });
    }

    private void concluirCadastro(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}