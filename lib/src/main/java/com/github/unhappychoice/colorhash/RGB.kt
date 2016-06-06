package com.github.unhappychoice.colorhash

import android.graphics.Color

class RGB(val value: Triple<Int, Int, Int>) {
    fun toHex(): String {
        return "#" + this.value.toList()
                .reversed()
                .map {
                    when {
                        it < 16 -> "0${Integer.toHexString(it.toInt())}"
                        else -> Integer.toHexString(it.toInt())
                    }
                }.reduce { s, acc -> acc + s }
    }

    fun toColor(): Int = Color.rgb(value.first, value.second, value.third)

    override fun equals(other: Any?): Boolean = other is RGB && other.value == value
}