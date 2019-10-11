package com.everteam.slider;

import android.content.Context;

public interface AdapterItemListener {
    public   void onItemClick();
    Context getActivity();

    void onScrollEndReached();
}
