package saulodev.com.integrationproject.ui.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import saulodev.com.integrationproject.R;
import saulodev.com.integrationproject.databinding.FragmentAreaPixBinding;
import saulodev.com.integrationproject.databinding.FragmentHomeBinding;
import saulodev.com.integrationproject.ui.fragment.AreaPixFragment;
import saulodev.com.integrationproject.ui.fragment.HomeFragment;

public class AreaPixActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_pix);

        //Replace Home Fragment Here
        replaceFragment(new AreaPixFragment());
    }

    public void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frame, fragment).commit();
    }
}