package com.lytech.xvjialing.sensordisplay.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.lytech.xvjialing.sensordisplay.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterPhoneFragment extends Fragment {


    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.et_vertirycode)
    EditText etVertirycode;
    @BindView(R.id.btn_getvertiry)
    Button btnGetvertiry;
    @BindView(R.id.et_signal)
    EditText etSignal;
    @BindView(R.id.et_pwd)
    EditText etPwd;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.btn_register)
    Button btnRegister;
    Unbinder unbinder;

    public RegisterPhoneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register_phone, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.btn_getvertiry, R.id.btn_login, R.id.btn_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_getvertiry:
                break;
            case R.id.btn_login:
                break;
            case R.id.btn_register:
                break;
        }
    }
}
