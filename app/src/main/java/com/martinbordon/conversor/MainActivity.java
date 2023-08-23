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
        Button ButtonConvertir = findViewById(R.id.btConvertir);
        EditText editTextDolar = findViewById(R.id.etDolar);
        EditText editTextPeso = findViewById(R.id.etPesos);
        radioActivado.setOnClickListener(view -> mv.setActiveField(1));
        radioDesactivado.setOnClickListener(view -> mv.setActiveField(2));
        mv = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityModel.class);
        mv.getConversionMutalbe().observe(this, new Observer<Double>() {
            @Override
            public void onChanged(Double aDouble) {

            }
        });

        mv.getActiveField().observe(this, activeFieldNumber -> {
            editTextDolar.setEnabled(activeFieldNumber == 2);
            editTextPeso.setEnabled(activeFieldNumber == 1);



        });
    }


}