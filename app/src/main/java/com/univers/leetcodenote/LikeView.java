package com.univers.leetcodenote;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * Created by Jay.Xu
 *
 * @since 2020/12/20
 */
public class LikeView extends View {
    private Paint whitePaint;
    private Paint blackPaint;
    private float degrees = 0;

    public LikeView(Context context) {
        super(context);
    }

    public LikeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LikeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        whitePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        whitePaint.setColor(Color.WHITE);

        blackPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        blackPaint.setColor(Color.BLACK);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();

        canvas.translate(width / 2, height / 2);

        canvas.drawColor(Color.GRAY);
        canvas.rotate(degrees);

        //绘制两个半圆
        int radius = Math.min(width, height) / 2 - 101;
        RectF rect = new RectF(-radius, -radius, radius, radius);   //绘制区域
        canvas.drawArc(rect, 90, 180, true, blackPaint);            //绘制黑色半圆
        canvas.drawArc(rect, -90, 180, true, whitePaint);           //绘制白色半圆

        //绘制两个小圆
        int smallRadius = radius / 2;	                            //小圆半径为大圆的一半
        canvas.drawCircle(0, -smallRadius, smallRadius, blackPaint);
        canvas.drawCircle(0, smallRadius, smallRadius, whitePaint);

        //绘制鱼眼（两个更小的圆）
        canvas.drawCircle(0, -smallRadius, smallRadius / 4, whitePaint);
        canvas.drawCircle(0, smallRadius, smallRadius / 4, blackPaint);
    }

    public void setDegrees(float degrees){
        this.degrees = degrees;
        invalidate();
    }
}
