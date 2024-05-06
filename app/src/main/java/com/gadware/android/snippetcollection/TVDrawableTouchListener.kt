package com.gadware.android.snippetcollection

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MotionEvent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.gadware.android.snippetcollection.databinding.ActivityTvdrawableTouchListenerBinding

class TVDrawableTouchListener : AppCompatActivity() {
    private lateinit var binding: ActivityTvdrawableTouchListenerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTvdrawableTouchListenerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.inputName.setOnTouchListener(
        object : RightDrawableOnTouchListenerTv(binding.inputName) {

            override fun onDrawableTouch(event: MotionEvent?): Boolean {
                Toast.makeText(this@TVDrawableTouchListener, "Touched", Toast.LENGTH_SHORT).show()
                return false
            }
        })
    }
}