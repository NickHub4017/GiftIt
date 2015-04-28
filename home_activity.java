package com.example.mygift.giftit;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by NRV on 4/25/2015.
 */
public class home_activity extends Activity {
    EditText Gen_inp;
    EditText Reltnsip_inp;
    EditText Age_group_inp;
    EditText Budget_inp;
    EditText keyword_inp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        keyword_inp=(EditText)findViewById(R.id.homeinputkeyword);
        Budget_inp=(EditText)findViewById(R.id.homeinputgender);
        Button sbmt_btn = (Button) findViewById(R.id.submit_data_btn);
        sbmt_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String keyword =keyword_inp.getText().toString();
                String url_to_get_data = "http://svcs.ebay.com/services/search/FindingService/v1?SECURITY-APPNAME=NithilaV-788f-4035-8c4f-c3327868468c&OPERATION-NAME=findItemsByKeywords&SERVICE-VERSION=1.0.0&RESPONSE-DATA-FORMAT=JSON&callback=_cb_findItemsByKeywords&REST-PAYLOAD&keywords="+keyword+"&paginationInput.entriesPerPage=3";
                new HttpAsyncTask().execute(url_to_get_data);


            }
        });
    }


    class HttpAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {

            InputStream inputStream = null;
            String result = "";
            try {

                // create HttpClient
                HttpClient httpclient = new DefaultHttpClient();

                // make GET request to the given URL
                HttpResponse httpResponse = httpclient.execute(new HttpGet(urls[0]));

                // receive response as inputStream
                inputStream = httpResponse.getEntity().getContent();

                // convert inputstream to string
                if (inputStream != null)
                    result = convertInputStreamToString(inputStream);
                else
                    result = "Did not work!";

            } catch (Exception e) {
                Log.d("InputStream", e.getLocalizedMessage());
            }

            return result;
        }

        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(getBaseContext(), result, Toast.LENGTH_LONG).show();
            Budget_inp.setText(result);
            Intent pref_int=new Intent(home_activity.this,preferred_activity.class);
            pref_int.putExtra("Json_data",result);
            startActivity(pref_int);
        }

        private String convertInputStreamToString(InputStream inputStream) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            String result = "";
            while ((line = bufferedReader.readLine()) != null)
                result += line;
            //Budget_inp.setText(result);
            inputStream.close();
            return result;

        }
    }

}

///Must change