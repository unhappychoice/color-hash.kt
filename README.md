# color-hash.kt
[![CircleCI](https://circleci.com/gh/unhappychoice/color-hash.kt.svg?style=shield)](https://circleci.com/gh/unhappychoice/color-hash.kt)
[![](https://jitpack.io/v/unhappychoice/color-hash.kt.svg)](https://jitpack.io/#unhappychoice/color-hash.kt)
[![codecov](https://codecov.io/gh/unhappychoice/color-hash.kt/branch/master/graph/badge.svg)](https://codecov.io/gh/unhappychoice/color-hash.kt)

https://github.com/zenozeng/color-hash implementation by Kotlin/Android

## Usage

```kotlin
val color = ColorHash(
    "some string", // string which you want to use as hash
    listOf(0.35, 0.5, 0.65), // lightness list
    listOf(0.35, 0.5, 0.65), // saturation list
    minHue: Int = 0,
    maxHue: Int = 360
).toColor() // returns Android Color class

// or just use
val color2 = "some hash string".toColor()
```

## Installation

```groovy
allprojects {
    repositories {
        maven { url "https://jitpack.io" }
    }
}

dependencies {
    compile 'com.github.unhappychoice:color-hash.kt:$version'
}
```

## LISENCE
see [LISENCE](./LISENCE)
