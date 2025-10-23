package com.pmdm.a04controlesbasicos;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    ProgressBar pb ;
    TextView tv ;
    Button b ;

    Button b2;

    NumberPicker np;
    WebView wv ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        pb = findViewById(R.id.progressBar);
        tv = findViewById(R.id.tvProgresBar);
        b = findViewById(R.id.bProgressBar);
        b2 = findViewById(R.id.bParar);
        np = findViewById(R.id.numberPicker);
        wv = findViewById(R.id.webView);

        WebSettings webSettings = wv.getSettings();
        webSettings.setJavaScriptEnabled(true);

        wv.loadUrl("https://google.com");

        wv.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.getUrl().toString());
                return true;
            }
        });

        np.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                Log.d("MainActivity2", "Valor seleccionado :" + newVal);
            }
        });


        np.setMinValue(0);
        np.setMaxValue(9);
        np.setWrapSelectorWheel(true);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                IniciaAnimacion();


            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pb.setProgress(0);
                tv.setText(0+"%");
            }
        });
    }

    private void IniciaAnimacion() {

            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    int value = pb.getProgress();
                    while (value < 100) {
                        value++;
                        pb.setProgress(value);

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                int iValue = pb.getProgress();
                                String sValue = iValue + "%";
                                tv.setText(sValue);
                            }
                        });

                        try {
                            Thread.sleep(50);
                        } catch (Exception ex) {
                            Log.e("MainActivity", "Error: " + ex.getMessage());
                        }
                    }
                }
            });
            t.start();

    }
}