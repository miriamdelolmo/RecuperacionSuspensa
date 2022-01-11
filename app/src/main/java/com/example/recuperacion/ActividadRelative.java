package com.example.recuperacion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ActividadRelative extends AppCompatActivity {
    TextView resultado;
    int contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_relative);

        resultado=findViewById(R.id.txtRes);
        contador=1;
    }

    public void operacion(View view) {
        switch (view.getId()){
            case R.id.por2:
                contador = contador * 2;
                break;
            case R.id.por1:
                contador = contador * 1;
                break;
            case R.id.div2:
                contador = contador / 2;
                break;
            case R.id.div1:
                contador = contador / 1;
                break;
            case R.id.btn1:
                contador=1;

        }
        resultado.setText(Integer.toString(contador));
    }
}