package com.example.android.taller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Principal extends AppCompatActivity {


    private EditText cajaPrimerNombre;
    private EditText cajaSegundoNombre;
    private EditText cajaPrimerApellido;
    private EditText cajaSegundoApellido;
    private EditText cajaEdad;
    private EditText cajaSexo;
    private Intent i;
    private Bundle b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);


        cajaPrimerNombre = (EditText)findViewById(R.id.txtPrimerNombre);
        cajaSegundoNombre = (EditText)findViewById(R.id.txtSegundoNombre);
        cajaPrimerApellido = (EditText)findViewById(R.id.txtPrimerApellido);
        cajaSegundoApellido = (EditText)findViewById(R.id.txtSegundoApellido);
        cajaEdad = (EditText)findViewById(R.id.txtEdad);
        cajaSexo = (EditText)findViewById(R.id.txtSexo);


        i = new Intent(this, Mostrar.class);

        b = new Bundle();

    }


    public void saludar(View v){
        String nom1, nom2, apell1, apell2, edad, sexo;

        if(validar()==true) {

            nom1 = cajaPrimerNombre.getText().toString();
            nom2 = cajaSegundoNombre.getText().toString();
            apell1 = cajaPrimerApellido.getText().toString();
            apell2 = cajaSegundoApellido.getText().toString();
            edad = cajaEdad.getText().toString();
            sexo = cajaSexo.getText().toString();


            b.putString("PrimerNombre", nom1);
            b.putString("SegundoNombre", nom2);
            b.putString("PrimerApellido", apell1);
            b.putString("SegundoApellido", apell2);
            b.putString("Edad", edad);
            b.putString("Sexo", sexo);


            i.putExtras(b);

            
            startActivity(i);

        }

    }

    public void borrar(View v){
        cajaPrimerNombre.setText("");
        cajaSegundoNombre.setText("");
        cajaPrimerApellido.setText("");
        cajaSegundoApellido.setText("");
        cajaEdad.setText("");
        cajaSexo.setText("");
        cajaPrimerNombre.requestFocus();

    }



    public boolean validar(){
        if(cajaPrimerNombre.getText().toString().isEmpty()){
            cajaPrimerNombre.setError(getResources().getString(R.string.error_1));
            return false;
        }
        if(cajaSegundoNombre.getText().toString().isEmpty()){
            cajaSegundoNombre.setError(getResources().getString(R.string.error_2));
            return false;
        }
        if(cajaPrimerApellido.getText().toString().isEmpty()){
            cajaPrimerApellido.setError(getResources().getString(R.string.error_3));
            return false;
        }
        if(cajaSegundoApellido.getText().toString().isEmpty()){
            cajaSegundoApellido.setError(getResources().getString(R.string.error_4));
            return false;
        }
        if(cajaEdad.getText().toString().isEmpty()){
            cajaEdad.setError(getResources().getString(R.string.error_5));
            return false;
        }
        if(cajaSexo.getText().toString().isEmpty()){
            cajaSexo.setError(getResources().getString(R.string.error_6));
            return false;
        }
        return  true;
    }

}
