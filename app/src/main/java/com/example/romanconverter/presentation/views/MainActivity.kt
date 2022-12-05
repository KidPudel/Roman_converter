package com.example.romanconverter.presentation.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.romanconverter.databinding.ActivityMainBinding
import com.example.romanconverter.presentation.view_models.RomanConverterViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // lazy initialization of viewmodel
        val romanConverterViewModel: RomanConverterViewModel by viewModels()

        val resultDialog = AlertDialog.Builder(this)
            .setTitle("Result")
            .setPositiveButton("OK") {_, _->
                Toast.makeText(this, "Thanks :3", Toast.LENGTH_SHORT).show()
            }.create()

        var convertedRoman: Int?

        binding.convertButton.setOnClickListener {
            convertedRoman = romanConverterViewModel.convertRoman(binding.roman.text.toString())
            if (convertedRoman == null) {
                binding.romanLayout.error = "Not a roman digit"
            }
            else {
                binding.romanLayout.error = null
                resultDialog.setMessage("${binding.roman.text.toString().uppercase()} is equals to $convertedRoman")
                resultDialog.show()
            }
            binding.roman.setText("")
        }


    }
}