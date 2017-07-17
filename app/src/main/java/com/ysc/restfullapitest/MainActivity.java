package com.ysc.restfullapitest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.ysc.restfullapitest.client.IPAddressClient;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.message.BasicHeader;

public class MainActivity extends AppCompatActivity {

    private ListView noteList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getAddress();
    }

    private void getAddress() {
        List<Header> headers = new ArrayList<Header>();
        headers.add(new BasicHeader("Accept", "application/json"));

        IPAddressClient.get(MainActivity.this, "api/ipaddress", headers.toArray(new Header[headers.size()]),
                null, new JsonHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                        ArrayList<Address> addressArray = new ArrayList<Address>();
                        IPAddressAdapter addressAdapter = new IPAddressAdapter(MainActivity.this, addressArray);

                        for (int i = 0; i < response.length(); i++) {
                            try {
                                addressAdapter.add(new Address(response.getJSONObject(i)));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                        noteList = (ListView) findViewById(R.id.list_address);
                        noteList.setAdapter(addressAdapter);
                    }
                });
    }
}