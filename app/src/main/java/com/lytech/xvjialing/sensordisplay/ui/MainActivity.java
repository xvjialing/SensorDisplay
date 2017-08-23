package com.lytech.xvjialing.sensordisplay.ui;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lytech.xvjialing.sensordisplay.R;
import com.lytech.xvjialing.sensordisplay.utils.ViewUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.iv_list)
    ImageView ivList;
    @BindView(R.id.iv_avater)
    ImageView ivAvater;
    @BindView(R.id.tv_username)
    TextView tvUsername;
    @BindView(R.id.iv_dataVisible)
    ImageView ivDataVisible;
    @BindView(R.id.tv_dataVisible)
    TextView tvDataVisible;
    @BindView(R.id.ll_dataVisible)
    LinearLayout llDataVisible;
    @BindView(R.id.iv_msg)
    ImageView ivMsg;
    @BindView(R.id.tv_msg)
    TextView tvMsg;
    @BindView(R.id.ll_msgList)
    LinearLayout llMsgList;
    @BindView(R.id.iv_setting)
    ImageView ivSetting;
    @BindView(R.id.tv_setting)
    TextView tvSetting;
    @BindView(R.id.ll_setting)
    LinearLayout llSetting;
    @BindView(R.id.rl_leftBar)
    ConstraintLayout rlLeftBar;
    @BindView(R.id.rl_rightBar)
    RelativeLayout rlRightBar;
    @BindView(R.id.tv_companyName)
    TextView tvCompanyName;
    @BindView(R.id.tv_date)
    TextView tvDate;
    @BindView(R.id.iv_logo)
    ImageView ivLogo;
    private int width, height,itemWidth=0,leftBarWidth=0,itemLlWidth=0;

    private int chooseTag = 1;
    private boolean visibleTag = true;
    private DataVisibleFragment dataVisibleFragment;
    private MsgListFragment msgListFragment;
    private SettingFragment settingFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        init();

        showDataVisibleFragment();
    }

    private void init() {
        DisplayMetrics dm = getResources().getDisplayMetrics();
        width = dm.widthPixels;
        height = dm.heightPixels;

    }

    @OnClick({R.id.iv_list, R.id.ll_dataVisible, R.id.ll_msgList, R.id.ll_setting})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_list:
                itemsVisible(!visibleTag);
                visibleTag = !visibleTag;
                break;
            case R.id.ll_dataVisible:
                click(1);
                break;
            case R.id.ll_msgList:
                click(2);
                break;
            case R.id.ll_setting:
                click(3);
                break;
        }
    }

    private void itemsVisible(boolean tag) {
        if (itemWidth==0){
            itemWidth=ivAvater.getWidth();
        }

        if (leftBarWidth==0){
            leftBarWidth=rlLeftBar.getWidth();
        }
        if (itemLlWidth==0){
            itemLlWidth=llDataVisible.getWidth();
        }
        if (tag) {
            ivList.setImageResource(R.drawable.ic_list_clicked);
            tvUsername.setVisibility(View.VISIBLE);
            tvDataVisible.setVisibility(View.VISIBLE);
            tvMsg.setVisibility(View.VISIBLE);
            tvSetting.setVisibility(View.VISIBLE);
            ivLogo.setVisibility(View.VISIBLE);
            tvDate.setVisibility(View.VISIBLE);
            tvCompanyName.setVisibility(View.VISIBLE);

            setWidth(tag);
        } else {
            ivList.setImageResource(R.drawable.ic_list);
            tvUsername.setVisibility(View.GONE);
            tvDataVisible.setVisibility(View.GONE);
            tvMsg.setVisibility(View.GONE);
            tvSetting.setVisibility(View.GONE);
            ivLogo.setVisibility(View.GONE);
            tvDate.setVisibility(View.GONE);
            tvCompanyName.setVisibility(View.GONE);

            setWidth(tag);
        }
    }

    private void setWidth(boolean tag){
        if (tag){
//            ViewUtils.setViewWidth(llDataVisible,itemLlWidth);
//            ViewUtils.setViewWidth(llMsgList,itemLlWidth);
//            ViewUtils.setViewWidth(llSetting,itemLlWidth);

            ViewUtils.setViewWidth(rlLeftBar,leftBarWidth);
        }else {
//            ViewUtils.setViewWidth(llDataVisible,itemWidth+50);
//            ViewUtils.setViewWidth(llMsgList,itemWidth+50);
//            ViewUtils.setViewWidth(llSetting,itemWidth+50);

            ViewUtils.setViewWidth(rlLeftBar,itemWidth+40);
        }
    }

    private void click(int i) {
        if (i != chooseTag) {
            switch (i) {
                case 1:
                    ivDataVisible.setImageResource(R.drawable.ic_data_visible_clicked);
                    tvDataVisible.setTextColor(getResources().getColor(R.color.tv_item_click));
                    showDataVisibleFragment();
                    break;
                case 2:
                    ivMsg.setImageResource(R.drawable.ic_msg_clicked);
                    tvMsg.setTextColor(getResources().getColor(R.color.tv_item_click));
                    showMsgListFragment();
                    break;
                case 3:
                    ivSetting.setImageResource(R.drawable.ic_setting_clicked);
                    tvSetting.setTextColor(getResources().getColor(R.color.tv_item_click));
                    showSettingFragment();
                    break;
            }

            switch (chooseTag) {
                case 1:
                    ivDataVisible.setImageResource(R.drawable.ic_data_visible);
                    tvDataVisible.setTextColor(getResources().getColor(R.color.white));
                    break;
                case 2:
                    ivMsg.setImageResource(R.drawable.ic_msg);
                    tvMsg.setTextColor(getResources().getColor(R.color.white));
                    break;
                case 3:
                    ivSetting.setImageResource(R.drawable.ic_setting);
                    tvSetting.setTextColor(getResources().getColor(R.color.white));
                    break;
            }


            chooseTag = i;
        }
    }

    private void showDataVisibleFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if (dataVisibleFragment == null) {
            dataVisibleFragment = new DataVisibleFragment();
            transaction.add(R.id.rl_rightBar, dataVisibleFragment);
        }

        hideFragments(transaction);

        transaction.show(dataVisibleFragment);

        transaction.commit();

    }

    private void showMsgListFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if (msgListFragment == null) {
            msgListFragment = new MsgListFragment();
            transaction.add(R.id.rl_rightBar, msgListFragment);
        }

        hideFragments(transaction);

        transaction.show(msgListFragment);

        transaction.commit();
    }

    private void showSettingFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if (settingFragment == null) {
            settingFragment = new SettingFragment();
            transaction.add(R.id.rl_rightBar, settingFragment);
        }

        hideFragments(transaction);

        transaction.show(settingFragment);

        transaction.commit();
    }

    private void hideFragments(FragmentTransaction transaction) {
        if (dataVisibleFragment != null) {
            transaction.hide(dataVisibleFragment);
        }

        if (msgListFragment != null) {
            transaction.hide(msgListFragment);
        }

        if (settingFragment != null) {
            transaction.hide(settingFragment);
        }
    }
}
