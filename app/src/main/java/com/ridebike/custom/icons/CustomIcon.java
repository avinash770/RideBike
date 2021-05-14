package com.ridebike.custom.icons;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

public class CustomIcon extends AppCompatTextView {
    public CustomIcon(Context context) {
        super(context);
        setFontFamily(context);
    }

    public CustomIcon(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFontFamily(context);
    }

    public CustomIcon(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFontFamily(context);
    }

    private void setFontFamily(Context context){
        setAllCaps(false);
        Typeface tf = Typeface.createFromAsset(context.getAssets(),
                "icons/custom_icons.ttf");
        setTypeface(tf);
    }
}
