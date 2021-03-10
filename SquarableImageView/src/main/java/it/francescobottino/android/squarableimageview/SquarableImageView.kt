package it.francescobottino.android.squarableimageview

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView

open class SquarableImageView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
): AppCompatImageView(context, attrs, defStyleAttr) {

    enum class SquaringType {
        NONE, WIDTH, HEIGHT
    }

    var squareOn: SquaringType

    init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.SquarableImageView, defStyleAttr, 0).apply {

            try {
                squareOn = SquaringType.values()[getInt(R.styleable.SquarableImageView_squareOn, 0)]
            } finally {
                recycle()
            }
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val width = measuredWidth
        val height = measuredHeight

        val chosenSide = when(squareOn) {
            SquaringType.NONE -> return
            SquaringType.HEIGHT -> height
            SquaringType.WIDTH -> width
        }

        if(width != height) {
            setMeasuredDimension(chosenSide, chosenSide)
        }
    }
}