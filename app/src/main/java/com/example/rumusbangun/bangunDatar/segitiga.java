package com.example.rumusbangun.bangunDatar;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.rumusbangun.R;

public class segitiga extends AppCompatActivity {
    EditText editTextAlas;

    EditText editTextTinggi;
    TextView textViewHasil;

    Button buttonHitung;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segitiga);
        textViewHasil = findViewById(R.id.tvhasil);
        editTextAlas = findViewById(R.id.Alas_Segitiga);
        editTextTinggi = findViewById(R.id.Tinggi_Segitiga);
        buttonHitung = findViewById(R.id.btnhitung);

        buttonHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textAlas = editTextAlas.getText().toString();
                String textTinggi = editTextTinggi.getText().toString();
                if (textAlas.isEmpty() || textTinggi.isEmpty()) {
                    // Jika EditText alas atau tinggi kosong, tampilkan pesan kesalahan
                    Toast.makeText(segitiga.this, "Harap masukkan alas dan tinggi terlebih dahulu", Toast.LENGTH_SHORT).show();
                } else {
                    float alas = Float.parseFloat(textAlas);
                    float tinggi = Float.parseFloat(textTinggi);
                    float area = (float) Math.round(alas * tinggi / 2);
                    textViewHasil.setText("Luas: " + area);
                }
            }
        });
    }
}
