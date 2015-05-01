package com.example.mygift.giftit;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

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
    }
}
