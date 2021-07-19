package com.paint.bindingtoolbarfragment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.paint.bindingtoolbarfragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.title.text = "Test"
        binding.buttonInContainer.text = "In container"
        binding.layout.buttonInLayout.setOnClickListener {
            val intent = Intent(this, WithFragmentActivity::class.java)
            startActivity(intent)
        }
    }
}