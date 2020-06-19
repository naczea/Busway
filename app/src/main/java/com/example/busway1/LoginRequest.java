package com.example.busway1;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import java.util.HashMap;
import java.util.Map;

public class LoginRequest extends StringRequest {

    private static final String ruta="http://192.168.43.238/bd_busway/login.php";
    private Map<String, String> parametros;
    public LoginRequest(String dni_driv, String pass_driv, Response.Listener<String> listener){
        super(Method.POST, ruta, listener, null);
        parametros = new HashMap<>();
        parametros.put("dni_driv",dni_driv);
        parametros.put("pass_driv",pass_driv);
    }
    @Override
    protected Map<String, String> getParams() {
        return parametros;
    }
}
