package com.ymr.common.ui.adapter;

import android.content.Context;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ymr on 15/9/22.
 */
public abstract class DataBaseAdapter<D> extends BaseAdapter implements IDataManager<D> {

    private final Context mContext;
    private IDataManager<D> mDataManager;

    public DataBaseAdapter(Context context) {
        mContext = context;
        mDataManager = new DataManager<>(this);
    }

    public DataBaseAdapter(Context context, List<D> datas) {
        mContext = context;
        mDataManager = new DataManager<>(this);
        addDatas(datas);
    }

    @Override
    public void addDatas(List<D> datas) {
        mDataManager.addDatas(datas);
    }

    @Override
    public void setDatas(List<D> datas) {
        mDataManager.setDatas(datas);
    }

    @Override
    public List<D> getDatas() {
        return mDataManager.getDatas();
    }

    @Override
    public int getCount() {
        return mDataManager.getCount();
    }

    @Override
    public D getItem(int position) {
        return mDataManager.getItem(position);
    }

    @Override
    public long getItemId(int position) {
        return mDataManager.getItemId(position);
    }

    @Override
    public Context getContext() {
        return mContext;
    }
}
