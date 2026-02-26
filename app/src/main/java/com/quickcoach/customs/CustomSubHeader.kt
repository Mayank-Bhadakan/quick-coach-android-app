package com.quickcoach.customs

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import com.quickcoach.databinding.CustomSubheaderBinding

class CustomSubHeader @JvmOverloads constructor(
    context: Context,
    attrs : AttributeSet? = null,
    defStyleAttr:Int= 0
):
    RelativeLayout(context, attrs, defStyleAttr) {
        private var binding : CustomSubheaderBinding=
            CustomSubheaderBinding.inflate(LayoutInflater.from(context) , this , true)

    init {
        binding.btnLeft.setOnClickListener {
            if (context is AppCompatActivity)
                context.finish()
        }
    }

    fun get(): CustomSubheaderBinding{
        return binding
    }

    fun setTitle(title: Int){
        binding.txtTitle.text = context.resources.getText(title)
    }

    fun setBtnLeft(boolean: Boolean){
        binding.btnLeft.visibility = if (boolean) View.VISIBLE else View.GONE
    }

}