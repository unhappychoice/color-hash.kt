package com.github.unhappychoice.colorhash

import org.junit.Assert.assertEquals
import org.junit.Test

class ColorHashTest {

    @Test
    fun colorHash_hasDefaultProperties() {
        val colorHash = ColorHash("hash")
        assertEquals("hash", colorHash.string)
        assertEquals(listOf(0.35, 0.5, 0.65), colorHash.lightness)
        assertEquals(listOf(0.35, 0.5, 0.65), colorHash.saturation)
        assertEquals(0, colorHash.minHue)
        assertEquals(360, colorHash.maxHue)
    }

    @Test
    fun toHSL_shouldReturnHashColorBasedOnDefaultLightnessAndSaturation() {
        val hsl = ColorHash("").toHSL()
        assertEquals(0.35, hsl.saturation, 0.001)
        assertEquals(0.35, hsl.lightness, 0.001)
    }

    @Test
    fun toHSL_shouldReturnHashColorBasedOnGivenLightnessAndSaturation() {
        val hsl = ColorHash("", listOf(0.5), listOf(0.5)).toHSL()
        assertEquals(0.5, hsl.saturation, 0.001)
        assertEquals(0.5, hsl.lightness, 0.001)
    }

    @Test
    fun toHSL_shouldReturnHashColorBasedOnGivenLightnessArrayAndSaturationArray() {
        val hsl = ColorHash("", listOf(0.9, 1.0), listOf(0.9, 1.0)).toHSL()
        assertEquals(0.9, hsl.saturation, 0.001)
        assertEquals(0.9, hsl.lightness, 0.001)
    }

    @Test
    fun toHexString_shouldReturnHexString() {
        val hex = ColorHash("hex color").toHexString()
        assertEquals("#c5b587", hex)
    }

    @Test
    fun toRGB_shouldReturnRGB() {
        val rgb = ColorHash("hex color").toRGB()
        assertEquals(RGB(197, 181, 135), rgb)
    }
}
