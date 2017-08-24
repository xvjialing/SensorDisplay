package com.lytech.xvjialing.sensordisplay.ui;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lytech.xvjialing.sensordisplay.R;
import com.lytech.xvjialing.sensordisplay.app.Constant;
import com.lytech.xvjialing.sensordisplay.utils.RxBus;
import com.lytech.xvjialing.sensordisplay.utils.ViewUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

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
    private int ivListLeftWidth=0,ivListWidth=0,ivAvaterWidth=0;

    private int chooseTag = 1;
    private boolean visibleTag = true;
    private DataVisibleFragment dataVisibleFragment;
    private MsgListFragment msgListFragment;
    private SettingFragment settingFragment;
    private ParkCarFragment parkCarFragment;
    private ModernFactoryFragment modernFactoryFragment;
    private BridgeMonitorFragment bridgeMonitorFragment;
    private WisdomAgricultureFragment wisdomAgricultureFragment;
    private Subscription subscribe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initRxbus();

        init();


        showDataVisibleFragment();
    }

    private void initRxbus() {
        subscribe = RxBus.getDefault().toObservable(Integer.class)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Integer integer) {
//                        Log.d(TAG, "onNext: "+integer);
                        click(integer);
                    }
                });
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
                click(Constant.FRAGMENT_DATAVISIBLE);
                break;
            case R.id.ll_msgList:
                click(Constant.FRAGMENT_MSGLIST);
                break;
            case R.id.ll_setting:
                click(Constant.FRAGMENT_SETTING);
                break;
        }
    }

    private void itemsVisible(boolean tag) {
        if (ivAvaterWidth==0){
            ivAvaterWidth=ivAvater.getWidth();
        }
        if (ivListLeftWidth==0){
            ivListLeftWidth=ivList.getLeft();
        }
        if (ivListWidth==0){
            ivListWidth=ivList.getWidth();
        }
        if (leftBarWidth==0){
            leftBarWidth=rlLeftBar.getWidth();
        }
        if (itemLlWidth==0){
            itemLlWidth=llDataVisible.getWidth();
        }
        if (tag) {
            ivList.setImageResource(R.drawable.ic_list);
            tvUsername.setVisibility(View.VISIBLE);
            tvDataVisible.setVisibility(View.VISIBLE);
            tvMsg.setVisibility(View.VISIBLE);
            tvSetting.setVisibility(View.VISIBLE);
            ivLogo.setVisibility(View.VISIBLE);
            tvDate.setVisibility(View.VISIBLE);
            tvCompanyName.setVisibility(View.VISIBLE);

            setWidth(tag);

//            ivList.setTranslationX(ivListLeftWidth);
        } else {
            ivList.setImageResource(R.drawable.ic_list_clicked);
            tvUsername.setVisibility(View.GONE);
            tvDataVisible.setVisibility(View.GONE);
            tvMsg.setVisibility(View.GONE);
            tvSetting.setVisibility(View.GONE);
            ivLogo.setVisibility(View.GONE);
            tvDate.setVisibility(View.GONE);
            tvCompanyName.setVisibility(View.GONE);


            setWidth(tag);

//            int width1=((ivAvaterWidth+40)/2)-(ivListWidth/2);
//            ivList.setTranslationX(width1);

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

            ViewUtils.setViewWidth(rlLeftBar,ivAvaterWidth+40);
        }
    }

    private void click(int i) {
        if ((i != chooseTag)) {

            if (i < 4) {
                switch (chooseTag) {
                    case Constant.FRAGMENT_DATAVISIBLE:
                        ivDataVisible.setImageResource(R.drawable.ic_data_visible);
                        tvDataVisible.setTextColor(getResources().getColor(R.color.white));
                        break;
                    case Constant.FRAGMENT_MSGLIST:
                        ivMsg.setImageResource(R.drawable.ic_msg);
                        tvMsg.setTextColor(getResources().getColor(R.color.white));
                        break;
                    case Constant.FRAGMENT_SETTING:
                        ivSetting.setImageResource(R.drawable.ic_setting);
                        tvSetting.setTextColor(getResources().getColor(R.color.white));
                        break;
                    default:
                        ivDataVisible.setImageResource(R.drawable.ic_data_visible);
                        tvDataVisible.setTextColor(getResources().getColor(R.color.white));
                        break;
//                case Constant.FRAGMENT_PARK:
//
//                    break;
//                case Constant.FRAGMENT_MODERNFACTORY:
//
//                    break;
//                case Constant.FRAGMENT_BRIDGEMONITOR:
//
//                    break;
//                case Constant.FRAGMENT_WISDOMAGRICULTURE:
//
//                    break;
                }
            }

            switch (i) {
                case Constant.FRAGMENT_DATAVISIBLE:
                    ivDataVisible.setImageResource(R.drawable.ic_data_visible_clicked);
                    tvDataVisible.setTextColor(getResources().getColor(R.color.tv_item_click));
                    showDataVisibleFragment();
                    break;
                case Constant.FRAGMENT_MSGLIST:
                    ivMsg.setImageResource(R.drawable.ic_msg_clicked);
                    tvMsg.setTextColor(getResources().getColor(R.color.tv_item_click));
                    showMsgListFragment();
                    break;
                case Constant.FRAGMENT_SETTING:
                    ivSetting.setImageResource(R.drawable.ic_setting_clicked);
                    tvSetting.setTextColor(getResources().getColor(R.color.tv_item_click));
                    showSettingFragment();
                    break;
                case Constant.FRAGMENT_PARK:
                    showParkCarFragment();
                    break;
                case Constant.FRAGMENT_MODERNFACTORY:
                    showModernFactoryFragment();
                    break;
                case Constant.FRAGMENT_BRIDGEMONITOR:
                    showBridgeMonitorFragment();
                    break;
                case Constant.FRAGMENT_WISDOMAGRICULTURE:
                    showWisdomAgricultureFragment();
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

    private void showParkCarFragment(){
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();

        if (parkCarFragment==null){
            parkCarFragment=new ParkCarFragment();
            transaction.add(R.id.rl_rightBar,parkCarFragment);
        }

        hideFragments(transaction);

        transaction.show(parkCarFragment);

        transaction.commit();
    }

    private void showModernFactoryFragment(){
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();

        if (modernFactoryFragment==null){
            modernFactoryFragment=new ModernFactoryFragment();

            transaction.add(R.id.rl_rightBar,modernFactoryFragment);
        }

        hideFragments(transaction);

        transaction.show(modernFactoryFragment);

        transaction.commit();
    }

    private void showBridgeMonitorFragment(){
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();

        if (bridgeMonitorFragment==null){
            bridgeMonitorFragment=new BridgeMonitorFragment();

            transaction.add(R.id.rl_rightBar,bridgeMonitorFragment);
        }

        hideFragments(transaction);

        transaction.show(bridgeMonitorFragment);

        transaction.commit();
    }

    private void showWisdomAgricultureFragment(){
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();

        if (wisdomAgricultureFragment==null){
            wisdomAgricultureFragment=new WisdomAgricultureFragment();

            transaction.add(R.id.rl_rightBar,wisdomAgricultureFragment);
        }

        hideFragments(transaction);

        transaction.show(wisdomAgricultureFragment);

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
        if (parkCarFragment!=null){
            transaction.hide(parkCarFragment);
        }
        if (modernFactoryFragment!=null){
            transaction.hide(modernFactoryFragment);
        }
        if (bridgeMonitorFragment!=null){
            transaction.hide(bridgeMonitorFragment);
        }
        if (wisdomAgricultureFragment!=null){
            transaction.hide(wisdomAgricultureFragment);
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (!subscribe.isUnsubscribed()){
            subscribe.unsubscribe();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK){
            if (chooseTag>3){
                click(Constant.FRAGMENT_DATAVISIBLE);
                return false;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
