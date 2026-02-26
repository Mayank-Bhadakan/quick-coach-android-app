package com.quickcoach.customs

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.viewpager.widget.ViewPager
import com.quickcoach.R
import com.quickcoach.databinding.CustomFooterBinding

class CustomFooter @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
    ):
        LinearLayout(context , attrs , defStyleAttr) , View.OnClickListener{
        private var pager: ViewPager? = null

        var binding: CustomFooterBinding = CustomFooterBinding.inflate(LayoutInflater.from(context) , this , true)

    init {
        changeBackground(0)
        binding.imgSettings.setOnClickListener(this)
        binding.imgCoaches.setOnClickListener(this)
        binding.imgEvents.setOnClickListener(this)
        binding.imgHome.setOnClickListener(this)
        binding.imgLevels.setOnClickListener(this)
    }

    fun setPager(pager: ViewPager){
        this.pager = pager
    }

    private fun changeBackground(position: Int , isChangePager:Boolean = true) {
        binding.imgHome.setImageResource(if (position == 0) R.drawable.ic_home_red_selected else R.drawable.ic_home_unselect)
        binding.imgCoaches.setImageResource(if (position == 1) R.drawable.ic_coach_red_selected else R.drawable.ic_coaches_gray_unselected)
        binding.imgLevels.setImageResource(if (position == 2) R.drawable.ic_level_red_selected else R.drawable.ic_level_gray_unselect)
        binding.imgEvents.setImageResource(if (position == 3) R.drawable.ic_event_red_selected else R.drawable.ic_events_unselected)
        binding.imgSettings.setImageResource(if (position == 4) R.drawable.ic_settings_red_selected else R.drawable.ic_settings_unselected)

        if (pager != null && isChangePager)
        {
            pager!!.setCurrentItem(position , true)
        }

    }

    override fun onClick(v: View?) {
        when (v?.id)
        {
            R.id.imgHome ->{
                changeBackground(0)
            }
            R.id.imgCoaches -> {
                changeBackground(1)
            }
            R.id.imgLevels -> {
                changeBackground(2)
            }
            R.id.imgEvents -> {
                changeBackground(3)
            }
            R.id.imgSettings -> {
                changeBackground(4)
            }
        }
    }

}
