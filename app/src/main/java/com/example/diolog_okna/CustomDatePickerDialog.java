package com.example.diolog_okna;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class CustomDatePickerDialog extends DialogFragment {

    DatePickerDialog.OnDateSetListener onDateSetListener;

    public CustomDatePickerDialog(DatePickerDialog.OnDateSetListener onDateSetListener) {
        this.onDateSetListener = onDateSetListener;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.custom_date_picker, null);
        DatePicker datePicker = view.findViewById(R.id.custom_date_picker);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(view)
            .setPositiveButton("OK", (dialog, id) -> {
                int day = datePicker.getDayOfMonth();
                int month = datePicker.getMonth();
                int year = datePicker.getYear();
                onDateSetListener.onDateSet(datePicker, year, month, day);
            })
            .setNegativeButton("Отмена", (dialog, id) -> {
            });
        return builder.create();
    }
}
