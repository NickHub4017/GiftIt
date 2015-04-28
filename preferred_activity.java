package com.example.mygift.giftit;

import android.app.Activity;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Prasanga on 4/23/2015.
 */
public class preferred_activity extends Activity {
    String data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      setContentView(R.layout.preferred_page);
        table_cont();
        data=getIntent().getStringExtra("Json_data");
    }

    public void table_cont() {
        TableLayout table = (TableLayout) findViewById(R.id.tbl_hdr);

        for (int i = 0; i < 10; i++) {

            TableRow row = new TableRow(this);
            row.setLayoutParams(new TableRow.LayoutParams(
                    TableRow.LayoutParams.FILL_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT));
            TextView text = new TextView(this);
            text.setText("X " + i);
            row.addView(text);

            TextView text1 = new TextView(this);
            text1.setText("Y " + i);
            row.addView(text1);

            TextView text2 = new TextView(this);
            text2.setText("Z " + i);
            row.addView(text2);

            TextView text3 = new TextView(this);
            text3.setText("Q " + i);
            row.addView(text3);


            table.addView(row);
        }
    }


}

