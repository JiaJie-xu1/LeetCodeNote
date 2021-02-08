package com.univers.canvas_view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.univers.leetcodenote.R


class HenCoderView3 : View {
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var bitmap: Bitmap
    private var bitmap2: Bitmap
    var mode = PorterDuff.Mode.DST_OUT
    var xfermode = PorterDuffXfermode(mode)
//    var maskFilter1: MaskFilter = BlurMaskFilter(100F, BlurMaskFilter.Blur.NORMAL)
//    var maskFilter2: MaskFilter = BlurMaskFilter(200F, BlurMaskFilter.Blur.INNER)
//    var maskFilter3: MaskFilter = BlurMaskFilter(50F, BlurMaskFilter.Blur.OUTER)
//    var maskFilter4: MaskFilter = BlurMaskFilter(25F, BlurMaskFilter.Blur.SOLID)

    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
//        setLayerType(LAYER_TYPE_SOFTWARE, paint)
        bitmap = BitmapFactory.decodeResource(resources,
            R.drawable.rect_bitmap
        )
        bitmap2 = BitmapFactory.decodeResource(resources,
            R.drawable.circle_bitmap
        )
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.run {
            val saved = saveLayer(null, null, Canvas.ALL_SAVE_FLAG)
            drawBitmap(bitmap, 100F, 30F, paint)
            paint.xfermode = xfermode
            drawBitmap(bitmap2, 70F, 60F, paint)
            paint.xfermode = null// 用完及时清除 Xfermode

            canvas.restoreToCount(saved)

        }
//        paint.maskFilter = maskFilter1
//        canvas?.drawBitmap(bitmap, 100F, 50F, paint)
//
//        paint.maskFilter = maskFilter2
//        canvas?.drawBitmap(bitmap, bitmap.width + 200F, 50F, paint)
//
//        paint.maskFilter = maskFilter3
//        canvas?.drawBitmap(bitmap, 100F, bitmap.height + 100F, paint)
//
//        paint.maskFilter = maskFilter4
//        canvas?.drawBitmap(bitmap, bitmap.width + 200F, bitmap.height + 100F, paint)

    }

}