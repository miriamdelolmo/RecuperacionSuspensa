package com.example.recuperacion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.opc1:
                actividadRelative();
            case R.id.opc2:
                Toast.makeText(this, "Aplicación almacén de coches", Toast.LENGTH_LONG).show();
            case R.id.opc3:
                actividadBBDD();
            default:
                return super.onOptionsItemSelected(item);
        }
    }

        public void mostrarToast (View view){
            Toast.makeText(this, "Aplicación almacén de coches", Toast.LENGTH_LONG).show();
        }

        public void siguienteActividad(View view) {

            actividadRelative();
        }

        private void actividadRelative() {
            Intent i = new Intent(this,ActividadRelative.class);
            startActivity(i);
        }

        public void siguienteActividad2(View view) {

            actividadBBDD();
        }

        private void actividadBBDD() {
            Intent i = new Intent(this,InsertarBBDD.class);
            startActivity(i);
        }
}