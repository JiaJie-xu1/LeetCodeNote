package com.univers.canvas_view

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator
import com.univers.leetcodenote.R

class HenCoderView4 : View {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var bitmap: Bitmap = BitmapFactory.decodeResource(
        resources,
        R.drawable.test
    )
    var path = Path()
    var matrixs = Matrix()
    var camera = Camera()
    var degree: Int = 0

    var animator = ObjectAnimator.ofInt(this, "degree", 0, 180)


    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        animator.duration = 2500
        animator.interpolator = LinearInterpolator()
        animator.repeatCount = ValueAnimator.INFINITE
        animator.repeatMode = ValueAnimator.REVERSE
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        animator.start()
    }


    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        animator.end()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

//        canvas?.run {
//            save()
//            canvas.clipRect(150F, 150f, 250f, 250f)
//            drawBitmap(bitmap, 100F, 100F, paint)
//            canvas.restore()
//        }


//        canvas?.run {
//
////            matrix.reset();
////            matrix.postTranslate(200F, 200F)
////            matrix.postRotate(90F, 100 + bitmap.width / 2F, 100 + bitmap.height / 2F)
//
//            save()
//            canvas.translate(200F,200F)
//            camera.rotateX(25F)
//            camera.applyToCanvas(canvas)
//            camera.setLocation(0F, 0F, 50F)
//            camera.restore()
////            scale(1.5f, 1.5f, 100 + bitmap.width / 2F, 100 + bitmap.height / 2F)
//            rotate(90F, 100 + bitmap.width / 2F, 100 + bitmap.height / 2F)
////            concat(matrixs)
//            path.addCircle(
//                100 + bitmap.width / 2F,
//                100 + bitmap.height / 2F,
//                bitmap.width / 2F,
//                Path.Direction.CW
//            )
//            clipPath(path)
//            drawBitmap(bitmap, 100F, 100F, paint)
//            restore()
//        }
        canvas?.run {
            val bitmapWidth = bitmap.width
            val bitmapHeight = bitmap.height

            val centerX = bitmapWidth / 2f
            val centerY = bitmapHeight / 2f

            val x = centerX - bitmapWidth / 2f
            val y = centerY - bitmapHeight / 2f

            save()
            camera.save()
            canvas.translate(centerX, centerY)
            camera.applyToCanvas(canvas)

            canvas.translate(-centerX, -centerY)
            camera.restore()

            canvas.drawBitmap(bitmap, x, y, paint)
            canvas.restore()

        }
    }
}