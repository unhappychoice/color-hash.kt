package com.github.unhappychoice.colorhash

import android.graphics.Color

data class RGB(val red: Int, val green: Int, val blue: Int) {
    fun toHex(): String {
        return "#" + listOf(red, green, blue)
                .reversed()
                .map {
                    when {
                        it < 16 -> "0${Integer.toHexString(it.toInt())}"
                        else -> Integer.toHexString(it.toInt())
                    }
                }.reduce { s, acc -> acc + s }
    }

    fun toColor(): Int = Color.rgb(red, green, blue)
}