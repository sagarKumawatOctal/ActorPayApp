package com.octal.actorpay.Utils

import android.view.animation.Animation



import android.os.Build

import android.content.Context
import android.util.AttributeSet

import androidx.viewpager.widget.ViewPager

import java.lang.Exception


class WrappingViewPager : ViewPager {
    var  width: Int?=0
    constructor(context: Context?) : super(context!!) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(
        context!!, attrs
    ) {
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        var heightMeasureSpec = heightMeasureSpec
        var height = 0
        width = widthMeasureSpec
        if (childCount > currentItem) {
            val child = getChildAt(currentItem)
            child.measure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED))
            val h = child.measuredHeight
            if (h > height) height = h
        }
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY)
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

   fun onRefresh() {
        try {
            var height = 0
            if (childCount > currentItem) {
                val child = getChildAt(currentItem)
                width?.let { child.measure(it, MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED)) }
                val h = child.measuredHeight
                if (h > height) height = h
            }
            val heightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY)
            var layoutParams = this.layoutParams
            layoutParams.height = heightMeasureSpec
            layoutParams = layoutParams
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}