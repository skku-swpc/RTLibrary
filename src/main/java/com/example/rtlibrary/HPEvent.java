package com.example.rtlibrary;

/**
 * Created by Sohn on 2016-04-28.
 */
public class HPEvent {
    private int state;
    public final static int HOVER_DOWN=1, HOVER_MOVE=2, HOVER_UP=3, TOUCH_DOWN=4, TOUCH_MOVE=5, TOUCH_UP=6, PRESS_DOWN=7, PRESS_MOVE=8, PRESS_UP=9 ;
    HPEvent(int state){
        this.state=state;
        }
    public int getState(){
        return state;
    }
}