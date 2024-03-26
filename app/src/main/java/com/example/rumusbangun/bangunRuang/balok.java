package com.example.rumusbangun.bangunRuang;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rumusbangun.R;

public class balok extends AppCompatActivity {
    EditText editTextPanjang,getEditTextLebar,editTextTinggi;
    TextView textViewHasil;
    Button buttonHitung;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.balok);
        editTextTinggi = findViewById(R.id.tinggiBalok);
        getEditTextLebar = findViewById(R.id.lebarBalok);
        editTextPanjang = findViewById(R.id.panjangBalok);
        textViewHasil = findViewById(R.id.tvhasil);
        buttonHitung =  findViewById(R.id.btnhitung);

        buttonHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the values of the EditText fields
                String panjangText = editTextPanjang.getText().toString().trim();
                String lebarText = getEditTextLebar.getText().toString().trim();
                String tinggiText = editTextTinggi.getText().toString().trim();

                // Check if the fields are empty
                if (panjangText.isEmpty() || lebarText.isEmpty() || tinggiText.isEmpty()) {
                    // Display an error message
                    Toast.makeText(balok.this, "Please fill in all the fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Convert the values to numbers
                double panjang = Double.parseDouble(panjangText);
                double lebar = Double.parseDouble(lebarText);
                double tinggi = Double.parseDouble(tinggiText);

                // Perform the calculation
                double volume = 2 * ( (panjang * lebar) + (panjang * tinggi) + (lebar * tinggi) );

                // Display the result in the TextView
                textViewHasil.setText(String.valueOf(volume));
            }
        });
    }
}