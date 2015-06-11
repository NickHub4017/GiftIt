package com.example.mygift.giftit;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
    SearchItem array_data[]=new SearchItem[10];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      setContentView(R.layout.preferred_page);
        TableRow thr=(TableRow)findViewById(R.id.hdrRow);
        thr.setBackgroundColor(Color.BLACK);
        //table_cont();
        data=getIntent().getStringExtra("Json_data");
        //SearchItem ls[]=new SearchItem[10];
        deriveItemData(data);
        table_cont();
    }

    public void table_cont() {
        TableLayout table = (TableLayout) findViewById(R.id.tbl_hdr);

        for (int i = 0; i < 10; i++) {

            TableRow row = new TableRow(this);
            row.setId(i);
            if((i%2)==0){
                row.setBackgroundColor(Color.GRAY);
            }

            row.setLayoutParams(new TableRow.LayoutParams(
                    TableRow.LayoutParams.FILL_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT));

            TextView text = new TextView(this);
            text.setMaxWidth(row.getWidth()/4);
            text.setText(array_data[i].getTitle());
            text.setGravity(Gravity.CENTER);

            row.addView(text);

            TextView text1 = new TextView(this);
            text1.setText(array_data[i].getLocation());
            text1.setGravity(Gravity.CENTER);
            row.addView(text1);


            TextView text2 = new TextView(this);
            text2.setText(String.valueOf(array_data[i].getPrice()));
            text2.setGravity(Gravity.CENTER);
            row.addView(text2);

            TextView text3 = new TextView(this);
            text3.setText(array_data[i].getCondition());
            text3.setGravity(Gravity.CENTER);
            row.addView(text3);
            row.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent fulview=new Intent(preferred_activity.this,DetailView.class);
                    fulview.putExtra("SelObj",array_data[view.getId()]);
                    startActivity(fulview);
                }
            });

            table.addView(row);
        }
    }

    public void deriveItemData(String json_str){
        //json_str="{\"findItemsByKeywordsResponse\":[{\"ack\":[\"Success\"],\"version\":[\"1.13.0\"],\"timestamp\":[\"2015-04-30T18:52:41.755Z\"],\"searchResult\":[{\"@count\":\"3\",\"item\":[{\"itemId\":[\"181288591828\"],\"title\":[\"10PCS Texas Instruments - CD4017 - CD4017BE - Decade Counter IC\"],\"globalId\":[\"EBAY-US\"],\"primaryCategory\":[{\"categoryId\":[\"4663\"],\"categoryName\":[\"ICs & Processors\"]}],\"galleryURL\":[\"http:\\/\\/thumbs1.ebaystatic.com\\/m\\/mOR0AuMSi9LLnSjryx8wE3Q\\/140.jpg\"],\"viewItemURL\":[\"http:\\/\\/www.ebay.com\\/itm\\/10PCS-Texas-Instruments-CD4017-CD4017BE-Decade-Counter-IC-\\/181288591828?pt=LH_DefaultDomain_0\"],\"paymentMethod\":[\"PayPal\"],\"autoPay\":[\"false\"],\"location\":[\"China\"],\"country\":[\"CN\"],\"shippingInfo\":[{\"shippingServiceCost\":[{\"@currencyId\":\"USD\",\"__value__\":\"1.98\"}],\"shippingType\":[\"Flat\"],\"shipToLocations\":[\"Worldwide\"],\"expeditedShipping\":[\"false\"],\"oneDayShippingAvailable\":[\"false\"],\"handlingTime\":[\"1\"]}],\"sellingStatus\":[{\"currentPrice\":[{\"@currencyId\":\"USD\",\"__value__\":\"1.47\"}],\"convertedCurrentPrice\":[{\"@currencyId\":\"USD\",\"__value__\":\"1.47\"}],\"sellingState\":[\"Active\"],\"timeLeft\":[\"P19DT11H42M10S\"]}],\"listingInfo\":[{\"bestOfferEnabled\":[\"false\"],\"buyItNowAvailable\":[\"false\"],\"startTime\":[\"2013-12-26T06:29:51.000Z\"],\"endTime\":[\"2015-05-20T06:34:51.000Z\"],\"listingType\":[\"StoreInventory\"],\"gift\":[\"false\"]}],\"returnsAccepted\":[\"true\"],\"condition\":[{\"conditionId\":[\"1000\"],\"conditionDisplayName\":[\"New\"]}],\"isMultiVariationListing\":[\"false\"],\"topRatedListing\":[\"true\"]},{\"itemId\":[\"131494920686\"],\"title\":[\"NE555+CD4017 White 10+1pcs LED Light Water DIY Kit Precise Electronic Suite\"],\"globalId\":[\"EBAY-US\"],\"primaryCategory\":[{\"categoryId\":[\"175745\"],\"categoryName\":[\"Other\"]}],\"galleryURL\":[\"http:\\/\\/thumbs3.ebaystatic.com\\/m\\/miEYv9BCGOGqiB9wX-I9vZg\\/140.jpg\"],\"viewItemURL\":[\"http:\\/\\/www.ebay.com\\/itm\\/NE555-CD4017-White-10-1pcs-LED-Light-Water-DIY-Kit-Precise-Electronic-Suite-\\/131494920686?pt=LH_DefaultDomain_0\"],\"paymentMethod\":[\"PayPal\"],\"autoPay\":[\"false\"],\"location\":[\"China\"],\"country\":[\"CN\"],\"shippingInfo\":[{\"shippingServiceCost\":[{\"@currencyId\":\"USD\",\"__value__\":\"1.98\"}],\"shippingType\":[\"Flat\"],\"shipToLocations\":[\"Worldwide\"],\"expeditedShipping\":[\"false\"],\"oneDayShippingAvailable\":[\"false\"],\"handlingTime\":[\"1\"]}],\"sellingStatus\":[{\"currentPrice\":[{\"@currencyId\":\"USD\",\"__value__\":\"1.25\"}],\"convertedCurrentPrice\":[{\"@currencyId\":\"USD\",\"__value__\":\"1.25\"}],\"bidCount\":[\"9\"],\"sellingState\":[\"Active\"],\"timeLeft\":[\"P0DT8H50M1S\"]}],\"listingInfo\":[{\"bestOfferEnabled\":[\"false\"],\"buyItNowAvailable\":[\"false\"],\"startTime\":[\"2015-04-24T03:42:42.000Z\"],\"endTime\":[\"2015-05-01T03:42:42.000Z\"],\"listingType\":[\"Auction\"],\"gift\":[\"false\"]}],\"returnsAccepted\":[\"true\"],\"condition\":[{\"conditionId\":[\"1000\"],\"conditionDisplayName\":[\"New\"]}],\"isMultiVariationListing\":[\"false\"],\"topRatedListing\":[\"true\"]},{\"itemId\":[\"151622012763\"],\"title\":[\"10x CD4017 CMOS Decade Counter Driver IC 4017 CD4017BE DIP-16 10pcs\"],\"globalId\":[\"EBAY-US\"],\"primaryCategory\":[{\"categoryId\":[\"4663\"],\"categoryName\":[\"ICs & Processors\"]}],\"galleryURL\":[\"http:\\/\\/thumbs4.ebaystatic.com\\/m\\/mBMLsXR06xQU800ADlldhXQ\\/140.jpg\"],\"viewItemURL\":[\"http:\\/\\/www.ebay.com\\/itm\\/10x-CD4017-CMOS-Decade-Counter-Driver-IC-4017-CD4017BE-DIP-16-10pcs-\\/151622012763?pt=LH_DefaultDomain_0\"],\"paymentMethod\":[\"PayPal\"],\"autoPay\":[\"false\"],\"postalCode\":[\"68522\"],\"location\":[\"Lincoln,NE,USA\"],\"country\":[\"US\"],\"shippingInfo\":[{\"shippingServiceCost\":[{\"@currencyId\":\"USD\",\"__value__\":\"0.0\"}],\"shippingType\":[\"FlatDomesticCalculatedInternational\"],\"shipToLocations\":[\"US\",\"CA\",\"GB\",\"AU\",\"AT\",\"BE\",\"FR\",\"DE\",\"IT\",\"JP\",\"ES\",\"TW\",\"NL\",\"CN\",\"HK\",\"MX\"],\"expeditedShipping\":[\"true\"],\"oneDayShippingAvailable\":[\"false\"],\"handlingTime\":[\"1\"]}],\"sellingStatus\":[{\"currentPrice\":[{\"@currencyId\":\"USD\",\"__value__\":\"5.69\"}],\"convertedCurrentPrice\":[{\"@currencyId\":\"USD\",\"__value__\":\"5.69\"}],\"sellingState\":[\"Active\"],\"timeLeft\":[\"P15DT9H14M45S\"]}],\"listingInfo\":[{\"bestOfferEnabled\":[\"false\"],\"buyItNowAvailable\":[\"false\"],\"startTime\":[\"2015-03-17T04:02:26.000Z\"],\"endTime\":[\"2015-05-16T04:07:26.000Z\"],\"listingType\":[\"StoreInventory\"],\"gift\":[\"false\"]}],\"returnsAccepted\":[\"true\"],\"condition\":[{\"conditionId\":[\"1000\"],\"conditionDisplayName\":[\"New\"]}],\"isMultiVariationListing\":[\"false\"],\"topRatedListing\":[\"true\"]}]}],\"paginationOutput\":[{\"pageNumber\":[\"1\"],\"entriesPerPage\":[\"3\"],\"totalPages\":[\"127\"],\"totalEntries\":[\"381\"]}],\"itemSearchURL\":[\"http:\\/\\/www.ebay.com\\/sch\\/i.html?_nkw=cd4017&_ddo=1&_ipg=3&_pgn=1\"]}]}";
        //json_str.replaceAll("\"","");
        json_str=json_str.replace("/**/_cb_findItemsByKeywords(","");
        String finj="";
        for (int f=0;f<json_str.length()-1;f++){
            //if(json_str.charAt(f)!='"'){
                finj=finj+json_str.charAt(f);
            //}

        }


        try {
            JSONObject reader = new JSONObject(finj);
            JSONArray p=reader.getJSONArray("findItemsByKeywordsResponse");
            JSONObject zerothobj = p.getJSONObject(0);
            JSONArray t=zerothobj.getJSONArray("searchResult");
            JSONObject firstobj = t.getJSONObject(0);
            JSONArray item=firstobj.getJSONArray("item");
            for (int px=0;px<10;px++){
                JSONObject l=item.getJSONObject(px);
                String iteId=l.getJSONArray("itemId").getString(0);
                String title=l.getJSONArray("title").getString(0);
                String imgUrl=l.getJSONArray("galleryURL").getString(0);
                String paymethod=l.getJSONArray("paymentMethod").getString(0);
                String location=l.getJSONArray("location").getString(0);
                boolean ret_acc=l.getJSONArray("returnsAccepted").getBoolean(0);
                boolean toplist_acc=l.getJSONArray("topRatedListing").getBoolean(0);
                JSONObject shipinfo=l.getJSONArray("shippingInfo").getJSONObject(0);
                JSONObject sellState=l.getJSONArray("sellingStatus").getJSONObject(0);
                String price_unit_cur=sellState.getJSONArray("currentPrice").getJSONObject(0).getString("@currencyId");
                String price_cur=sellState.getJSONArray("currentPrice").getJSONObject(0).getString("__value__");
                String condition=l.getJSONArray("condition").getJSONObject(0).getJSONArray("conditionDisplayName").get(0).toString();
                //Toast.makeText(getApplicationContext(),"p.getString(0)",Toast.LENGTH_LONG).show();
                //Toast.makeText(getApplicationContext(),iteId+" "+title+" "+imgUrl+" "+paymethod+" "+location+" "+ret_acc+" "+toplist_acc+" "+price_unit_cur+" "+price_cur+" "+condition,Toast.LENGTH_LONG).show();
                SearchItem tmp=new SearchItem(iteId,title,"testglbId","Primcategry",imgUrl,"urlP",paymethod,"autopay",location,"country","shopinfo","sellinfo","listinfo",ret_acc,condition,"Multi","Top",Double.parseDouble(price_cur));
                array_data[px]=tmp;
                //Toast.makeText(getApplicationContext(),array_data[px].getTitle(),Toast.LENGTH_LONG).show();
                //table_cont(array_data);
            }

        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(),"Athda ubata gama kawaa",Toast.LENGTH_LONG).show();
        }
    }




}

