package saulodev.com.integrationproject.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import saulodev.com.integrationproject.R;
import saulodev.com.integrationproject.ui.fragment.ExtratoFragment;
import saulodev.com.integrationproject.ui.fragment.FerramentasFragment;
import saulodev.com.integrationproject.ui.fragment.HomeFragment;

public class HomeActivity extends AppCompatActivity {

    private BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNav = findViewById(R.id.bottom_nav_home);

        //Replace Home Fragment Here
        replaceFragment(new HomeFragment());

        bottomNav.setOnItemSelectedListener(item -> {

            switch (item.getItemId()) {
                case R.id.home:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.extrato:
                    replaceFragment(new ExtratoFragment());
                    break;
                case R.id.ferramentas:
                    replaceFragment(new FerramentasFragment());
                    break;
                default:
            }
            return true;
        });
    }

    public void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frame, fragment).commit();
    }
}