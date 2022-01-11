package com.example.recuperacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class InsertarBBDD extends AppCompatActivity {

    Helper helper;
    SQLiteDatabase db;

    EditText modelo, marca, cv, uptModelo, uptCv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_bbdd);

        helper=new Helper(this);
        modelo=findViewById(R.id.modelo);
        marca=findViewById(R.id.marca);
        cv=findViewById(R.id.cv);

        uptModelo =findViewById(R.id.updateMarca);
        uptCv=findViewById(R.id.updateCvTxt);
    }

    public void insertar(View view) {
        if (modelo.getText().toString().isEmpty()||marca.getText().toString().isEmpty()||cv.getText().toString().isEmpty()){
            Toast.makeText(this,"Faltan huecos por rellenar",Toast.LENGTH_SHORT).show();
            return;
        } else{
            db=helper.getWritableDatabase();
            ContentValues values= new ContentValues();
            values.put("modelo", modelo.getText().toString());
            values.put("marca", marca.getText().toString());
            values.put("cv", cv.getText().toString());
            db.insert("tbCoches", null, values);

            modelo.setText("");
            marca.setText("");
            cv.setText("");

            db.close();

            Toast.makeText(this,"Se han insertado los datos",Toast.LENGTH_SHORT).show();


        }
    }

    public void modificar(View view) {
        if (uptModelo.getText().toString().isEmpty()||uptCv.getText().toString().isEmpty()){
            Toast.makeText(this,"Faltan huecos por rellenar",Toast.LENGTH_SHORT).show();
            return;
        } else{
            db=helper.getWritableDatabase();
            ContentValues values= new ContentValues();

            values.put("modelo", uptModelo.getText().toString());
            values.put("cv", uptCv.getText().toString());


          //  db.update("tbCoches", values, "modelo", "" );

            db.execSQL("update tbCoches set cv = "+uptCv.getText().toString()+" where modelo = "+uptModelo.getText().toString());

            uptModelo.setText("");
            uptCv.setText("");

            db.close();

            Toast.makeText(this,"Se han modificado los datos",Toast.LENGTH_SHORT).show();


        }
    }


}