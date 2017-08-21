package com.lytech.xvjialing.sensordisplay.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lytech.xvjialing.sensordisplay.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginMsgActivity extends AppCompatActivity {

    @BindView(R.id.iv_loginbg4)
    ImageView ivLoginbg4;
    @BindView(R.id.iv_login2_cancle)
    ImageView ivLogin2Cancle;
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.et_vertirycode)
    EditText etVertirycode;
    @BindView(R.id.btn_getvertiry)
    Button btnGetvertiry;
    @BindView(R.id.tv_logByPwd)
    TextView tvLogByPwd;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.btn_register)
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_msg);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        Glide.with(this).load(R.drawable.sign_bg21).into(ivLoginbg4);
    }

    @OnClick({R.id.iv_login2_cancle, R.id.btn_getvertiry, R.id.tv_logByPwd, R.id.btn_login, R.id.btn_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_login2_cancle:
                finish();
                break;
            case R.id.btn_getvertiry:
                break;
            case R.id.tv_logByPwd:
                finish();
                break;
            case R.id.btn_login:
                break;
            case R.id.btn_register:
                startActivity(new Intent(this,RegisterActivity.class));
                break;
        }
    }
}
