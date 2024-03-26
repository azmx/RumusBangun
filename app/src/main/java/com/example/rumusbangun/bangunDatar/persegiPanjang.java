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

public class persegiPanjang extends AppCompatActivity {

    EditText editTextPanjang,editTextLebar;
    TextView textViewHasil;
    Button buttonHitung;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.persegi_panjang);
        editTextLebar = findViewById(R.id.Lebar_Persegi_panjang);
        editTextPanjang = findViewById(R.id.Panjang_Persegi_panjang);
        textViewHasil = findViewById(R.id.tvhasil);
        buttonHitung = findViewById(R.id.btnhitung);

        buttonHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strPanjang = editTextPanjang.getText().toString().trim();
                String strLebar = editTextLebar.getText().toString().trim();

                if (strPanjang.isEmpty() || strLebar.isEmpty()) {
                    // Show error message for empty fields
                    Toast.makeText(persegiPanjang.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Parse the input values to double
                double panjang = Double.parseDouble(strPanjang);
                double lebar = Double.parseDouble(strLebar);

                // Calculate the area
                double area = panjang * lebar;

                // Set the result in the TextView
                textViewHasil.setText("Area: " + area);
            }
        });
    }
}
