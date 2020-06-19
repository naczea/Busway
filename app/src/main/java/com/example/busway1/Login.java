package com.example.busway1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {
    //ELEMENTOS
    TextView txtlogo;
    Button btnreg,btnin;
    //EXTRAS
    private Typeface TigerWalk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //ARRANQUE
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //FUENTES
        String fuente1 = "fuentes/TigerWalk.ttf";
        this.TigerWalk = Typeface.createFromAsset(getAssets(),fuente1);
        txtlogo = (TextView) findViewById(R.id.txtlogo_register);
        txtlogo.setTypeface(TigerWalk);

        //REFERENCIAS

        btnreg = (Button) findViewById(R.id.btnreg);
        btnin = (Button) findViewById(R.id.btnin);
        final EditText dni_d = (EditText) findViewById(R.id.txtuser);
        final EditText pass_d = (EditText) findViewById(R.id.txtpassw);

        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent register = new Intent(Login.this, Register.class);
                Login.this.startActivity(register);
                finish();
            }
        });

        btnin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent register2 = new Intent(Login.this, Principal.class);
                Login.this.startActivity(register2);
                finish();
            }
        });

        btnin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String dni_driv = dni_d.getText().toString();
                final String pass_driv = pass_d.getText().toString();

                Response.Listener<String> respuesta = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonRespuesta = new JSONObject(response);
                            boolean ok = jsonRespuesta.getBoolean("success");
                            if (ok == true){

                                String dni_driv = jsonRespuesta.getString("dni_driv");
                                String name_driv = jsonRespuesta.getString("name_driv");
                                Intent bienvenido = new Intent(Login.this,Principal.class);
                                bienvenido.putExtra("dni_driv",dni_driv);
                                bienvenido.putExtra("name_driv",name_driv);
                                Login.this.startActivity(bienvenido);
                                Login.this.finish();

                            }else{
                                AlertDialog.Builder alerta = new AlertDialog.Builder(Login.this);
                                alerta.setMessage("Fallo en el Login").setNegativeButton("Reintentar",null).create().show();
                            }

                        }catch (JSONException e){

                            e.getMessage();
                        }
                    }
                };

                LoginRequest p = new LoginRequest(dni_driv,pass_driv, respuesta);
                RequestQueue cola2 = Volley.newRequestQueue(Login.this);
                cola2.add(p);

            }
        });
    }
}
