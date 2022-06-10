package saulodev.com.integrationproject.util;

import android.content.Context;
import android.widget.EditText;

import androidx.core.app.ActivityCompat;

import com.google.android.material.textfield.TextInputLayout;

import saulodev.com.integrationproject.R;

public class ErrorEditText {

    public static void setError(EditText editText, Context context) {
        editText.setTextColor(ActivityCompat.getColor(context, R.color.errorColor));
    }

    public static void resetEditText(EditText editText, Context context) {
        editText.setTextColor(ActivityCompat.getColor(context, R.color.black));
    }
}
