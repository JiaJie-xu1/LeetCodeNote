package com.univers.canvas_view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.os.Build
import android.util.AttributeSet
import android.view.View
import androidx.annotation.RequiresApi
import com.univers.leetcodenote.R
import java.lang.reflect.Array


class henCoderView2 : View {
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var paint1 = Paint(Paint.ANTI_ALIAS_FLAG)
    var paint2 = Paint(Paint.ANTI_ALIAS_FLAG)
    var paint3 = Paint(Paint.ANTI_ALIAS_FLAG)
    var paint4 = Paint(Paint.ANTI_ALIAS_FLAG)
    var paint5 = Paint(Paint.ANTI_ALIAS_FLAG)

    var measuredCount: Int = 0
    var measuredWidth: FloatArray = floatArrayOf(0F)

    var shader = LinearGradient(
        200F, 200F, 600F, 600F, Color.parseColor("#E91E63"),
        Color.parseColor("#2196F3"), Shader.TileMode.CLAMP
    )

    var shader2 = RadialGradient(
        400F, 800F, 80F, Color.parseColor("#E91E63"),
        Color.parseColor("#2196F3"), Shader.TileMode.CLAMP
    )

    var shader3 = SweepGradient(
        400F, 1200F, Color.parseColor("#E91E63"),
        Color.parseColor("#2196F3")
    )

    private var bitmap: Bitmap = BitmapFactory.decodeResource(resources,
        R.drawable.ic_launcher
    )
    var shader4: BitmapShader = BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)

    var path = Path()
    var path1 = Path()
    var path2 = Path()

    //    var pathEffect: PathEffect = CornerPathEffect(20F)
//    var pathEffect: PathEffect = DiscretePathEffect(20F,5F)
    var dashPathEffect: PathEffect = DashPathEffect(floatArrayOf(20F, 10F, 5F, 10F), 0F)
    var discreteEffect: PathEffect = DiscretePathEffect(20F, 5F)

    //    var pathEffect = SumPathEffect(dashPathEffect,discreteEffect)
    var pathEffect = ComposePathEffect(dashPathEffect, discreteEffect)

    var bitmap2 = BitmapFactory.decodeResource(resources,
        R.drawable.test
    )
    var filter2 = BlurMaskFilter(50F, BlurMaskFilter.Blur.NORMAL)

    //emoji表情
    var text1 = "Hello ,Jay！morning~ \uD83C\uDDE8\uD83C\uDDF3"
    val text2 = "三个月内你胖了"
    val text3 = "4.5"
    val text4 = "公斤"
    var paint6 = Paint(Paint.ANTI_ALIAS_FLAG)
    var paint7 = Paint(Paint.ANTI_ALIAS_FLAG)

    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        setLayerType(LAYER_TYPE_SOFTWARE, null)
    }

    @SuppressLint("NewApi")
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.run {
//            paint.color = Color.parseColor("#009688");
//            drawRect(30F, 30F, 230F, 180F, paint);
//
//            paint.color = Color.parseColor("#FF9800");
//            paint.strokeWidth = 15F
//            drawLine(300F, 30F, 450F, 180F, paint);
//
//            paint.color = Color.parseColor("#E91E63")
//            paint.textSize = 40F
//            drawText("HenCoder", 500F, 130F, paint)

//            paint.shader = shader
//            canvas.drawCircle(400F, 400f, 200F, paint)

//            paint.shader = shader2
//            canvas.drawCircle(400F, 800F, 190F, paint)
//
//            paint.shader = shader3
//            canvas.drawCircle(400F, 1200F, 190F, paint)
//
            paint1.color = Color.parseColor("#000000")
            paint1.style = Paint.Style.STROKE
            paint1.strokeWidth = 25F
            path1.moveTo(210F, 210F)
            path1.lineTo(400F, 210F)
            path1.lineTo(210F, 400F)
            paint1.strokeJoin = Paint.Join.ROUND
            canvas.drawPath(path1, paint1)

            paint.color = Color.parseColor("#000000")
            paint.style = Paint.Style.STROKE
            paint.strokeWidth = 2F
            path.moveTo(100F, 1000F)
            path.lineTo(100F, 100F)
            path.moveTo(100F, 1000F)
            path.lineTo(1000F, 1000F)
            canvas.drawPath(path, paint)

            paint.textSize = 50F
            canvas.drawText("0", 100F, 1050F, paint)
            canvas.drawTextOnPath("Hello World~", path, 0F, 0F, paint)

            paint2.color = Color.parseColor("#754a23")
            paint2.style = Paint.Style.STROKE
            paint2.strokeWidth = 5F
            paint2.textSize = 50F
            path2.moveTo(200F, 900F)
            path2.lineTo(500F, 300F)
            path2.lineTo(700F, 500F)
            path2.lineTo(850F, 150F)
            path2.lineTo(960F, 400F)
            paint2.pathEffect = pathEffect
            canvas.drawPath(path2, paint2)

            paint3.textSize = 60F
            paint4.textSize = 60F
            paint5.textSize = 60F
//            paint3.setShadowLayer(10F, 0F, 0F, Color.BLUE)
            paint3.typeface = Typeface.createFromAsset(context.assets, "Satisfy-Regular.ttf")
            paint4.typeface = Typeface.createFromAsset(context.assets, "Satisfy-Regular.ttf")
            paint3.isStrikeThruText = true
            canvas.drawText("Hello ,Beautiful World！", 120F, 1200F, paint3)
            paint3.isStrikeThruText = false
            canvas.drawText("My name is JayXu~", 120F, 1350F, paint3)
            paint4.isUnderlineText = true
            canvas.drawText("I want to go where has many flowers", 120F, 1450F, paint4)
            paint3.letterSpacing = 0.2f
            canvas.drawText("I want to leave here.", 120F, 1550F, paint3)

            paint5.isUnderlineText = true
            measuredCount = paint5.breakText(text1, 0, text1.length, true, 300F, measuredWidth)
            paint5.getRunAdvance(text1, 0, text1.length, 0, text1.length, false, text1.length)
            canvas.drawText(text1, 0, measuredCount, 130F, 500F, paint5)
            paint5.getRunAdvance(text1, 0, text1.length, 0, text1.length, false, text1.length - 3)
            measuredCount = paint5.breakText(text1, 0, text1.length, true, 400F, measuredWidth)
            canvas.drawText(text1, 0, measuredCount, 130F, 500F + paint5.fontSpacing, paint5)
            measuredCount = paint5.breakText(text1, 0, text1.length, true, 500F, measuredWidth)
            canvas.drawText(text1, 0, measuredCount, 130F, 500F + paint5.fontSpacing * 2, paint5)
            measuredCount = paint5.breakText(text1, 0, text1.length, true, 600F, measuredWidth)
            canvas.drawText(text1, 0, measuredCount, 130F, 500F + paint5.fontSpacing * 3, paint5)
            canvas.drawText(text1, 130F, 500F + paint5.fontSpacing * 4, paint5)

            paint6.textSize = 50F
            paint6.color = Color.parseColor("#000000")
            canvas.drawText(text2, 120F, 1650F, paint6)
            paint7.textSize = 100F
            paint7.color = Color.parseColor("#FF1209")
            paint7.isFakeBoldText = true
            canvas.drawText(text3, 120F + paint6.measureText(text2), 1650F, paint7)
            canvas.drawText(
                text4,
                120F + paint6.measureText(text2) + paint7.measureText(text3),
                1650F,
                paint6
            )
//            paint4.color = Color.parseColor("#754a23")
//            paint4.style = Paint.Style.STROKE
//            paint4.maskFilter = filter2
//            canvas.drawBitmap(bitmap,300F,300F,paint4)

        }

    }


}