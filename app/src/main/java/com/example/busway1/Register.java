package com.example.busway1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity{

    //ELEMENTOS REFERENCIADOS
    private TextView txtlogo_register;
    //EXTRAS
    private Typeface TigerWalk2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //CREACION
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //FUENTE
        String fuente2 = "fuentes/TigerWalk.ttf";
        this.TigerWalk2 = Typeface.createFromAsset(getAssets(),fuente2);
        txtlogo_register = (TextView) findViewById(R.id.txtlogo_register);
        txtlogo_register.setTypeface(TigerWalk2);

        //REFERENCIAS

        final EditText dni_driv = (EditText) findViewById(R.id.dni_driv);
        final EditText name_driv = (EditText) findViewById(R.id.name_driv);
        final EditText last_driv = (EditText) findViewById(R.id.last_driv);
        final EditText pass_driv = (EditText) findViewById(R.id.pass_driv);
        final EditText unity = (EditText) findViewById(R.id.unity);
        final CheckBox typeAz = (CheckBox) findViewById(R.id.typeAz);
        final CheckBox typeLi = (CheckBox) findViewById(R.id.typeLi);

        Button btnreg2 = (Button) findViewById(R.id.btnreg2);

        btnreg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent register = new Intent(Register.this,Login.class);
                Register.this.startActivity(register);
                finish();
            }
        });

        /*btnreg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String dni_d = dni_driv.getText().toString();
                final String name_d = name_driv.getText().toString();
                final String last_d = last_driv.getText().toString();
                final String pass_d = pass_driv.getText().toString();

                Response.Listener<String> respuesta = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{

                            JSONObject jsonRespuesta = new JSONObject(response);
                            boolean ok = jsonRespuesta.getBoolean("success");
                            if (ok == true){
                                Intent q = new Intent(Register.this,Login.class);
                                Register.this.startActivity(q);
                                Register.this.finish();
                            }else{
                                AlertDialog.Builder alerta = new AlertDialog.Builder(Register.this);
                                alerta.setMessage("Fallo en el Registro").setNegativeButton("Reintentar",null).create().show();
                            }

                        }catch (JSONException e){
                            e.getMessage();
                        }
                    }
                };
                RegisterRequest s = new RegisterRequest(dni_d, name_d, last_d, pass_d, respuesta);
                RequestQueue cola1 = Volley.newRequestQueue(Register.this);
                cola1.add(s);

            }
        });*/
    }
}
