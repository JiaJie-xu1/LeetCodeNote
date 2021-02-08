package com.univers.canvas_view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.os.Build
import android.util.AttributeSet
import android.view.View
import androidx.annotation.RequiresApi

class henCoderView1 : View {
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var points =
        floatArrayOf(0f, 0f, 50f, 50f, 50f, 100f, 100f, 50f, 100f, 100f, 150f, 50f, 150f, 100f)

    var path = Path()
    val text = "Hello World!"

    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        paint.color = Color.parseColor("#88880000")
        paint.style = Paint.Style.STROKE

    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawCircle(300F, 300F, 200F, paint)

        paint.style = Paint.Style.FILL
        canvas?.drawRect(100F, 520F, 520F, 920F, paint)

        paint.style = Paint.Style.STROKE
        canvas?.drawRect(550F, 520F, 950F, 920F, paint)

        paint.strokeWidth = 20F
        paint.strokeCap = Paint.Cap.ROUND
        canvas?.drawPoint(100F, 950F, paint)
        canvas?.drawPoint(160F, 950F, paint)
        canvas?.drawPoint(220F, 950F, paint)

        canvas?.drawPoints(points, 2, 8, paint)

        paint.style = Paint.Style.FILL
        canvas?.drawOval(100F, 1100F, 520F, 1400F, paint)

        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 10F
        canvas?.drawOval(550F, 1100F, 950F, 1400F, paint)

        val points = floatArrayOf(
            20f,
            20f,
            120f,
            20f,
            70f,
            20f,
            70f,
            120f,
            20f,
            120f,
            120f,
            120f
        )
        canvas?.drawLines(points, paint)

        paint.style = Paint.Style.FILL
        canvas?.drawArc(100F, 1450F, 520F, 1750F, -90F, 100F, true, paint)
        canvas?.drawArc(100F, 1450F, 520F, 1750F, 20F, 140F, true, paint)
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 3F
        canvas?.drawArc(100F, 1450F, 520F, 1750F, 170F, 90F, true, paint)

        paint.style = Paint.Style.STROKE
        path.moveTo(750F, 1450F)
        path.lineTo(950F, 1750F)
        path.lineTo(550F, 1750F)
        path.close()
        canvas?.drawPath(path, paint)

        paint.style = Paint.Style.STROKE
        paint.textSize = 22F
        canvas?.drawText(text, 600F, 50F, paint)
        paint.textSize = 36F
        canvas?.drawText(text, 600F, 95F, paint)
        paint.textSize = 60F
        canvas?.drawText(text, 600F, 170F, paint)
        paint.textSize = 84F
        canvas?.drawText(text, 600F, 265F, paint)


    }


}