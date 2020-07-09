package com.example.ucam;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    private WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView=(WebView)findViewById(R.id.web_view);
        WebSettings webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://ucam.uiu.ac.bd");



    }


    @Override
    public void onBackPressed() {
        if(webView.canGoBack())
        {
            webView.goBack();
        }
        else{
            AlertDialog.Builder aleartdialog;
            aleartdialog =new AlertDialog.Builder(MainActivity.this);
            aleartdialog.setIcon(R.drawable.what);
            aleartdialog.setTitle(R.string.alertdialog_title);
            aleartdialog.setMessage(R.string.alertdialog);
            aleartdialog.setCancelable(false);
            aleartdialog.setPositiveButton("Pretty sure!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });

            aleartdialog.setNegativeButton("Nope!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            AlertDialog alertDialog=aleartdialog.create();
            alertDialog.show();


        }
    }

    //Working on 3 dot menubaar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // int id=item.getItemId();
        // Toast.makeText(MainActivity.this,item.getItemId(),Toast.LENGTH_LONG).show();

        switch(item.getItemId())
        {
            case R.id.about:
            {
                startActivity(new Intent(MainActivity.this,about.class));
                //Toast.makeText(MainActivity.this,"about clicked",Toast.LENGTH_LONG).show();
                break;
            }
            case R.id.exi_t:
            {

                System.exit(0);
                //Toast.makeText(MainActivity.this,"exit clicked",Toast.LENGTH_LONG).show();
                break;

            }
            case R.id.refresh:
            {
                webView.reload();

                break;

            }
        }
        return true;
    }
}
