package com.quickcoach.customs

import android.content.Context
import android.graphics.Canvas
import android.graphics.Matrix
import android.hardware.Camera
import android.util.AttributeSet
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.widget.RelativeLayout
import androidx.drawerlayout.widget.DrawerLayout

class ZoomableImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0

):
    DrawerLayout(context , attrs, defStyleAttr ) {

        private var mScaleDetector: ScaleGestureDetector? = null
        private var mGestureDetector: GestureDetector? = null

    private var mCurrentScale = 1.0f
    private var mCurrentMatrix: Matrix? = null
    private var mMidX = 0f
    private var mMidY = 0f
    private var onZoomChangeListener: OnZoomChangeListener? = null
    private var objContext: Context = context

    init {
        val mScaleListener: ScaleGestureDetector.OnScaleGestureListener = object : ScaleGestureDetector.SimpleOnScaleGestureListener() {
            override fun onScale(detector: ScaleGestureDetector): Boolean {
                var scaleFactor =   detector.scaleFactor
                val newScale = mCurrentScale * scaleFactor

                //private from zooming out more than original
                if (newScale > 1.0f){
                    // we initialize this lazily so than we don't have to register(and force the user to unregister)
                    //a global layout listener in this view

                    if(mMidX == 0.0f){
                        mMidX = width / 2.0f
                    }

                    if (mMidY == 0.0f){
                        mMidY = height / 2.0f
                    }

                    mCurrentScale = newScale
                    // support pinch
                    mCurrentMatrix!!.postScale(scaleFactor, scaleFactor , mMidX , mMidY)
                    invalidate()
                }
                else{
                    scaleFactor = 1.0f / mCurrentScale
                    reset()
                }

                if (onZoomChangeListener != null && scaleFactor != 1.0f){
                    onZoomChangeListener!!.onZoomChange(mCurrentScale)
                }
                return true

            }
        }
        mScaleDetector  = ScaleGestureDetector(getContext() , mScaleListener)
        mCurrentMatrix = Matrix()

        val mGestureListener: GestureDetector.SimpleOnGestureListener = object : GestureDetector.SimpleOnGestureListener(){
            override fun onScroll(
                e1:MotionEvent,
                e2: MotionEvent,
                distanceX: Float,
                distanceY: Float
            ): Boolean{
                //support drag
                //disable drag when normal scale
                if (mCurrentScale > 1.0f){
                    mCurrentMatrix!!.postTranslate(-distanceX , -distanceY)
                    invalidate()
                }
                return true
            }
        }
        mGestureDetector = GestureDetector(getContext() , mGestureListener)
    }

    fun SetOnZoomChangeListener(listener: OnZoomChangeListener?){
        onZoomChangeListener = listener
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        SetOnZoomChangeListener(null)
    }

    override fun onDraw(c: Canvas) {
        val saveCount = c.save()
        c.concat(mCurrentMatrix)
        super.onDraw(c)
        c.restoreToCount(saveCount)
    }

    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        mGestureDetector!!.onTouchEvent(ev)
        return super.onTouchEvent(ev)
    }

    /**
     * Resets the zoom of the attached image.
     * This has no effect if the image has been destroyed
     */

    private fun reset() {
        mCurrentMatrix!!.reset()
        mCurrentScale = 1.0f
        invalidate()
    }

    /**
     * A listener interface for when the zoom scale changes
     */

    interface OnZoomChangeListener{

        /**
         * Callback method getting triggered when the zoom scale changes.
         * This is not called when the zoom is programmatically reset
         *
         * @param scale the new scale
         */
        fun onZoomChange(scale: Float)
    }

}


