package com.mdf.deklarasi.utilities;

import java.util.ArrayList;
import java.util.List;

public class SimpleFilterRecyclerAdapter<T> extends SimpleRecyclerAdapter<T>{

    protected List<T> savedMainData;

    private OnSearchListener<T> onSearchListener;

    public SimpleFilterRecyclerAdapter(List<T> mainData, int layoutRes, OnViewHolder<T> listener, OnSearchListener<T> onSearchListener) {
        super(mainData, layoutRes, listener);
        savedMainData = mainData;
        this.onSearchListener = onSearchListener;
    }

    public SimpleFilterRecyclerAdapter(int layoutRes, OnViewHolder<T> listener, OnSearchListener<T> onSearchListener) {
        super(layoutRes, listener);
        this.onSearchListener = onSearchListener;
    }

    public void filter(String text) {
        if (text != null && !text.isEmpty()) {
            ArrayList<T> filterResult = new ArrayList<>();

            String txt = text.toLowerCase();
            for (T t : savedMainData) {
                if (onSearchListener != null) {
                    T t1 = onSearchListener.onSearchRules(t, txt);
                    if (t1 != null) {
                        filterResult.add(t1);
                    }
                }
            }

            if (filterResult.isEmpty()) {
                if (onSearchListener != null) {
                    onSearchListener.onSearchEmpty(text);
                }
            } else {
                if (onSearchListener != null) {
                    onSearchListener.onSearch(filterResult);
                }
            }
            mainData = filterResult;
        } else {
            mainData = savedMainData;
        }
        notifyDataSetChanged();
    }

    @Override
    public void setMainData(List<T> mainData) {
        this.savedMainData = mainData;
        notifyDataSetChanged();
        super.setMainData(mainData);
    }

    public void addItemToSavedMainData(final T t) {
        savedMainData.add(t);
        super.addItem(t);
    }

    @Override
    public void addAllItem(List<T> t) {
        super.addAllItem(t);

        for (T item : mainData) {
            if (savedMainData.contains(item)) continue;
            savedMainData.add(item);
        }
    }

    public void addAllItemWithLimit (List<T> t, int limit) {
        mainData.clear();

        for (int i = 0; i < t.size(); i++) {
            if (i > limit) break;

            T item = t.get(i);
            if (mainData.contains(item)) continue;
            mainData.add(item);
        }
    }

    @Override
    public void addItem(T t) {
        super.addItem(t);
        if (savedMainData.contains(t)) return;
        savedMainData.add(t);
    }

    @Override
    public void addItemAt(T t, int i) {
        super.addItemAt(t, i);

        if (savedMainData.contains(t)) return;
        savedMainData.add(i, t);
    }

    @Override
    public void setItemAt (T t, int i) {
        super.setItemAt(t, i);

        if (savedMainData.contains(t)) return;
        savedMainData.set(i, t);
    }

    @Override
    public void removeItem(T t) {
        super.removeItem(t);
        if (savedMainData.contains(t)) savedMainData.remove(t);
    }

    @Override
    public void removeAt(int position) {
        super.removeAt(position);
        T item = mainData.get(position);
        if (savedMainData.contains(item)) savedMainData.remove(item);
    }

    @Override
    public void removeAll() {
        super.removeAll();

        for (T item : mainData) {
            if (savedMainData.contains(item)) savedMainData.remove(item);
        }
    }

    public void addItemAtAdapter(T item, int position){
        this.mainData.add(position, item);
        if (!this.savedMainData.contains(item)){
            this.savedMainData.add(position, item);
        }
    }

    public void removeItemAtAdapter(T item){
        this.mainData.remove(item);
        if (this.savedMainData.contains(item)){
            this.savedMainData.remove(item);
        }
    }

    public List<T> getSavedMainData() {
        return savedMainData;
    }

    public void setSavedMainData(List<T> savedMainData) {
        this.savedMainData = savedMainData;
    }

    public OnSearchListener<T> getOnSearchListener() {
        return onSearchListener;
    }

    public void setOnSearchListener(OnSearchListener<T> onSearchListener) {
        this.onSearchListener = onSearchListener;
    }

    public boolean onSearchFilterKListenerIsEmpty() {
        return onSearchListener == null;
    }

    public interface OnSearchListener<T> {
        T onSearchRules(T model, String searchedText);
        void onSearch(ArrayList<T> model);
        void onSearchEmpty(String searchedText);
    }

}
