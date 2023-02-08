package com.example.frasesaleatoriaschucknorris.framework;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.frasesaleatoriaschucknorris.R;

import java.util.List;

public final class StringSpinnerAdapter extends ArrayAdapter {
    public StringSpinnerAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
    }

    private View createViewIfDoesntExist(int position, View convertView, ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null)
            listItem = LayoutInflater.from(getContext()).inflate(R.layout.spinner_basic_string_item, parent, false);
        String currentItem = (String) getItem(position);
        TextView textView = listItem.findViewById(R.id.textViewBasicStringItem);
        if (currentItem == null) {
            textView.setText("");
        } else {
            textView.setText(currentItem);
        }
        return listItem;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return createViewIfDoesntExist(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null)
            listItem = LayoutInflater.from(getContext()).inflate(R.layout.spinner_basic_string_item, parent, false);
        String currentItem = (String) getItem(position);
        TextView textView = listItem.findViewById(R.id.textViewBasicStringItem);
        if (currentItem == null || currentItem.equals("")) {
            textView.setText("Selecione um item");
        } else {
            textView.setText(currentItem);
        }
        return listItem;
    }
}