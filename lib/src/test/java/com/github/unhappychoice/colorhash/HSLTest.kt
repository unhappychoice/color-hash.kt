package com.github.unhappychoice.colorhash

import org.junit.Assert.assertEquals
import org.junit.Test

class HSLTest {

    @Test
    fun toRGB_shouldReturnCorrectRGB_case1() {
        val rgb = HSL(0.0, 1.0, 0.5).toRGB()
        assertEquals(RGB(255, 0, 0), rgb)
    }

    @Test
    fun toRGB_shouldReturnCorrectRGB_case2() {
        val rgb = HSL(120.0, 1.0, 0.75).toRGB()
        assertEquals(RGB(128, 255, 128), rgb)
    }

    @Test
    fun toRGB_shouldReturnCorrectRGB_case3() {
        val rgb = HSL(240.0, 1.0, 0.25).toRGB()
        assertEquals(RGB(0, 0, 128), rgb)
    }

    @Test
    fun toRGB_shouldReturnCorrectRGB_case4() {
        val rgb = HSL(330.0, 1.0, 0.75).toRGB()
        assertEquals(RGB(255, 128, 191), rgb)
    }
}
