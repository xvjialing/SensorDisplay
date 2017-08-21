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
import com.lytech.xvjialing.sensordisplay.utils.TextUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Login2Activity extends AppCompatActivity {

    @BindView(R.id.iv_login2_cancle)
    ImageView ivLogin2Cancle;
    @BindView(R.id.et_account)
    EditText etAccount;
    @BindView(R.id.et_pwd)
    EditText etPwd;
    @BindView(R.id.tv_logByMessage)
    TextView tvLogByMessage;
    @BindView(R.id.tv_forgetPwd)
    TextView tvForgetPwd;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.btn_register)
    Button btnRegister;
    @BindView(R.id.iv_loginbg3)
    ImageView ivLoginbg3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login2);
        ButterKnife.bind(this);


        initView();
    }

    private void initView() {
        TextUtils.drawUnderLine(tvForgetPwd);
        TextUtils.drawUnderLine(tvLogByMessage);

        Glide.with(this).load(R.drawable.sign_bg21).into(ivLoginbg3);
    }

    @OnClick({R.id.iv_login2_cancle, R.id.tv_logByMessage, R.id.tv_forgetPwd, R.id.btn_login, R.id.btn_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_login2_cancle:
                finish();
                break;
            case R.id.tv_logByMessage:
                startActivity(new Intent(this,LoginMsgActivity.class));
                break;
            case R.id.tv_forgetPwd:
                break;
            case R.id.btn_login:
                break;
            case R.id.btn_register:
                startActivity(new Intent(this,RegisterActivity.class));
                break;
        }
    }
}
