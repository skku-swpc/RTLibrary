package com.example.rtlibrary;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RadioButton;

/**
 * Created by Sohn on 2016-06-23.
 */
public class RTRadioButton extends RadioButton{
    public RTRadioButton(Context context) {
        super(context);
    }

    public RTRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RTRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    public CharSequence getAccessibilityClassName() {
        return RTRadioButton.class.getName();
    }
    public void onHPEvent(HPEvent event){
        //Log.d("RTHP", Integer.toString(event.getState()));
        switch (event.getState()) {

            case HPEvent.HOVER_DOWN:
                //Log.d("RHTP","HPEventHandled");
                RTHPListener.onHoverDown((View) this);
                break;
            case HPEvent.HOVER_MOVE:
                //Log.d("RHTP","HPEventHandled");
                RTHPListener.onHoverMove((View) this);
                break;
            case HPEvent.HOVER_UP:
                RTHPListener.onHoverUp((View) this);
                break;
            case HPEvent.PRESS_DOWN:
                RTHPListener.onPressDown((View) this);
                break;
            case HPEvent.PRESS_MOVE:
                RTHPListener.onPressMove((View) this);
                break;
            case HPEvent.PRESS_UP:
                RTHPListener.onPressUp((View) this);
                break;
        }
    }
    public void onHPGestureEvent(HPEvent event){
        switch (event.getState()) {

            case HPEvent.HOVER_DOWN:
                RTGestureListener.onHoverEnter((View) this);
                break;
            case HPEvent.HOVER_MOVE:
                RTGestureListener.onHoverEnter((View) this);
                break;
            case HPEvent.HOVER_UP:
                RTGestureListener.onHoverLeave((View) this);
                break;
        }
    }
    public void setOnRTGestureListener(OnRTGestureListener listener) {
        RTGestureListener = listener;
    }
    public void setOnRTHPListener(OnRTHPListener listener){
        RTHPListener = listener;
    }
    //    protected OnRTButtonActionListener RTButtonActionListener;
    public OnRTHPListener RTHPListener;
    public OnRTGestureListener RTGestureListener;
}
