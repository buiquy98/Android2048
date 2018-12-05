package com.example.buiqu.game2048_2;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;


public class Tiles extends android.support.v7.widget.AppCompatTextView {
    public Tiles(Context context) {
        super(context);
    }

    public Tiles(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Tiles(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int i = getMeasuredWidth();
        setMeasuredDimension(i, i);
    }
    public void setSizeSo(int n)
    {
        if(n<100)
        {
            setTextSize(40);
        }
        else if(n<1000)
        {
            setTextSize(35);
        }
        else
        {
            setTextSize(30);
        }
        if(n>=8)
        {
            setTextColor(Color.WHITE);
        }
        else //if(num<8)
        {
            setTextColor(Color.BLACK);
        }
        GradientDrawable drawable=(GradientDrawable)this.getBackground();
        drawable.setColor(Data_Game.getDataGame().setColor(n));
        setBackground(drawable);
        if(n==0)
        {
            setText("");
        }
        else
        {
            setText(""+n);
        }
    }
}
