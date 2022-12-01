package com.example.romanconverter.presentation.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.romanconverter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.convertButton.setOnClickListener {
            if (binding.roman.text.toString() != binding.roman.text.toString().uppercase()) {
                binding.romanLayout.error = "Wrong format"
            }
        }

    }
}