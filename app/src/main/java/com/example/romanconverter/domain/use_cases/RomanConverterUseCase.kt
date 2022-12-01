package com.example.romanconverter.domain.use_cases

class RomanConverterUseCase {
    private var previousDigit = 0
    private var currentDigit = 0
    private var convertedRoman = 0

    fun convertToDecimal(roman: String): Int {
        val convenientRoman = roman.reversed()
        // IX
        // XI -> if next is lesser then subtract

        convenientRoman.forEach {
            when (it) {
                'I' -> currentDigit = 1
                'V' -> currentDigit = 5
                'X' -> currentDigit = 10
                'L' -> currentDigit = 50
                'C' -> currentDigit = 100
                'D' -> currentDigit = 500
                'M' -> currentDigit = 1000
            }
            convertedRoman += if(currentDigit < previousDigit) -currentDigit else +currentDigit
        }

        return convertedRoman
    }
}