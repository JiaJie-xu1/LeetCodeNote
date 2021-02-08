package com.univers.canvas_view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

class MyProgress : View {
    private val radius = 150F
    var arcRectF = RectF()
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var progress = 50

    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        paint.textSize = 32F
        paint.textAlign = Paint.Align.CENTER
    }

    fun setProgress2(progress2 : Int){
        progress = progress2
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val centerX = width / 2
        val centerY = height / 2

        paint.color = Color.parseColor("#E91E78")
        paint.style = Paint.Style.STROKE
        paint.strokeCap = Paint.Cap.ROUND
        paint.strokeWidth = 22F

        arcRectF.set(centerX - radius, centerY - radius, centerX + radius, centerY + radius)
        canvas.drawArc(arcRectF, 270F, progress * 3.6f, false, paint)

        paint.color = Color.WHITE
        paint.style = Paint.Style.FILL

        canvas.drawText(
            "$progress %",
            centerX.toFloat(), centerY - (paint.ascent() + paint.descent()) / 2, paint
        )
    }
}