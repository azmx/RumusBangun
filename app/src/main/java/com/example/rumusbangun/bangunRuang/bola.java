package com.example.rumusbangun.bangunRuang;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rumusbangun.R;

public class bola extends AppCompatActivity {
    EditText editTextJariJari;
    TextView textViewHasil;
    Button buttonHitung;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bola);
        editTextJariJari = findViewById(R.id.jariJari);
        textViewHasil = findViewById(R.id.tvhasil);
        buttonHitung = findViewById(R.id.btnhitung);

        buttonHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the value of the EditText field
                String jariJariText = editTextJariJari.getText().toString().trim();

                // Check if the field is empty
                if (jariJariText.isEmpty()) {
                    // Display an error message
                    Toast.makeText(bola.this, "Please fill in the field", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Convert the value to a number
                float jariJari = Float.parseFloat(jariJariText);

                // Perform the calculation
                float surfaceArea = (4 * Math.round(Math.PI * jariJari * jariJari));


                // Display the result in the TextView
                textViewHasil.setText(String.valueOf(surfaceArea));
            }
        });
    }
}