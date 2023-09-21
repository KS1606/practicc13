package com.example.diolog_okna;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText dateTxt, timeTxt;
    ImageButton dateBtn, timeBtn;
    Button applyBtn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dateTxt =findViewById(R.id.date_txt);
        timeTxt = findViewById(R.id.time_txt);
        dateBtn = findViewById(R.id.date_change);
        timeBtn = findViewById(R.id.time_change);
        applyBtn = findViewById(R.id.apply_btn);

        dateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomDatePickerDialog customDatePickerDialog = new CustomDatePickerDialog(new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int day, int month, int year) {
                        dateTxt.setText(day + "-" + (month + 1) + "-" + year);
                    }
                });
                customDatePickerDialog.show(getSupportFragmentManager(), "custom_date_picker");
            }
        });

        timeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomTimePickerDialog customTimePickerDialog = new CustomTimePickerDialog(new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                        timeTxt.setText(hour + ":" + minute);
                    }
                });
                customTimePickerDialog.show(getSupportFragmentManager(), "custom_time_picker");
            }
        });

        applyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                LayoutInflater inflater = getLayoutInflater();
                View customDialogView = inflater.inflate(R.layout.custom_confirm_dialog, null);
                builder.setView(customDialogView)
                    .setPositiveButton("Подтвердить запись", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(MainActivity.this, "Запись прошла успешно", Toast.LENGTH_SHORT).show();

                            AlertDialog.Builder infoDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                            infoDialogBuilder.setTitle("Информация о записи")
                                .setMessage("Дата: " + dateTxt.getText() + "\n" +
                                    "Время: " + timeTxt.getText())
                                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });

                            AlertDialog infoDialog = infoDialogBuilder.create();
                            infoDialog.show();

                            dialogInterface.cancel();
                        }
                    })
                    .setNegativeButton("Отменить", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                builder.create().show();
            }
        });



    }

}




















































































