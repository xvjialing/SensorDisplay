package com.lytech.xvjialing.sensordisplay.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lytech.xvjialing.sensordisplay.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.iv_loginbg4)
    ImageView ivLoginbg4;
    @BindView(R.id.iv_login2_cancle)
    ImageView ivLogin2Cancle;
    @BindView(R.id.tv_registerByPhone)
    TextView tvRegisterByPhone;
    @BindView(R.id.tv_registerByEmail)
    TextView tvRegisterByEmail;
    @BindView(R.id.fl_register_content)
    FrameLayout flRegisterContent;

    private boolean isByPhone=true;

    private RegisterPhoneFragment registerPhoneFragment;
    private RegisterEmailFragment registerEmailFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        initView();

        showRegiserPhoneFragment();
    }

    private void initView() {
        Glide.with(this).load(R.drawable.sign_bg21).into(ivLoginbg4);
    }

    @OnClick({R.id.iv_login2_cancle, R.id.tv_registerByPhone, R.id.tv_registerByEmail})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_login2_cancle:
                finish();
                break;
            case R.id.tv_registerByPhone:

                 clickPhone();
                break;
            case R.id.tv_registerByEmail:

                clickEmail();
                break;
        }
    }

    private void clickEmail() {
        if (isByPhone){
            isByPhone=false;

            transform();
        }
    }


    private void clickPhone() {
        if (!isByPhone){
            isByPhone=true;
            transform();
        }
    }

    private void transform() {
        if (isByPhone){
            tvRegisterByPhone.setBackgroundResource(R.drawable.bg_register_switch_left_pressed);
            tvRegisterByEmail.setBackgroundResource(R.drawable.bg_register_switch_right);

            showRegiserPhoneFragment();
        }else {
            tvRegisterByPhone.setBackgroundResource(R.drawable.bg_register_switch_left);
            tvRegisterByEmail.setBackgroundResource(R.drawable.bg_register_switch_right_pressed);

            showRegiserEmailFragment();
        }
    }

    private void showRegiserPhoneFragment(){
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();

        if (registerPhoneFragment==null){
            registerPhoneFragment=new RegisterPhoneFragment();
            transaction.add(R.id.fl_register_content,registerPhoneFragment);
        }

        hideFragment(transaction);

        transaction.show(registerPhoneFragment);

        transaction.commit();
    }

    private void showRegiserEmailFragment(){
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();

        if (registerEmailFragment==null){
            registerEmailFragment=new RegisterEmailFragment();
            transaction.add(R.id.fl_register_content,registerEmailFragment);
        }

        hideFragment(transaction);

        transaction.show(registerEmailFragment);

        transaction.commit();
    }

    private void hideFragment(FragmentTransaction transaction){
        if(registerPhoneFragment != null){
            transaction.hide(registerPhoneFragment);
        }
        if(registerEmailFragment != null){
            transaction.hide(registerEmailFragment);
        }
    }
}
