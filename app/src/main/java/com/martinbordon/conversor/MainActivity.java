package com.martinbordon.conversor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.martinbordon.conversor.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private MainActivityModel mv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioButton radioActivado = findViewById(R.id.radioDolarAP);
        RadioButton radioDesactivado = findViewById(R.id.radioPesosAD);
        EditText editTextDolar = findViewById(R.id.etDolar);
        EditText editTextPeso = findViewById(R.id.etPesos);
        radioActivado.setOnClickListener(view -> mv.setActiveField(1));
        radioDesactivado.setOnClickListener(view -> mv.setActiveField(2));
        Button buttonconvert = findViewById(R.id.btConvertir);
        TextView resultadoOb = findViewById(R.id.tvResultado);
        editTextDolar.setText("0");
        editTextPeso.setText("0");
        mv = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityModel.class);
        mv.getConversionMutalbe().observe(this, new Observer<Double>() {
            @Override
            public void onChanged(Double cambio) {
                resultadoOb.setText(cambio.toString());
                Log.d("salida", resultadoOb.getText().toString());
            }
        });


        mv.getActiveField().observe(this, activeFieldNumber -> {
            editTextDolar.setEnabled(activeFieldNumber == 2);
            editTextPeso.setEnabled(activeFieldNumber == 1);
            editTextDolar.setText("0");
            editTextPeso.setText("0");
        });

        buttonconvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mv.handleConvert(Double.parseDouble(editTextDolar.getText().toString()),Double.parseDouble(editTextPeso.getText().toString()));
            }
        });

    }




}