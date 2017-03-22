package com.example.android.taller;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Mostrar extends AppCompatActivity {

    private TextView mostrar;
    private Bundle b;
    private String aux, nomb1, nomb2, apell1, apell2, edad, sexo;
    private Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);

        mostrar = (TextView)findViewById(R.id.txtMostrar);
        b = getIntent().getExtras();
        nomb1 = b.getString("PrimerNombre");
        nomb2 = b.getString("SegundoNombre");
        apell1 = b.getString("PrimerApellido");
        apell2 = b.getString("SegundoApellido");
        edad = b.getString("Edad");
        sexo = b.getString("Sexo");
        res = this.getResources();

        //Mensaje que muestra  bilingue........
        aux = res.getString(R.string.parte_saludo1)+" "+nomb1+" "+nomb2+" "+apell1+" "+apell2+" "+res.getString(R.string.parte_saludo2)+" "+edad+" "+res.getString(R.string.parte_saludo3)+" "+sexo;
        mostrar.setText(aux);
    }


}
