package com.github.unhappychoice.colorhash

import android.graphics.Color

data class HSL(val hue: Double, val saturation: Double, val lightness: Double) {
    fun toRGB(): RGB {
        val h = hue / 360f

        val q = when {
            (lightness < 0.5) -> lightness * (1f + saturation)
            else -> lightness + saturation - lightness * saturation
        }

        val p = 2f * lightness - q

        val rgb = listOf(h + 1f / 3f, h, h - 1f / 3f).map { color ->
            val co = when {
                color < 0 -> color + 1
                color > 1 -> color - 1
                else -> color
            }

            val c = when {
                (co < 1f / 6f) -> p + (q - p) * 6.0 * co
                (co < 0.5) -> q.toDouble()
                (co < 2f / 3f) -> p + (q - p) * 6.0 * ( 2f / 3f - co)
                else -> p.toDouble()
            }
            Math.max(0, Math.round(c * 255).toInt())
        }

        return RGB(rgb[0], rgb[1], rgb[2])
    }

    fun toColor(): Int {
        val array = floatArrayOf(hue.toFloat(), saturation.toFloat(), lightness.toFloat())
        return Color.HSVToColor(array)
    }
}