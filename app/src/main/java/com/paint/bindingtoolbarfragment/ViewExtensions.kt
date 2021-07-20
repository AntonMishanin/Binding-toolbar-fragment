package com.paint.bindingtoolbarfragment

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.view.View

fun View.hideWithAnimation(){
    this.animate()
        .alpha(0.0f)
        .setDuration(1300)
        .setListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                super.onAnimationEnd(animation)
                //this@hideWithAnimation.clearAnimation()
                //this@hideWithAnimation.visibility = View.INVISIBLE
            }
        })
}

fun View.showWithAnimation(){
    this.animate()
        .alpha(1.0f)
        .setDuration(1300)
        .setListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                super.onAnimationEnd(animation)
                //this@showWithAnimation.clearAnimation()
                //this@showWithAnimation.visibility = View.VISIBLE
            }
        })
}