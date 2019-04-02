package com.jim.xun.meetingclient.acitivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jim.xun.meetingclient.MainActivity;
import com.jim.xun.meetingclient.R;
import com.jim.xun.meetingclient.database.MyDao;

public class LoginActivity extends AppCompatActivity {

    private Button login;
    private Button register;
    private EditText loginName;
    private EditText password;
    private MyOnclickListener myOnclickListener;
    private MyDao myDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = findViewById(R.id.btn_login);
        register = findViewById(R.id.btn_register);
        myOnclickListener = new MyOnclickListener();
        login.setOnClickListener(myOnclickListener);
        register.setOnClickListener(myOnclickListener);
        loginName = findViewById(R.id.editText2);
        password = findViewById(R.id.editText3);
    }

    public class MyOnclickListener implements View.OnClickListener {



        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn_login:
                    if (loginName.getText().toString().equals("111")) {
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    } else {
                        Toast.makeText(LoginActivity.this, "用户名不存在或密码错误", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.btn_register:
                    startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
                    break;
                default:
                    break;
            }
        }
    }
}
