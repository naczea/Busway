package com.example.busway1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Principal extends AppCompatActivity {

    //EXTRAS
    private Typeface TigerWalk2;
    private TextView txtlogo, txtlong, txtlat,txtok;
    private Button btnbuscar,btnenviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        //FUENTES
        String fuente1 = "fuentes/TigerWalk.ttf";
        this.TigerWalk2 = Typeface.createFromAsset(getAssets(),fuente1);
        txtlogo = (TextView) findViewById(R.id.txtlogo_register);
        txtlogo.setTypeface(TigerWalk2);

        txtlat = (TextView) findViewById(R.id.lat_driver);
        txtlong = (TextView) findViewById(R.id.long_driver);
        txtok = (TextView)findViewById(R.id.ok_driver);

        btnbuscar = (Button) findViewById(R.id.btnbuscar);
        btnenviar = (Button) findViewById(R.id.btnenviar);

        btnenviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                txtok.setText("Enviado con exito");

            }
        });

        btnbuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtlat.setText("-0.271613");
                txtlong.setText("-78.4630198");
            }
        });
    }
}