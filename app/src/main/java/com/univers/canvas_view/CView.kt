package com.univers.canvas_view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.text.Layout
import android.text.StaticLayout
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View

class CView : View {
    var textPaint = TextPaint(Paint.ANTI_ALIAS_FLAG)
    var text = "Hello,\nWorld"
    lateinit var staticLayout: StaticLayout

    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    {
        textPaint.textSize = 60F
        staticLayout = StaticLayout(text,textPaint,600,Layout.Alignment.ALIGN_NORMAL, 1F, 0F,true)

    }

    override fun onDraw(canvas: Canvas?) {
//        canvas?.drawColor(Color.CYAN)
        super.onDraw(canvas)
        canvas?.run {
            drawColor(Color.CYAN)
            save()
            translate(50F,40F)
            staticLayout.draw(this)
            canvas.restore()
        }
    }
}