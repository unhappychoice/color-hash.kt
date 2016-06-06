package com.github.unhappychoice.colorhash

import android.graphics.Color

class HSL(val value: Triple<Double, Double, Double>) {
    fun toRGB(): RGB {
        val (hue, saturation, lightness) = this.value

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

        return RGB(Triple(rgb[0], rgb[1], rgb[2]))
    }

    fun toColor(): Int {
        val array = this.value.let {
            floatArrayOf(it.first.toFloat(), it.second.toFloat(), it.third.toFloat())
        }
        return Color.HSVToColor(array)
    }

    override fun equals(other: Any?): Boolean = other is HSL && other.value == value
}