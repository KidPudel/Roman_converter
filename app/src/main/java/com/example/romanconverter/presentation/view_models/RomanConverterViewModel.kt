package com.example.romanconverter.presentation.view_models


import androidx.lifecycle.ViewModel
import com.example.romanconverter.domain.use_cases.RomanConverterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RomanConverterViewModel @Inject constructor(
    val romanConverterUseCase: RomanConverterUseCase
    ) : ViewModel() {

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
