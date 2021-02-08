package com.univers.canvas_view;

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
    private RectF rect;
    private float radius;
    float width;
    float height;

    public LikeView(Context context) {
        this(context, null);
    }

    public LikeView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LikeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        width = getWidth();
        height = getHeight();

        whitePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        whitePaint.setColor(Color.WHITE);

        blackPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        blackPaint.setColor(Color.BLACK);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        radius = Math.min(width, height) / 2f - 101;
        rect = new RectF(-radius, -radius, radius, radius);

        canvas.translate(width / 2, height / 2);

        canvas.drawColor(Color.GRAY);
        canvas.rotate(degrees);

        //绘制区域
        canvas.drawArc(rect, 90, 180, true, blackPaint);            //绘制黑色半圆
        canvas.drawArc(rect, -90, 180, true, whitePaint);           //绘制白色半圆

        //绘制两个小圆
        float smallRadius = radius / 2;                                //小圆半径为大圆的一半
        canvas.drawCircle(0, -smallRadius, smallRadius, blackPaint);
        canvas.drawCircle(0, smallRadius, smallRadius, whitePaint);

        //绘制鱼眼（两个更小的圆）
        canvas.drawCircle(0, -smallRadius, smallRadius / 4f, whitePaint);
        canvas.drawCircle(0, smallRadius, smallRadius / 4f, blackPaint);
    }

    public void setDegrees(float degrees) {
        this.degrees = degrees;
        invalidate();
    }
}