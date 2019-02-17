package ir.cafebazzar.nearby.ui.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import androidx.annotation.Nullable
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.DrawableCompat
import ir.cafebazzar.nearby.R


/**
 * Created by mohsen on 8/29/2017.
 */

class ExtraTextView : AppCompatTextView {

    private var drawableResourceId = 0
    private var drawableWidth = 0
    private var drawableHeight = 0
    private var drawablePosition: DrawablePosition? = null
    private var drawableTint = 0
    private var isDrawableFit = false
    private val roundedCornerBackgroundPaint = Paint()
    private val roundedCornerBorderPaint = Paint()
    private val roundedCornerRect = RectF()
    private var roundedCornerRadius: Int = 0
    private var roundedCornerBorderSize: Int = 0
    private var roundedCornerBorderColor: Int = 0
    private var roundedCornerBackgroundColor: Int = 0

    private enum class DrawablePosition {
        LEFT, TOP, RIGHT, BOTTOM
    }

    constructor(context: Context) : super(context) {
        init(context, null, 0)
    }

    constructor(context: Context, @Nullable attrs: AttributeSet) : super(context, attrs) {
        init(context, attrs, 0)
    }

    constructor(context: Context, @Nullable attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context, attrs, defStyleAttr)
    }

    private fun init(context: Context, attrs: AttributeSet?, defStyleAttr: Int) {
        if (attrs == null) {
            return
        }

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.ExtraTextView, defStyleAttr, 0)


        drawableResourceId = typedArray.getResourceId(R.styleable.ExtraTextView_ext_txt_drawable, 0)
        drawableWidth = typedArray.getDimensionPixelSize(R.styleable.ExtraTextView_ext_txt_drawableWidth, 0)
        drawableHeight = typedArray.getDimensionPixelSize(R.styleable.ExtraTextView_ext_txt_drawableHeight, 0)
        drawablePosition = DrawablePosition.values()[typedArray.getInt(R.styleable.ExtraTextView_ext_txt_drawablePosition, DrawablePosition.LEFT.ordinal)]
        drawableTint = typedArray.getColor(R.styleable.ExtraTextView_ext_txt_drawableTint, Color.TRANSPARENT)
        isDrawableFit = typedArray.getBoolean(R.styleable.ExtraTextView_ext_txt_drawableFit, false)

        roundedCornerRadius = typedArray.getDimensionPixelSize(R.styleable.ExtraTextView_ext_txt_cornerRadius, 0)
        roundedCornerBorderSize = typedArray.getDimensionPixelSize(R.styleable.ExtraTextView_ext_txt_cornerBorderSize, 0)
        roundedCornerBorderColor = typedArray.getColor(R.styleable.ExtraTextView_ext_txt_cornerBorderColor, Color.TRANSPARENT)
        roundedCornerBackgroundColor = typedArray.getColor(R.styleable.ExtraTextView_ext_txt_cornerBackgroundColor, Color.TRANSPARENT)

        typedArray.recycle()
    }

    override protected fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        if (drawableResourceId == 0) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec)
            return
        }

        updateDrawable()
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    private fun updateDrawable() {
        val drawable = ResourcesCompat.getDrawable(getResources(), drawableResourceId, null)
        updateDrawable(drawable)
    }

    private fun updateDrawable(drawable: Drawable?) {
        if (drawable == null) {
            return
        }

        val target = DrawableCompat.wrap(drawable)
        if (drawableTint != Color.TRANSPARENT) {
            DrawableCompat.setTint(target.mutate(), drawableTint)
        }

        target.setBounds(0, 0, getDrawableWidth(), getDrawableHeight())

        when (drawablePosition) {
            ExtraTextView.DrawablePosition.TOP -> setCompoundDrawables(null, target, null, null)
            ExtraTextView.DrawablePosition.RIGHT -> setCompoundDrawables(null, null, target, null)
            ExtraTextView.DrawablePosition.BOTTOM -> setCompoundDrawables(null, null, null, target)
            else -> setCompoundDrawables(target, null, null, null)
        }
    }

    override protected fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)

        var fitPadding: Int? = null
        if (isDrawableFit) {
            val textWidth = getPaint().measureText(getText().toString())
            fitPadding = Math.round((getWidth() - textWidth) / 2)
            setCompoundDrawablePadding((-fitPadding)!! + getDrawableWidth())
        }

        when (drawablePosition) {
            ExtraTextView.DrawablePosition.LEFT -> if (fitPadding != null) setPadding(fitPadding, getPaddingTop(), 0, getPaddingBottom())
            ExtraTextView.DrawablePosition.RIGHT -> if (fitPadding != null) setPadding(0, getPaddingTop(), fitPadding, getPaddingBottom())
        }

    }

    private fun getDrawableWidth(): Int {
        return if (drawableWidth > 0) drawableWidth else getMeasuredWidth()
    }

    private fun getDrawableHeight(): Int {
        return if (drawableHeight > 0) drawableHeight else getMeasuredWidth()
    }

    override protected fun onDraw(canvas: Canvas) {
        if (needDrawRoundCorner()) drawRoundCorner(canvas)
        super.onDraw(canvas)
    }

    protected fun needDrawRoundCorner(): Boolean {
        return roundedCornerRadius > 0 && (roundedCornerBackgroundColor != Color.TRANSPARENT || roundedCornerBorderColor != Color.TRANSPARENT)
    }

    private fun drawRoundCorner(canvas: Canvas) {
        roundedCornerBackgroundPaint.reset()
        roundedCornerBorderPaint.reset()
        roundedCornerRect.setEmpty()

        roundedCornerRect.set(roundedCornerBorderSize.toFloat(), roundedCornerBorderSize.toFloat(), getMeasuredWidth().toFloat() - roundedCornerBorderSize, getMeasuredHeight().toFloat() - roundedCornerBorderSize)

        if (roundedCornerBackgroundColor != Color.TRANSPARENT) {
            roundedCornerBackgroundPaint.isAntiAlias = true
            roundedCornerBackgroundPaint.color = roundedCornerBackgroundColor
            roundedCornerBackgroundPaint.style = Paint.Style.FILL
            canvas.drawRoundRect(roundedCornerRect, roundedCornerRadius.toFloat(), roundedCornerRadius.toFloat(), roundedCornerBackgroundPaint)
        }

        if (roundedCornerBorderColor != Color.TRANSPARENT) {
            roundedCornerBorderPaint.isAntiAlias = true
            roundedCornerBorderPaint.color = roundedCornerBorderColor
            roundedCornerBorderPaint.strokeWidth = roundedCornerBorderSize.toFloat()
            roundedCornerBorderPaint.style = Paint.Style.STROKE
            canvas.drawRoundRect(roundedCornerRect, roundedCornerRadius.toFloat(), roundedCornerRadius.toFloat(), roundedCornerBorderPaint)
        }
    }

    fun getDrawableResourceId(): Int {
        return drawableResourceId
    }

    fun setDrawableResourceId(drawableResourceId: Int) {
        this.drawableResourceId = drawableResourceId
        requestLayout()
    }

    fun setDrawableTint(drawableTint: Int) {
        this.drawableTint = drawableTint
        requestLayout()
    }

    fun setRoundedCornerBorderColor(borderColor: Int) {
        roundedCornerBorderColor = borderColor
        invalidate()
    }

    fun setRoundedCornerBackgroundColor(backgroundColor: Int) {
        roundedCornerBackgroundColor = backgroundColor
        invalidate()
    }
}