package saulodev.com.integrationproject.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import saulodev.com.integrationproject.R;
import saulodev.com.integrationproject.ui.fragment.AreaPixFragment;
import saulodev.com.integrationproject.ui.fragment.HomeFragment;

public class AreaPixActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_pix);

        replaceFragment(new AreaPixFragment());
    }
    public void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frame_pix, fragment).commit();
    }
}