package com.example.diolog_okna;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TimePicker;
import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.appcompat.app.AlertDialog;

public class CustomTimePickerDialog extends DialogFragment {

    TimePickerDialog.OnTimeSetListener onTimeSetListener;

    public CustomTimePickerDialog(TimePickerDialog.OnTimeSetListener onTimeSetListener) {
        this.onTimeSetListener = onTimeSetListener;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.custom_time_picker, null);
        TimePicker timePicker = view.findViewById(R.id.custom_time_picker);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(view)
            .setPositiveButton("OK", (dialog, id) -> {
                int hour = timePicker.getHour();
                int minute = timePicker.getMinute();
                onTimeSetListener.onTimeSet(timePicker, hour, minute);
            })
            .setNegativeButton("Отмена", (dialog, id) -> {
            });
        return builder.create();
    }
}
