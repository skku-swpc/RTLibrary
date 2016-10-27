package com.example.rtlibrary;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Jiseong on 2016-03-10.
 */
interface HPInfoReceiver {
    public void onReceive(Context context, Intent intent);
}


public class RTActivity extends Activity{
    String fingerInfo = "";
    public final int HOVER_DOWN=1, HOVER_MOVE=2, HOVER_UP=3, TOUCH_DOWN=4, TOUCH_MOVE=5, TOUCH_UP=6, PRESS_DOWN=7, PRESS_MOVE=8, PRESS_UP=9 ;
    HPInfoReceiver receiver = new HPInfoReceiver();

    ViewGroup viewGroup ;

    public ArrayList<View> RTVList=new ArrayList<View>();
    public class HPInfoReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            String name = intent.getAction();
            if (name.equals("kaisthcil.FingertipInformationBroadcast")) {
                //Log.d("RHTP","HPreceived");
                byte state = intent.getExtras().getByte("Event Code");
                long bId = intent.getExtras().getLong("Blob ID");
                int x = intent.getExtras().getInt("X");
                int y = intent.getExtras().getInt("Y");
                int z = intent.getExtras().getInt("Z");
                for (View child : RTVList) {
                    int[] childPosition = new int[2];
                    child.getLocationOnScreen(childPosition);
                    int childleft = childPosition[0];
                    int childright = childPosition[0] + child.getWidth();
                    int childtop = childPosition[1];
                    int childbottom = childPosition[1] + child.getHeight();
//                    if (x >= child.getLeft() && x <= child.getRight() && y >= child.getTop() && y <= child.getBottom()) {
                    if (x >= childleft && x <= childright && y >= childtop && y <= childbottom) {
                        if (child instanceof RTView){
                            RTView temp = (RTView) child;
                            switch (state) {
                                case HOVER_DOWN:
                                    //Log.d("RHTP","HPEventCreated_HD");
                                    temp.onHPEvent(new HPEvent(HOVER_DOWN));
                                    break;
                                case HOVER_MOVE:
                                    //Log.d("RHTP","HPEventCreated_HM");
                                    temp.onHPEvent(new HPEvent(HOVER_MOVE));
                                    break;
                                case HOVER_UP:
                                    temp.onHPEvent(new HPEvent(HOVER_UP));
                                    break;
                                case TOUCH_DOWN:
                                    //temp.onHPEvent(new HPEvent(HOVER_DOWN));
                                    break;
                                case TOUCH_MOVE:
                                    //temp.onHPEvent(new HPEvent(HOVER_DOWN));
                                    break;
                                case TOUCH_UP:
                                    //temp.onHPEvent(new HPEvent(HOVER_DOWN));
                                    break;
                                case PRESS_DOWN:
                                    temp.onHPEvent(new HPEvent(PRESS_DOWN));
                                    break;
                                case PRESS_MOVE:
                                    temp.onHPEvent(new HPEvent(PRESS_MOVE));
                                    break;
                                case PRESS_UP:
                                    temp.onHPEvent(new HPEvent(PRESS_UP));
                                    break;
                            }

                        }

                    }
                }
            }
        }
    }
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        IntentFilter filter = new IntentFilter();
        filter.addAction("kaisthcil.FingertipInformationBroadcast");
        registerReceiver(receiver, filter, null, null);


    }
    @Override
    protected void onPause() {
        super.onPause();
        //IntentFilter filter = new IntentFilter();
        //filter.addAction("kaisthcil.FingertipInformationBroadcast");
        unregisterReceiver(receiver);

    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter filter = new IntentFilter();
        filter.addAction("kaisthcil.FingertipInformationBroadcast");
        registerReceiver(receiver, filter, null, null);

    }
    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        viewGroup=(ViewGroup)((ViewGroup)super.findViewById(android.R.id.content)).getChildAt(0);
        makeRTVList(viewGroup);
    }

    public void makeRTVList(ViewGroup vg){
        for(int index = 0; index<vg.getChildCount(); index++) {
            View nextChild = vg.getChildAt(index);
            if(nextChild instanceof ViewGroup){
                makeRTVList((ViewGroup)nextChild);
            }
            if(nextChild instanceof RTView){
                RTVList.add(nextChild);
            }
            if(nextChild instanceof RTViewGroup){
                RTVList.add(nextChild);
            }
            if(nextChild instanceof RTFrameLayout){
                RTVList.add(nextChild);
            }
            if(nextChild instanceof RTGridLayout){
                RTVList.add(nextChild);
            }
            if(nextChild instanceof RTLinearLayout){
                RTVList.add(nextChild);
                makeRTVList((ViewGroup)nextChild);
            }
            if(nextChild instanceof RTRelativeLayout){
                RTVList.add(nextChild);
            }
            if(nextChild instanceof RTButton){
                RTVList.add(nextChild);
            }
            if(nextChild instanceof RTEditText){
                RTVList.add(nextChild);
            }
            if(nextChild instanceof RTTextView){
                RTVList.add(nextChild);
            }
            if(nextChild instanceof RTScrollView){
                RTVList.add(nextChild);
            }
            if(nextChild instanceof RTCheckBox){
                RTVList.add(nextChild);
            }
            if(nextChild instanceof RTRadioButton){
                RTVList.add(nextChild);
            }
            if(nextChild instanceof RTSeekBar){
                RTVList.add(nextChild);
            }
        }
    }


}
