package com.github.unhappychoice.colorhash

import android.graphics.Color
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricGradleTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricGradleTestRunner::class)
@Config(sdk = intArrayOf(21), constants = BuildConfig::class)
class ColorTest {
    @Test fun String_toColor_should_return_android_color() {
        val color = "color hash".toColor()
        assert(color == Color.rgb(185, 224, 108))
    }

    @Test fun ColorHash_toColor_should_return_android_color() {
        val color = ColorHash("color hash").toColor()
        assert(color == Color.rgb(185, 224, 108))
    }

    @Test fun RGB_toColor_should_return_android_color() {
        val color = RGB(Triple(100, 100, 100)).toColor()
        assert(color == Color.rgb(100, 100, 100))
    }

    @Test fun HSL_toColor_should_return_android_color() {
        val color = HSL(Triple(100.0, 100.0, 100.0)).toColor()
        assert(color == Color.HSVToColor(floatArrayOf(100.0f,100.0f, 100.0f)))
    }
}