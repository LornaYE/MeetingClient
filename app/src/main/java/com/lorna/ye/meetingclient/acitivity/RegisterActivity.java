package com.jim.xun.meetingclient.acitivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.jim.xun.meetingclient.R;
import com.jim.xun.meetingclient.database.MyDao;

public class RegisterActivity extends AppCompatActivity {

    private MyDao myDao;
    private String UserName;
    private String Password;
    private String RePassword;
    private String Telephone;
    private String Address;
    private String QQ;
    private String Wechat;
    private String Bir;
    private String Sex;
    private Button Register;
    private Button Cancel;
    private EditText ETUserName;
    private EditText ETPassword;
    private EditText ETRePassword;
    private EditText ETTelephone;
    private EditText ETAddress;
    private EditText ETQQ;
    private EditText ETWechat;
    private EditText ETBir;
    private Spinner ETSex;
    private RgButtonOnClickListener rgButtonOnClickListener;

    @Override

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        myDao = new MyDao(this);
        Register = findViewById(R.id.btn_rg_login);
        Cancel = findViewById(R.id.btn_rg_cancel);
        ETUserName = findViewById(R.id.et_rg_name);
        ETPassword = findViewById(R.id.et_rg_password);
        ETRePassword = findViewById(R.id.et_rg_repassword);
        ETTelephone = findViewById(R.id.et_rg_tel);
        ETAddress = findViewById(R.id.et_rg_address);
        ETQQ = findViewById(R.id.et_rg_qq);
        ETWechat = findViewById(R.id.et_rg_wechat);
        ETBir = findViewById(R.id.et_rg_birthday);
        ETSex = findViewById(R.id.spinner_sex);
        rgButtonOnClickListener = new RgButtonOnClickListener();
        Register.setOnClickListener(rgButtonOnClickListener);
        Cancel.setOnClickListener(rgButtonOnClickListener);
    }

    class RgButtonOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn_rg_login:
                    UserName = ETUserName.getText().toString();
                    Password = ETPassword.getText().toString();
                    RePassword = ETRePassword.getText().toString();
                    Telephone = ETTelephone.getText().toString();
                    Address = ETAddress.getText().toString();
                    QQ = ETQQ.getText().toString();
                    Wechat = ETWechat.getText().toString();
                    Bir = ETBir.getText().toString();
                    Sex = ETSex.getSelectedItem().toString();
                        Toast.makeText(RegisterActivity.this, "两次输入密码不一致", Toast.LENGTH_SHORT).show();


                    break;
                case R.id.btn_rg_cancel:
                    finish();
                    break;
            }
        }
    }
}
