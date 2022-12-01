package com.example.romanconverter.presentation.view_models


import androidx.lifecycle.ViewModel
import com.example.romanconverter.domain.use_cases.RomanConverterUseCase

class RomanConverterViewModel : ViewModel() {
    private val romanConverterUseCase = RomanConverterUseCase()

    fun convertRoman(roman: String): Int? {
        return romanConverterUseCase.convertToDecimal(roman.toRomanOrNull())
    }

    /**
     *  if roman containing not roman digits -> null
     *  else convert all char to uppercase
     */
    fun String.toRomanOrNull(): String? {
        return if (all { "IVXLCDM".contains(it.uppercase()) }) this.uppercase() else null
    }
}
