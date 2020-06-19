package com.example.busway1;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {

    private static final String ruta ="http://192.168.43.238/bd_busway/register.php";
    private Map<String, String> parametros;
    public RegisterRequest(String dni_driv, String name_driv, String last_driv, String pass_driv, Response.Listener<String> listener){
        super(Method.POST, ruta, listener, null);
        parametros = new HashMap<>();
        parametros.put("dni_driv",dni_driv+"");
        parametros.put("name_driv",name_driv+"");
        parametros.put("last_driv",last_driv+"");
        parametros.put("pass_driv",pass_driv+"");

    }

    @Override
    protected Map<String, String> getParams() {
        return parametros;
    }
}
