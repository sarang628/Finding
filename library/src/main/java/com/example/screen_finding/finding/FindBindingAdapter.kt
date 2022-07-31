package com.example.screen_finding.finding

import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import androidx.databinding.BindingAdapter
import com.example.screen_finding.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

@BindingAdapter("app:findButtonAnimation")
fun findButtonAnimation(button: FloatingActionButton, boolean: Boolean?) {
    boolean?.let {
        val animation = AnimationUtils.loadAnimation(
            button.context, if (it) R.anim.slide_card_up else R.anim.slide_card_down
        )
        button.startAnimation(animation)
        button.visibility = if (it) View.GONE else View.VISIBLE
    }
}