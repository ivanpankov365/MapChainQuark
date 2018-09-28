package com.example.franck.mapchain;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.franck.mapchain.models.ContractModel;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.Web3jFactory;
import org.web3j.protocol.http.HttpService;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private WebView webView;
    private NaviParser parser;
    private ServerParser serverParser;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main_activity);

        RecyclerView rv = (RecyclerView)findViewById(R.id.recyclerView);
        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(llm);
        serverParser = new ServerParser();
        try {
            persons = serverParser.parseJson(new AsyncTaskP().execute(ServerParser.URL).get());
        } catch (Exception e) {
            e.printStackTrace();
        }
        RVAdapter adapter = new RVAdapter(persons, getApplicationContext());
        rv.setAdapter(adapter);

        Web3j web3j = Web3jFactory.build(new HttpService());
//        textView = findViewById(R.id.tvInfo);
//        webView = (WebView) findViewById(R.id.wevView);
//        webView.getSettings().setJavaScriptEnabled(true);
//        parser = new NaviParser();
//        webView.loadUrl(NaviParser.URL+parser.getContainer()+"/"+parser.getAddresss());
//
//        try {
//            parser = new ServerParser();
//            textView.setText(((ContractModel)parser.parseJson(new AsyncTaskP().execute(ServerParser.URL).get()).get(0)).getAddress());
//
////            String line = new AsyncTaskP().execute(NaviParser.URL+parser.getContainer()+"/"+parser.getAddresss()).get();
////            textView.setText(parser.parserCoordinates(line).getLatitude().toString());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
       // startActivity(new Intent(this, MapActivity.class));
    }
    class Person {
        String name;
        String age;
        int photoId;

        Person(String name, String age, int photoId) {
            this.name = name;
            this.age = age;
            this.photoId = photoId;
        }
    }

    private List<ContractModel> persons;

    // This method creates an ArrayList that has three Person objects
// Checkout the project associated with this tutorial on Github if
// you want to use the same images.
    private void initializeData(){
        persons = new ArrayList<>();
    }

    public void onClick(View v) throws Exception{

    }

    private class AsyncTaskP extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... voids){  BufferedReader inputStream = null;
            String jsonResult = "";
            URL jsonUrl;
            try {
                jsonUrl = new URL(voids[0]);

            URLConnection dc = jsonUrl.openConnection();

            dc.setConnectTimeout(5000);
            dc.setReadTimeout(5000);

            inputStream = new BufferedReader(new InputStreamReader(
                    dc.getInputStream()));

            String line = "";
            while((line = inputStream.readLine()) != null)
                jsonResult += line;

            } catch (Exception e) {
                e.printStackTrace();
            }
            return jsonResult;
        }
    }
}
