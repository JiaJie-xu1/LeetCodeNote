package com.univers.leetcodenote;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class CustomView extends View {
    private Paint whitePaint;
    private Paint blackPaint;
    private float degree = 0;

    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        whitePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        whitePaint.setColor(Color.WHITE);

        blackPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        blackPaint.setColor(Color.BLACK);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();

        canvas.translate(width / 2, height / 2);
        canvas.drawColor(Color.TRANSPARENT);

        canvas.rotate(degree);
        //绘制两个半圆
        int radius = Math.min(width, height) / 2;//半径
        RectF rectF = new RectF(-radius, -radius, radius, radius);
        canvas.drawArc(rectF, 90,180,true,blackPaint);
        canvas.drawArc(rectF, -90,180,true,whitePaint);

        int smallRadius = radius / 2;

        canvas.drawCircle(0,-smallRadius,smallRadius,blackPaint);
        canvas.drawCircle(0,smallRadius,smallRadius,whitePaint);

        canvas.drawCircle(0,-smallRadius,smallRadius/4,whitePaint);
        canvas.drawCircle(0,smallRadius,smallRadius/4,blackPaint);
    }

    public void setDegrees(float degree){
        this.degree = degree;
        invalidate();
    }
}
