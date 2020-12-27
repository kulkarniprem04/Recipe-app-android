package com.example.recipeappandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.recipeappandroid.Fragments.LandingFragment;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextView Login = (TextView) findViewById(R.id.register);
        Button loginButton = findViewById(R.id.loginbutton);
        EditText loginEmail ,loginPassword;
        loginEmail = findViewById(R.id.LoginEmail);
        loginPassword = findViewById(R.id.LoginPassword);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String LoginEmail = loginEmail.getText().toString();
                String LoginPassword = loginPassword.getText().toString();

                if (!TextUtils.isEmpty(LoginEmail) && !TextUtils.isEmpty(LoginPassword)) {
                    try {
                        LoginUser(LoginEmail, LoginPassword);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegisterActivity();
            }
        });
    }
    public void openRegisterActivity(){
        Intent intent =  new Intent( this, RegisterActivity.class);
        startActivity(intent);
    }

    public void LoginUser(final String email,final String password) throws JSONException {
        RequestQueue MyRequestQueue = Volley.newRequestQueue(this);
        String url = "http://192.168.0.107:5000/api/login/"; // <----enter your post url here
        JSONObject jsonObject = new JSONObject();
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
                    Toast.makeText(LoginActivity.this,success, Toast.LENGTH_SHORT).show();
                    if(success.equals("Login Successful")) {
                        Intent intent = new Intent(LoginActivity.this, LandingFragment.class);
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