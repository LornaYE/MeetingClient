package com.jim.xun.meetingclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.jim.xun.meetingclient.acitivity.LoginActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void myclick(View v) {
        switch (v.getId()) {
            case R.id.iv_flame:

                break;
            case R.id.iv_messenger:

                break;
            case R.id.iv_notifications:

                break;
            case R.id.iv_butterfly:

                break;
            case R.id.iv_calendar:

                break;
            case R.id.iv_share:

                break;
            case R.id.iv_switch:

                break;
            case R.id.iv_password:

                break;
            case R.id.textView5:
                System.exit(0);
                break;
            case R.id.textView7:
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                break;


        }
    }


}
