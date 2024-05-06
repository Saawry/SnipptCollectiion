package com.gadware.android.snippetcollection

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gadware.android.snippetcollection.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnDrawableTouch.setOnClickListener { startActivity(Intent(this,TVDrawableTouchListener::class.java)) }
        binding.btnFilter.setOnClickListener { startActivity(Intent(this,TextViewTypeNSearchDD::class.java)) }
    }
}