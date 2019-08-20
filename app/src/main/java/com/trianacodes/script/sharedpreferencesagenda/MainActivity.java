package com.trianacodes.script.sharedpreferencesagenda;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et_nombre, et_datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_nombre = findViewById(R.id.et_Nombre);
        et_datos = findViewById(R.id.ml_Datos);

    }

    public void guardar(View view){

        String nombre_contacto = et_nombre.getText().toString();
        String datos_contacto = et_datos.getText().toString();

        SharedPreferences preferencias = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferencias.edit();
        editor.putString(nombre_contacto, datos_contacto);
        editor.commit();
        Toast.makeText(this, "Contacto guardado correctamente", Toast.LENGTH_LONG).show();

    }

    public void Buscar(View view){

        String nombre_contacto = et_nombre.getText().toString();

        SharedPreferences preferencias = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        String datos_contacto = preferencias.getString(nombre_contacto, "");
        if (datos_contacto.length() == 0){
            Toast.makeText(this, "No existe el contacto", Toast.LENGTH_LONG).show();
        } else {
            et_datos.setText(datos_contacto);
        }

    }

}
