package com.lytech.xvjialing.sensordisplay.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lytech.xvjialing.sensordisplay.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MsgListFragment extends Fragment {


    public MsgListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_msg_list, container, false);
    }

}
