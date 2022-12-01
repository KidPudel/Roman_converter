package com.example.romanconverter.domain.use_cases

import com.google.common.truth.Truth.assertThat
import org.junit.Test

internal class RomanConverterUseCaseTest {
    @Test
    fun `converted XIV equals 14`() {
        val convertedRoman = RomanConverterUseCase().convertToDecimal("XIV")
        assertThat(convertedRoman).isEqualTo(14)
    }
}