package com.univers.canvas_view;

import android.animation.TimeInterpolator;
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
    float width;
    float height;
    float radius;//半径
    RectF rectF;

    public CustomView(Context context) {
        this(context,null);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
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
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = getWidth();
        height = getHeight();

        radius = Math.min(width, height) / 2;//半径
        rectF = new RectF(-radius, -radius, radius, radius);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.translate(width / 2, height / 2);
        canvas.drawColor(Color.TRANSPARENT);

        canvas.rotate(degree);
        //绘制两个半圆

        canvas.drawArc(rectF, 90, 180, true, blackPaint);
        canvas.drawArc(rectF, -90, 180, true, whitePaint);

        float smallRadius = radius / 2;
        animate().setInterpolator(new TimeInterpolator() {
            @Override
            public float getInterpolation(float v) {
                return 0;
            }
        });
        canvas.drawCircle(0, -smallRadius, smallRadius, blackPaint);
        canvas.drawCircle(0, smallRadius, smallRadius, whitePaint);

        canvas.drawCircle(0, -smallRadius, smallRadius / 4, whitePaint);
        canvas.drawCircle(0, smallRadius, smallRadius / 4, blackPaint);
    }

    public void setDegrees(float degree) {
        this.degree = degree;
        invalidate();
    }
}
