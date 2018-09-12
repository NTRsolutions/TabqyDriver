package com.tabqydriver.customtext;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;


/**
 * Created by lenovo on 4/13/2018.
 */

public class CustomTextViewSemiBold extends android.support.v7.widget.AppCompatTextView {

    public CustomTextViewSemiBold(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public CustomTextViewSemiBold(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomTextViewSemiBold(Context context) {
        super(context);
        init();
    }

    private void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/Montserrat-SemiBold.ttf");
        setTypeface(tf ,1);

    }

}

