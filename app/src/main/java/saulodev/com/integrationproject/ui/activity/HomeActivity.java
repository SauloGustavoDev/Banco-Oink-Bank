package saulodev.com.integrationproject.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import saulodev.com.integrationproject.R;
import saulodev.com.integrationproject.ui.fragment.HomeFragment;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Replace Home Fragment Here
        replaceFragment();
    }

    public void replaceFragment(){

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frame, new HomeFragment()).addToBackStack(null).commit();
    }
}