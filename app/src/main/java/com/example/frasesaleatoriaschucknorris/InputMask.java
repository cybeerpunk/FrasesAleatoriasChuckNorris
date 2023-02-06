package com.example.frasesaleatoriaschucknorris;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public final class InputMask implements TextWatcher {

    String mask;
    EditText editText;
    boolean isUpdating;
    String old = "";

    public InputMask(EditText editText, String mask) {
        this.mask = mask;
        this.editText = editText;
    }

    private String unmask(final String s) {
        return s.replaceAll("[.]", "").replaceAll("[-]", "").replaceAll("[/]", "").replaceAll("[(]", "").replaceAll("[ ]", "").replaceAll("[:]", "").replaceAll("[)]", "");
    }

    @Override
    public void beforeTextChanged(final CharSequence s, final int start, final int count, final int after) {
    }

    @Override
    public void onTextChanged(final CharSequence s, final int start, final int before, final int count) {
        final String str = unmask(s.toString());
        StringBuilder mascara = new StringBuilder();
        if (isUpdating) {
            old = str;
            isUpdating = false;
            return;
        }
        int i = 0;
        for (final char m : mask.toCharArray()) {
            if (m != '#' && str.length() > old.length()) {
                mascara.append(m);
                continue;
            }
            try {
                mascara.append(str.charAt(i));
            } catch (final Exception e) {
                break;
            }
            i++;
        }
        isUpdating = true;
        this.editText.setText(mascara.toString());
        this.editText.setSelection(mascara.length());
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}