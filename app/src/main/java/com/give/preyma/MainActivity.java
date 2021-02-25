package com.give.preyma;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.sanojpunchihewa.updatemanager.UpdateManager;
import com.sanojpunchihewa.updatemanager.UpdateManagerConstant;

public class MainActivity extends AppCompatActivity {

    UpdateManager mUpdateManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUpdateManager = UpdateManager.Builder(this).mode(UpdateManagerConstant.IMMEDIATE);
        mUpdateManager.start();

        mUpdateManager.addUpdateInfoListener(new UpdateManager.UpdateInfoListener() {
            @Override
            public void onReceiveVersionCode(final int code) {
                // You can get the available version code of the apk in Google Play
                // Do something here
                Log.d("TAG","VERCODE: "+code);

            }

            @Override
            public void onReceiveStalenessDays(final int days) {
                // Number of days passed since the user was notified of an update through the Google Play
                // If the user hasn't notified this will return -1 as days
                // You can decide the type of update you want to call
            }
        });
    }
}