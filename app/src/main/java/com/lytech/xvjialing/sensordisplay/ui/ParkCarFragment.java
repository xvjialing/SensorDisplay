package com.lytech.xvjialing.sensordisplay.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baidu.mapapi.map.MapView;
import com.lytech.xvjialing.sensordisplay.R;
import com.lytech.xvjialing.sensordisplay.utils.MapUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ParkCarFragment extends Fragment {


    @BindView(R.id.mv_parkCar)
    MapView mvParkCar;
    Unbinder unbinder;
    private MapUtil maputils;

    public ParkCarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_park_car, container, false);
        unbinder = ButterKnife.bind(this, view);

        initMap();

        return view;
    }

    private void initMap() {
        maputils = MapUtil.getInstance();
        maputils.init(mvParkCar);
    }

    @Override
    public void onResume() {
        super.onResume();
        maputils.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        maputils.onPause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        maputils.clear();
        unbinder.unbind();
    }
}
