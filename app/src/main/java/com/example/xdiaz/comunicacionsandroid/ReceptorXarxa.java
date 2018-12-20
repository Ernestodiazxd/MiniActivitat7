package com.example.xdiaz.comunicacionsandroid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;


public class ReceptorXarxa extends BroadcastReceiver {
    private Main main;
    @Override
    public void onReceive(Context arg0, Intent arg1) {
        //Actualitzar l'estat de la xarxa
        main.ActualitzaEstatXarxa();
    }



}







