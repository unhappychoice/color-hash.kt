package com.github.unhappychoice.colorhash

import org.junit.Assert.assertEquals
import org.junit.Test

class RGBTest {

    @Test
    fun toHex_shouldReturnHexForRGB() {
        val hex = RGB(255, 64, 0).toHex()
        assertEquals("#ff4000", hex)
    }

    @Test
    fun toHex_shouldReturn6DigitsHexForSmallRGBValues() {
        val hex = RGB(1, 15, 16).toHex()
        assertEquals("#010f10", hex)
    }
}
