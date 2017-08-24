package com.lytech.xvjialing.sensordisplay.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lytech.xvjialing.sensordisplay.R;
import com.lytech.xvjialing.sensordisplay.app.Constant;
import com.lytech.xvjialing.sensordisplay.utils.RxBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class DataVisibleFragment extends Fragment {


    @BindView(R.id.iv_parkCar)
    ImageView ivParkCar;
    @BindView(R.id.modernFactory)
    ImageView modernFactory;
    @BindView(R.id.iv_bridgeMonitor)
    ImageView ivBridgeMonitor;
    @BindView(R.id.iv_wisdomAgriculture)
    ImageView ivWisdomAgriculture;
    Unbinder unbinder;

    public DataVisibleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_data_visible, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.iv_parkCar, R.id.modernFactory, R.id.iv_bridgeMonitor, R.id.iv_wisdomAgriculture})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_parkCar:
                click(Constant.FRAGMENT_PARK);
                break;
            case R.id.modernFactory:
                click(Constant.FRAGMENT_MODERNFACTORY);
                break;
            case R.id.iv_bridgeMonitor:
                click(Constant.FRAGMENT_BRIDGEMONITOR);
                break;
            case R.id.iv_wisdomAgriculture:
                click(Constant.FRAGMENT_WISDOMAGRICULTURE);
                break;
        }
    }

    private void click(int tag){
        RxBus.getDefault().post(tag);
    }
}
