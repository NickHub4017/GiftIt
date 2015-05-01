package com.example.mygift.giftit;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by NRV on 5/1/2015.
 */
public class DetailView extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailview);
        SearchItem t=(SearchItem)getIntent().getSerializableExtra("SelObj");
        Toast.makeText(getApplicationContext(),t.getTitle(),Toast.LENGTH_LONG).show();

        LinearLayout l=(LinearLayout)findViewById(R.id.detailLine);
        ImageView p=(ImageView)findViewById(R.id.imageView2);
        p.setMaxWidth(l.getWidth());
        p.setMaxHeight(l.getHeight() / 2);

        //Bitmap bitmap = BitmapFactory.decodeFile("sdcard/x.jpg");
        //p.setImageBitmap(bitmap);
        Log.d("Image", "Async");
        Toast.makeText(getApplicationContext(),t.getGallURL(),Toast.LENGTH_LONG).show();
        new HttpAsyncTask2().execute(t.getGallURL());

        Log.d("Image", "***");
    }




    class HttpAsyncTask2 extends AsyncTask<String, Void, String> {
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            LinearLayout l=(LinearLayout)findViewById(R.id.detailLine);
            ImageView p=(ImageView)findViewById(R.id.imageView2);
            p.setMaxWidth(l.getWidth());
            p.setMaxHeight(l.getHeight() / 2);
            Bitmap bitmap = BitmapFactory.decodeFile("sdcard/x.jpg");
            p.setImageBitmap(bitmap);


            //p.setIma
        }

        @Override
        protected String doInBackground(String... sUrl) {
            InputStream input = null;
            OutputStream output = null;
            String u;
            HttpURLConnection connection = null;
            try {
                Log.d("Image", sUrl[0]);
                if (!sUrl[0].startsWith("http")) {
                    u = "http://" + sUrl[0];
                }
                else{
                u= sUrl[0];
                }

                Log.d("Image", u);
                URL url = new URL(u);
                //Log.d("Image", "thumbs1.ebaystatic.com//m//mOR0AuMSi9LLnSjryx8wE3Q//140.jpg");
                Log.d("Image", "con");
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();

                // expect HTTP 200 OK, so we don't mistakenly save error report
                // instead of the file
                Log.d("Image", "if");
                if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                    return "Server returned HTTP " + connection.getResponseCode()
                            + " " + connection.getResponseMessage();
                }

                // this will be useful to display download percentage
                // might be -1: server did not report the length
                int fileLength = connection.getContentLength();

                // download the file
                input = connection.getInputStream();
                Log.d("Image", "save");
                output = new FileOutputStream("sdcard/x.jpg");
                Log.d("Image", "byte");
                byte data[] = new byte[4096];
                long total = 0;
                int count;
                while ((count = input.read(data)) != -1) {
                    // allow canceling with back button
                    if (isCancelled()) {
                        input.close();
                        return null;
                    }
                    total += count;
                    // publishing the progress....
                    //if (fileLength > 0) // only if total length is known
                        //publishProgress((int) (total * 100 / fileLength));
                    output.write(data, 0, count);
                }
            } catch (Exception e) {
                Log.d("Image", e.toString());
                 e.getStackTrace();
                e.printStackTrace();
                return e.toString();
            } finally {
                try {
                    if (output != null)
                        output.close();
                    if (input != null)
                        input.close();
                } catch (IOException ignored) {
                }

                if (connection != null)
                    connection.disconnect();
            }
            return null;

        }
    }

}
