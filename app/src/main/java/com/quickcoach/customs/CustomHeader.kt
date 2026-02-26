package com.quickcoach.customs

import android.content.Context
import android.content.Intent
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.quickcoach.databinding.CustomHeaderBinding
import com.quickcoach.utils.ID
import com.quickcoach.utils.Pref

class CustomHeader @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    RelativeLayout(context, attrs, defStyleAttr) {

    private var pager: ViewPager? = null

    private var binding: CustomHeaderBinding =
        CustomHeaderBinding.inflate(LayoutInflater.from(context), this, true)

    init {

        binding.imgLeft.setOnClickListener {

            if (context is AppCompatActivity)
                context.finish()
        }

//        binding.imgRight.setOnClickListener {
//
//            if (context is HomeActivity && pager != null)
//                pager!!.currentItem = 0
//            else {
//                context.startActivity(Intent(context, HomeActivity::class.java))
//                (context as AppCompatActivity).finishAffinity()
//            }
//        }


    }

    fun setTitle(title: Int) {
        binding.txtTitleHeader.text = context.resources.getString(title)
    }



//    fun setTitle(title: String) {
//        binding.txtTitleHeader.text = title
//    }


    fun backButtonVisibile(boolean: Boolean) {
        binding.imgLeft.visibility = if (boolean) View.VISIBLE else View.GONE
    }

    fun iconVisible(boolean: Boolean) {
        binding.imgRight.visibility = if (boolean) View.VISIBLE else View.GONE
    }

    fun setPager(pager: ViewPager?) {
        this.pager = pager
    }
    fun get()  : CustomHeaderBinding{
       return binding
    }

    fun setBlackLabel(boolean: Boolean){
        binding.llHeaderName.visibility = if(boolean) View.VISIBLE else View.GONE
    }

}