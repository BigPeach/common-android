package com.ymr.common.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.ymr.common.Statistical;
import com.ymr.common.ui.BaseActivityUI;
import com.ymr.common.ui.BaseUI;
import com.ymr.common.ui.BaseUIController;
import com.umeng.analytics.MobclickAgent;
import com.ymr.common.ui.IBaseUIController;
import com.ymr.common.util.StatisticalHelper;

/**
 * Created by ymr on 15/6/25.
 */
public abstract class BaseActivity extends Activity implements BaseActivityUI {
    private IBaseUIController mBaseUIController;
    private boolean mIsResume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBaseUIController = getController();
        mBaseUIController.initActivity();
    }

    public void setTitle(String title) {
        mBaseUIController.setTitle(title);
    }

    @Override
    public void onStartCreatView() {

    }

    @Override
    public BaseUIController.BaseUIParams getBaseUIParams() {
        return null;
    }

    @Override
    public int getTitleRightViewId() {
        return 0;
    }

    @Override
    public View.OnClickListener getTitleRightViewOnClickListener() {
        return null;
    }

    @Override
    public IBaseUIController getController() {
        return new BaseUIController(this);
    }

    @Override
    public boolean isActionBarVisible() {
        return true;
    }

    @Override
    public boolean isResume() {
        return mIsResume;
    }

    @Override
    public boolean onActionbarBackPressed() {
        return false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIsResume = true;
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mIsResume = false;
        MobclickAgent.onPause(this);
    }

    @Override
    public void writeToStatistical(String actionType) {
        StatisticalHelper.doStatistical(this, actionType);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mBaseUIController.onDestroy();
    }

    @Override
    public View getRootView() {
        return mBaseUIController.getRootView();
    }

    @Override
    public View getRightView() {
        return mBaseUIController.getRightView();
    }
}
