package saulodev.com.integrationproject.util;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class mask_money implements TextWatcher {

        private final WeakReference<EditText> editTextWeakReference;
        private final Locale locale;
        public mask_money(EditText editText, Locale locale) {
            this.editTextWeakReference = new WeakReference<EditText>(editText);
            this.locale = locale != null ? locale : Locale.getDefault();
        }

        public mask_money(EditText editText) {
            this.editTextWeakReference = new WeakReference<EditText>(editText);
            this.locale = Locale.getDefault();
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            EditText editText = editTextWeakReference.get();
            if (editText == null) return;
            editText.removeTextChangedListener(this);
            BigDecimal parsed = parseToBigDecimal(editable.toString(), locale);
            String formatted = NumberFormat.getCurrencyInstance(locale).format(parsed);
            editText.setText(formatted);
            editText.setSelection(formatted.length());
            editText.addTextChangedListener(this);
        }

        private BigDecimal parseToBigDecimal(String value, Locale locale) {
            String replaceable = String.format("[%s,.\\s]", NumberFormat.getCurrencyInstance(locale).getCurrency().getSymbol());
            String cleanString = value.replaceAll(replaceable, "");
            return new BigDecimal(cleanString).setScale(
                    2, BigDecimal.ROUND_FLOOR).divide(new BigDecimal(100), BigDecimal.ROUND_FLOOR
            );
        }
}
