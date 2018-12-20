package com.example.xdiaz.comunicacionsandroid;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;


public class Main extends AppCompatActivity {

    private ReceptorXarxa receptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActualitzaEstatXarxa();

        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        receptor = new ReceptorXarxa();
        this.registerReceiver(receptor, filter);
    }

    public void onDestroy() {
        super.onDestroy();
        //Donem de baixa el receptor de broadcast quan es destrueix l'aplicació
        if (receptor != null) {
            this.unregisterReceiver(receptor);
        }
    }


   public void ActualitzaEstatXarxa() {

        //Obtenim un gestor de les connexions de xarxa
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        //Obtenim l'estat de la xarxa
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        //Si està connectat
        if (networkInfo != null && networkInfo.isConnected()) {
            //Xarxa OK
            Toast.makeText(this,"Xarxa ok", Toast.LENGTH_LONG).show();
        } else {
            //Xarxa no disponible
            Toast.makeText(this,"Xarxa no disponible", Toast.LENGTH_LONG).show();
        }

        //Obtenim l'estat delaxarxaWi-Fi
        networkInfo = connMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        boolean connectatWifi = networkInfo.isConnected();

    }


}
