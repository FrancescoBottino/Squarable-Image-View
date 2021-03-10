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

    private var _squareOn: SquaringType = SquaringType.NONE
    var squareOn: SquaringType
        get() = _squareOn
        set(value) {
            _squareOn = value
            requestLayout()
            invalidate()
        }

    init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.SquarableImageView, defStyleAttr, 0).apply {

            try {
                _squareOn = SquaringType.values()[getInt(R.styleable.SquarableImageView_squareOn, 0)]
            } finally {
                recycle()
            }
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val width = measuredWidth
        val height = measuredHeight

        if(_squareOn == SquaringType.NONE || width == height) return

        val chosenSide = if(_squareOn == SquaringType.WIDTH) width else height
        setMeasuredDimension(chosenSide, chosenSide)
    }
}