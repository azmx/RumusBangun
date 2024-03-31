package com.example.rumusbangun.bangunRuang;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rumusbangun.R;

public class kubus extends AppCompatActivity {

    EditText editTextSisi;
    TextView textViewHasil;
    Button buttonHitung;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kubus);
        editTextSisi = findViewById(R.id.SisiKubus);
        textViewHasil = findViewById(R.id.tvhasil);
        buttonHitung = findViewById(R.id.btnhitung);
        buttonHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the value of the EditText field
                String sisiText = editTextSisi.getText().toString().trim();

                // Check if the field is empty
                if (sisiText.isEmpty()) {
                    // Display an error message
                    Toast.makeText(kubus.this, "Please fill in the field", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Convert the value to a number
                double sisi = Double.parseDouble(sisiText);

                // Perform the calculation
                double surfaceArea = 6 * (sisi * sisi);

                // Display the result in the TextView
                textViewHasil.setText(String.valueOf(surfaceArea));
            }
        });
    }
}