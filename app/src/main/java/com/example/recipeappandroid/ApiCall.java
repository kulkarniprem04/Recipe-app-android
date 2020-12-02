package com.example.recipeappandroid;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.recipeappandroid.Fragments.SearchFragment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ApiCall extends AsyncTask<String,Void,Void> {

    String API_key = "8e99e327d1f2130dc6ab3422e26a95e8";
    String APP_ID = "3f335994";
    String data;

    @Override
    protected Void doInBackground(String... params) {


        //Toast.makeText(mContext, query, Toast.LENGTH_LONG).show();

        try {
            String query = params[0];
            Log.d("QUERY",query);
            URL url = new URL("https://api.edamam.com/search?q=" + query + "&app_id="+ APP_ID + "&app_key=" + API_key);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while (line != null) {
                line = bufferedReader.readLine();
                data = data + line;
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        SearchFragment.fetchedText.setText(this.data);
    }
}
