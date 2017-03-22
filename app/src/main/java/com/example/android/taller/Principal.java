package com.example.android.taller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Principal extends AppCompatActivity {

    //Declaramos variables...........
    private EditText cajaPrimerNombre;
    private EditText cajaSegundoNombre;
    private EditText cajaPrimerApellido;
    private EditText cajaSegundoApellido;
    private EditText cajaEdad;
    private EditText cajaSexo;
    private Intent i;//Para pasar de una actividad a otra
    private Bundle b;//Mantiene los objetos encapsulados

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        //Capturamos la cajas
        cajaPrimerNombre = (EditText)findViewById(R.id.txtPrimerNombre);
        cajaSegundoNombre = (EditText)findViewById(R.id.txtSegundoNombre);
        cajaPrimerApellido = (EditText)findViewById(R.id.txtPrimerApellido);
        cajaSegundoApellido = (EditText)findViewById(R.id.txtSegundoApellido);
        cajaEdad = (EditText)findViewById(R.id.txtEdad);
        cajaSexo = (EditText)findViewById(R.id.txtSexo);

        //Creamos el objeto intent
        i = new Intent(this, Mostrar.class);

        b = new Bundle();

    }


    public void saludar(View v){
        String nom1, nom2, apell1, apell2, edad, sexo;

        if(validar()==true) {
            //Tomo el Valor que la persona ingresa...
            nom1 = cajaPrimerNombre.getText().toString();
            nom2 = cajaSegundoNombre.getText().toString();
            apell1 = cajaPrimerApellido.getText().toString();
            apell2 = cajaSegundoApellido.getText().toString();
            edad = cajaEdad.getText().toString();
            sexo = cajaSexo.getText().toString();

            //Encapsulo los datos previamente tomados...
            b.putString("PrimerNombre", nom1);
            b.putString("SegundoNombre", nom2);
            b.putString("PrimerApellido", apell1);
            b.putString("SegundoApellido", apell2);
            b.putString("Edad", edad);
            b.putString("Sexo", sexo);

            //Le paso al intent todos los datos en forma encapsulada con el bundle....
            i.putExtras(b);

            //Arranco la actividad que el intent me diga...
            startActivity(i);

            // aux = cajaNombre.getText().toString();
            // cajaMensaje.setText(getResources().getString(R.string.parte_saludo)+" "+aux);
        }

    }

    public boolean validar(){
        if(cajaPrimerNombre.getText().toString().isEmpty()){
            //Toast.makeText(this,"Digite por favor el nombre", Toast.LENGTH_SHORT);
            cajaPrimerNombre.setError(getResources().getString(R.string.error_1));
            return false;
        }
        if(cajaSegundoNombre.getText().toString().isEmpty()){
            //Toast.makeText(this,"Digite por favor el nombre", Toast.LENGTH_SHORT);
            cajaSegundoNombre.setError(getResources().getString(R.string.error_1));
            return false;
        }
        if(cajaPrimerApellido.getText().toString().isEmpty()){
            //Toast.makeText(this,"Digite por favor el nombre", Toast.LENGTH_SHORT);
            cajaPrimerApellido.setError(getResources().getString(R.string.error_1));
            return false;
        }
        if(cajaSegundoApellido.getText().toString().isEmpty()){
            //Toast.makeText(this,"Digite por favor el nombre", Toast.LENGTH_SHORT);
            cajaSegundoApellido.setError(getResources().getString(R.string.error_1));
            return false;
        }
        if(cajaEdad.getText().toString().isEmpty()){
            //Toast.makeText(this,"Digite por favor el apellido", Toast.LENGTH_SHORT);
            cajaEdad.setError(getResources().getString(R.string.error_2));
            return false;
        }
        if(cajaSexo.getText().toString().isEmpty()){
            //Toast.makeText(this,"Digite por favor el nombre", Toast.LENGTH_SHORT);
            cajaSexo.setError(getResources().getString(R.string.error_1));
            return false;
        }
        return  true;
    }
}
