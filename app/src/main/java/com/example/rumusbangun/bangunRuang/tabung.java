package com.example.rumusbangun.bangunRuang;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rumusbangun.R;

public class tabung extends AppCompatActivity {

    EditText editTextTinggi,editTextJariJari;
    TextView textViewHasil;
    Button buttonHasil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabung);
        editTextTinggi = findViewById(R.id.tinggi_Tabung);
        editTextJariJari = findViewById(R.id.jariJari);
        buttonHasil = findViewById(R.id.btnhitung);
        textViewHasil = findViewById(R.id.tvhasil);

        buttonHasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the values of the EditText fields
                String tinggiText = editTextTinggi.getText().toString().trim();
                String jariJariText = editTextJariJari.getText().toString().trim();

                // Check if the fields are empty
                if (tinggiText.isEmpty() || jariJariText.isEmpty()) {
                    // Display an error message
                    Toast.makeText(tabung.this, "Please fill in all the fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Convert the values to numbers
                float tinggi = Float.parseFloat(tinggiText);
                float jariJari = Float.parseFloat(jariJariText);

                // Perform the calculation
                float lateralSurfaceArea = 2 * Math.round(Math.PI * jariJari * (jariJari + tinggi));

                // Display the result in the TextView
                textViewHasil.setText(String.valueOf(lateralSurfaceArea));
            }
        });
    }
}