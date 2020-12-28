package com.example.recipeappandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.recipeappandroid.Fragments.LandingFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        TextView Login = (TextView) findViewById(R.id.account);
        Button register = findViewById(R.id.register);
        EditText name, email, password;
        name = findViewById(R.id.RegisterUsername);
        email = findViewById(R.id.Email);
        password = findViewById(R.id.Password);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String RegisterName = name.getText().toString();
                String RegisterEmail = email.getText().toString();
                String RegisterPassword = password.getText().toString();
                Log.d("CLICK","CLICKED");

                if (!TextUtils.isEmpty(RegisterEmail) && !TextUtils.isEmpty(RegisterPassword)) {
                    try {
                        RegisterUser(RegisterName, RegisterEmail, RegisterPassword);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            }
        });

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLoginActivity();
            }
        });
    }
    public void openLoginActivity(){

        Intent intent =  new Intent( this, LoginActivity.class);
        startActivity(intent);
    }

    public void RegisterUser(final String name,final String email, final String password) throws JSONException {
        RequestQueue MyRequestQueue = Volley.newRequestQueue(this);
        String url = "https://eatright-recipeapp.herokuapp.com/api/register/"; // <----enter your post url here
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", name);
        jsonObject.put("email",email);
        jsonObject.put("password",password);
        final String mRequestBody = jsonObject.toString();
        Log.d("REQUESTBODY",mRequestBody);
        StringRequest MyStringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String success = jsonObject.getString("message");
                    if(success.equals("success")) {
                        Toast.makeText(RegisterActivity.this,"Registered successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(RegisterActivity.this, searchActivity.class);

                        startActivity(intent);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() { //Create an error listener to handle errors appropriately.
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        })
        {
            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }

            @Override
            public byte[] getBody() throws AuthFailureError {
                try {
                    return mRequestBody == null ? null : mRequestBody.getBytes("utf-8");
                } catch (UnsupportedEncodingException uee) {
                    VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", mRequestBody, "utf-8");
                    return null;
                }
            }
        };
        /*{
            protected Map<String, String> getParams() {
                Map<String, String> MyData = new HashMap<String, String>();
                MyData.put("name",name);
                MyData.put("email", email);
                MyData.put("password", password);
                return MyData;
            }
        };*/


        MyRequestQueue.add(MyStringRequest);
    }
}