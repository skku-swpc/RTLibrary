package com.example.rtlibrary;

import android.view.View;

public interface OnRTHPListener {
    void onHoverDown(View view);
    void onHoverMove(View view);
    void onHoverUp(View view);
    void onPressDown(View view);
    void onPressMove(View view);
    void onPressUp(View view);
}
