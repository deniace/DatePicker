package com.deni.datepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat simpleDateFormat;
    private TextView tvHasil;
    private Button btnPilih;
    private EditText etPilihTanggal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.US);

        tvHasil = findViewById(R.id.tv_hasil_tanggal);
        btnPilih = findViewById(R.id.btn_pilih);
        btnPilih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateDialog();
            }
        });

        etPilihTanggal = findViewById(R.id.et_pilih_tanggal);
        etPilihTanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateDialog();
            }
        });
    }

    private void showDateDialog(){
        // calendar untuk mendapatkan tanggal sekarang
        final Calendar calendar = Calendar.getInstance();

        // inisialisasi datepicker dialog
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                // method ini dipanggil setelah memilih tanggal
                // set kalender untuk menampung tanggal yang dipilih
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, month, dayOfMonth);

                // update textview untuk menampilkan tanggal yang dipilih
                tvHasil.setText("tanggal dipilih "+simpleDateFormat.format(newDate.getTime()));
                etPilihTanggal.setText("tanggal dipilih "+simpleDateFormat.format(newDate.getTime()));
            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }
}