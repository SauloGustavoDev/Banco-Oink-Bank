package saulodev.com.integrationproject.ui.viewmodel;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    //SHARED PREFERENCES
    private static SharedPreferences sharedPreferences = null;

    public void iniciarSharedPreferences(){
        //sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
    }

    public String recuperarIdSharedPreferences(){
         return sharedPreferences.getString("armazenamento", null);
    }

    public void deletarIdSharedPreferences(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("armazenamento", " ");
        editor.apply();
    }

    public void salvarID(String id){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("armazenamento", id);
        editor.apply();
    }

    public void dessativarSharedPreferences(){
        sharedPreferences = null;
    }

    // TODO: Implement the ViewModel
}