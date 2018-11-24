package com.example.buiqu.game2048;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

@SuppressLint("AppCompatCustomView")
public class OVuong extends TextView {
    public OVuong(Context context) {
        super(context);
    }

    public OVuong(Context context,  @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public OVuong(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int dai=getMeasuredWidth();
            setMeasuredDimension(dai,dai);
    }
    public void setNumText(int num)
    {
        if(num<100)
        {
            setTextSize(40);
        }
        else if(num<1000)
        {
            setTextSize(35);
        }
        else
        {
            setTextSize(30);
        }
        if(num>=8)
        {
            setTextColor(Color.WHITE);
        }
        else //if(num<8)
        {
            setTextColor(Color.BLACK);
        }
        GradientDrawable drawable=(GradientDrawable)this.getBackground();
        drawable.setColor(Data.getData().numColor(num));
        if(num==0)
        {
            setText("");
        }
        else
        {
            setText(""+num);
        }

    }
}
